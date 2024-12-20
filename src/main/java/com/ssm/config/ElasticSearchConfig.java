package com.ssm.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient esRestClient() {
        // ES连接地址，集群写多个
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("slave1", 9200, "http"),
                new HttpHost("slave2", 9200, "http"),
                new HttpHost("slave3", 9200, "http")
        );
        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }
}