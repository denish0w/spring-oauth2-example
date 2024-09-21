package com.example.entities;

public record UserInfo (String id,
    String login,
    String url,
    String name,
    String html_url,
    String type,
    String created_at,
    String updated_at){}
