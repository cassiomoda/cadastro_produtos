/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cassiomoda.cadastroprodutos.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cassi
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    private Integer id;
    
    private String nome;
    
    @Column(name = "data_cadastro")
    private Timestamp dataCadastro;
    
    @Column(name = "data_alteracao")
    private Timestamp dataAlteracao;
    
    @ManyToOne
    @JoinColumn(name = "categoria")
    private Categoria categoria;
    
    public Produto() {
    }

    public Produto(Integer id, String nome, Timestamp dataCadastro, Timestamp dataAlteracao, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Timestamp getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Timestamp dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", dataCadastro="
                + dataCadastro + ", dataAlteracao=" + dataAlteracao 
                + ", categoria=" + categoria + '}';
    }
}
