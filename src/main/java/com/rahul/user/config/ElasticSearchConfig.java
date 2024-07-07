package com.rahul.user.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.rahul.user.repository.elasticsearch")
public class ElasticSearchConfig {

    @Bean
    public RestClient restClient() throws Exception {

        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder);
        return builder.build();
    }
}
