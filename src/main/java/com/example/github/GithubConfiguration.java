package com.example.github;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class GithubConfiguration {


    @Bean
    RestClient client(RestClient.Builder builder, ClientHttpRequestInterceptor interceptor){
        return builder.baseUrl("https://api.github.com/").requestInterceptor(interceptor).build();
    }
}
