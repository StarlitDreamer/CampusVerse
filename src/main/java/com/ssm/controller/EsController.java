package com.ssm.controller;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EsController {

    @Autowired
    private RestHighLevelClient client;

    @RequestMapping("/createIndex")
    public Boolean createIndex(String indexName) {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.mapping(
                "{\n" +
                        "  \"properties\": {\n" +
                        "    \"message\": {\n" +
                        "      \"type\": \"text\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);
        try {
            client.indices().create(request, RequestOptions.DEFAULT);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 访问索引并执行查询的方法
    @RequestMapping("/searchIndex")
    public String searchIndex(String indexName, String queryString) {
        // 创建搜索请求
        SearchRequest searchRequest = new SearchRequest(indexName);

        // 构建查询条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        QueryBuilder query = QueryBuilders.queryStringQuery(queryString); // 使用 queryString 查询
        sourceBuilder.query(query);
        searchRequest.source(sourceBuilder);

        try {
            // 执行查询
            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            // 获取查询结果并转换为 JSON 格式
            SearchHits hits = searchResponse.getHits();
            StringBuilder result = new StringBuilder();
            for (SearchHit hit : hits) {
                result.append(hit.getSourceAsString()).append("\n");
            }

            return result.toString(); // 返回查询结果的字符串
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "查询失败";
    }
}

