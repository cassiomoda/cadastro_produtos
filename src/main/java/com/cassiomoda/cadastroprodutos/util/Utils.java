/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cassiomoda.cadastroprodutos.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
}
