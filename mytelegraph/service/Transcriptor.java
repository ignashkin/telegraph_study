/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorohov.mytelegraph.service;

/**
 *
 * @author ignat_nakhai
 */
import com.ibm.icu.text.Transliterator;
public class Transcriptor {
   public static final String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
    
    
    public static String transcript(String title) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String result = toLatinTrans.transliterate(title);
        return result;
    }
    
}
