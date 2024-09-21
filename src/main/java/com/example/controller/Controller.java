package com.example.controller;

import com.example.entities.UserInfo;
import com.example.github.Github;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private @Autowired Github github;

    @GetMapping("/principal")
    public String getUserPrincipal() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/csrf")
    public String getCsrfToken(HttpServletRequest request) {
        return ((CsrfToken)request.getAttribute("_csrf")).getToken();
    }

    @GetMapping("/userinfo/{username}")
    public UserInfo getUserInfo(@RequestParam("username") String userName, @RequestHeader("X-CSRF-TOKEN") String csrf){
        return github.getUserInfo(userName);
    }
}
