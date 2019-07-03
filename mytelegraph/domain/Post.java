/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorohov.mytelegraph.domain;

/**
 *
 * @author ignat_nakhai
 */
public class Post implements java.io.Serializable {
    private String title;
    private String autor;
    private String text;
    private String uuid;
    
       
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public String getText() {
        return text;
    }
    
    public String getUuid() {
        return uuid;
    }
    
}
