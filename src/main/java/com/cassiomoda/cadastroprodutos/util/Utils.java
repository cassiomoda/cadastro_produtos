/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cassiomoda.cadastroprodutos.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author cassi
 */
public class Utils {
 
    public static String formatarData(Timestamp data) {
        
        if (data != null) {
            return new SimpleDateFormat("dd/MM/yyyy").format(data);
        } else {
            return "";
        }
    }
    
    public static String getPath() {
        
        try {
            File file = new File("");
            return file.getCanonicalPath();
        } catch (IOException e) {
            return "Erro: " + e.getMessage();
        }
    }
    
    public static Connection getConnection() {
        
        try {
            String caminhoApp = getPath();
            
            if (caminhoApp.indexOf("Erro") < 0) {
                
                String dbDriver = "";
                String dbUrl = "";
                String dbUser = "";
                String dbPass = "";
                
                File xml = new File(caminhoApp + "\\src\\main\\resources\\META-INF\\persistence.xml");
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(xml);
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("property");
                
                for (int i = 0; i < nodeList.getLength(); i++) {
                    
                    Node node = nodeList.item(i);
                    
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        
                        Element element = (Element) node;
                        String tagName = element.getAttribute("name");
                        String tagValue = element.getAttribute("value");
                        
                        if (tagName.contains("url")) dbUrl = tagValue;
                        if (tagName.contains("user")) dbUser = tagValue;
                        if (tagName.contains("driver")) dbDriver = tagValue;
                        if (tagName.contains("password")) dbPass = tagValue;
                    }
                }
                
                if (dbDriver.isEmpty() || dbUrl.isEmpty() || dbUser.isEmpty() || dbPass.isEmpty()) {
                    return null;
                }
                
                Class.forName(dbDriver);
                return DriverManager.getConnection(dbUrl, dbUser, dbPass);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.print("Erro: " + e.getMessage() + ". Ao tentar recuperar a conexão.");
            return null;
        }
    }
}
