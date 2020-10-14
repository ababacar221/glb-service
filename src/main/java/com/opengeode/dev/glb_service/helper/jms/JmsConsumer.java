package com.opengeode.dev.glb_service.helper.jms;
import com.opengeode.dev.glb_jms.model.ErrorLog;
import com.opengeode.dev.glb_service.service.ElasticsearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class JmsConsumer {

    @Value("${elasticsearch.destination}")
    private String index;

    @Autowired
    private ElasticsearchService elasticsearchService;

    @JmsListener(destination = "${glb.activemq.queue}", containerFactory="jsaFactory")
    public void receive(ErrorLog errorLog) throws IOException, InterruptedException {
        System.out.println("Received Message: " + errorLog);
        log.info("Received Message: " + errorLog);
        elasticsearchService.ingest_data(errorLog,index);
    }


}
