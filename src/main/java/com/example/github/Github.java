package com.example.github;

// https://docs.github.com/en/rest/repos?apiVersion=2022-11-28

import com.example.entities.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class Github {

    private @Autowired RestClient client;

    public UserInfo getUserInfo(String name) {
        return client.get()
                .uri("/users/"+name)
                .accept(MediaType.APPLICATION_JSON)
                .header("X-GitHub-Api-Version", "2022-11-28")
                .retrieve()
                .body(UserInfo.class);
    }
}
