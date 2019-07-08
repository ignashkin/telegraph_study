/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorohov.mytelegraph.domain;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.web.util.HtmlUtils;

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
        this.title = HtmlUtils.htmlEscape(title);
    }
    
    public void setAutor(String autor) {
        this.autor = HtmlUtils.htmlEscape(autor);
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public void setText(String text) {
        Parser parser = Parser.builder().build();
        String insertText = HtmlUtils.htmlEscape(text);
        Node document = parser.parse(insertText);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        this.text = renderer.render(document);
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
