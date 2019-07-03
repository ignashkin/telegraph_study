/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorohov.mytelegraph.repository;


import com.gorohov.mytelegraph.domain.Post;
import com.gorohov.mytelegraph.service.Transcriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ignat_nakhai
 */
public class PostRepository {
    private HashMap<String, Post> posts = new HashMap<String,Post>();
    
    public String save(Post post) {
        String id = Transcriptor.transcript(post.getTitle().replace(" ","-"));
        posts.put(id, post);
        return id;
        
    }
    
    public void readFromFile() {
        try {
         FileInputStream fileIn = new FileInputStream("posts.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         this.posts = (HashMap) in.readObject();
         in.close();
         fileIn.close();
        }
        catch (IOException i) {
         i.printStackTrace();
        } catch (ClassNotFoundException c) {
         System.out.println("Map class not found");
         c.printStackTrace();
        }  
    }
    
    public void WriteToFile() {
        try{
           FileOutputStream fileOut =
           new FileOutputStream("posts.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(this.posts);
           out.close();
           fileOut.close();
        }
        catch(IOException ioe){   
           ioe.printStackTrace();
        }
    }
    
    public Post getById(String id) {
       
        return posts.get(id);
    }   
}
