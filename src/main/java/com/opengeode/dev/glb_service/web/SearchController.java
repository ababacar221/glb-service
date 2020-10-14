package com.opengeode.dev.glb_service.web;

import com.opengeode.dev.glb_jms.model.ErrorLog;
import com.opengeode.dev.glb_service.service.ElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @GetMapping("/")
    public List<ErrorLog> get_all_data() throws IOException{
        return elasticsearchService.get_all_data();
    }
}
