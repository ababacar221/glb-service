package com.opengeode.dev.glb_service.service;

import com.opengeode.dev.glb_jms.model.ErrorLog;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface ElasticsearchService {

    HttpStatus ingest_data(String pathname) throws IOException,InterruptedException;

    HttpStatus ingest_data(List<ErrorLog> exf, String index) throws InterruptedException,IOException;


    HttpStatus ingest_data(ErrorLog obj, String index) throws InterruptedException,IOException;

    List<ErrorLog> get_all_data() throws IOException;

    void createIndexIfNotPresent(String indexName, File indexFile);

    void createIndex(String indexName, File indexFile) throws IOException;

    void readJsonSchemaConfig(Collection<File> files) throws IOException;

}
