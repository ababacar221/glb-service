package com.opengeode.dev.glb_service.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ElasticsearchConfig {

    private static final Logger LOG = LoggerFactory.getLogger(ElasticsearchConfig.class);

    @Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    private RestHighLevelClient restHighLevelClient;


    @Bean
    public RestHighLevelClient createInstance() {
        return buildClient();
    }

    private RestHighLevelClient buildClient() {
        try {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient
                            .builder(
                            new HttpHost(EsHost, EsPort, "http"),
                            new HttpHost(EsHost, EsPort+1, "http")));
        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw e;
        }
        return restHighLevelClient;
    }
}
