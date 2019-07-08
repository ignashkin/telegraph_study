/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorohov.mytelegraph.controller;

/**
 *
 * @author Ignat
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gorohov.mytelegraph.domain.Post;
import com.gorohov.mytelegraph.repository.PostRepository;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;
 
@Controller
public class HomeController {
    private final  PostRepository postRepository = new PostRepository();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("textButton", "Add new post");
        return "index";
    }
    
    @RequestMapping(value = {"/","/{id}/edit"}, method=RequestMethod.POST)
    public String addNewPost(@RequestParam(value="text") String text, @RequestParam(value="title") String title, @RequestParam(value="autor") String autor, HttpServletRequest request, HttpServletResponse response) {
        Post post = new Post();
        post.setTitle(title);
        post.setAutor(autor);
        post.setText(text);
        post.setUuid(request.getRequestedSessionId());
        postRepository.readFromFile();
        String id = postRepository.save(post);
        postRepository.WriteToFile();
        Cookie cookie = new Cookie("sessionID",request.getRequestedSessionId());
        response.addCookie(cookie);
     return "redirect:/"+id;   
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPostPage(@PathVariable String id,@CookieValue(value = "sessionID", required = false) Cookie cookie, Model model) {
        postRepository.readFromFile();
        Post post = postRepository.getById(id);
        if (post != null) {
        
            model.addAttribute("title", post.getTitle());
            model.addAttribute("autor", post.getAutor());
            model.addAttribute("text", post.getText());
            if (cookie != null) {
            model.addAttribute("allow_edit",cookie.getValue().equals(post.getUuid()));
            } else {
                model.addAttribute("allow_edit",false);
            }
            model.addAttribute("id",id);
            return "/pattern";
        }
        return "/404";
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editPostPage(@PathVariable String id,@CookieValue(value = "sessionID", required = false) Cookie cookie, Model model) {
        postRepository.readFromFile();
        Post post = postRepository.getById(id);
        if (post != null) {
            if (cookie != null) {
                if (cookie.getValue().equals(post.getUuid())) {
                    model.addAttribute("title", post.getTitle());
                    model.addAttribute("autor", post.getAutor());
                    model.addAttribute("text", post.getText());
                    model.addAttribute("textButton", "Save post");
                    return "/index";
                }
            }
            return "/unauth";
        }
        return "/404";
    }
}
