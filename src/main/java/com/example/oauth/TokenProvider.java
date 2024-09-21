package com.example.oauth;

import com.example.github.GithubConfiguration;
import com.example.github.GithubProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("OAuth2TokenProvider")
public class TokenProvider implements ClientHttpRequestInterceptor {

    private @Autowired OAuth2AuthorizedClientService service;
    private @Autowired GithubConfiguration githubConfiguration;
    private @Autowired GithubProperties githubProperties;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String token = getToken();
        if(token != null){
            request.getHeaders().set(HttpHeaders.AUTHORIZATION, "Bearer "+token);
            return execution.execute(request,body);
        }
        throw new IllegalStateException("No token available");
    }

    public String getToken(){
        OAuth2AuthorizedClient client =  service.loadAuthorizedClient("github", githubProperties.getPrincipalName());
        return client.getAccessToken().getTokenValue();
    }
}
