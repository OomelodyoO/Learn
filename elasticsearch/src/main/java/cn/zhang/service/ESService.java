package cn.zhang.service;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by zhangzhixing on 2017/7/4.
 */
public class ESService extends BaseService {
    public ESService() {
    }

    public ESService(TransportClient transportClient) {
        this.transportClient = transportClient;
    }


    public IndexResponse index() throws IOException {
        IndexResponse response = transportClient.prepareIndex("school", "teacher", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("name", "melody")
                        .field("age", 30)
                        .field("sex", "男")
                        .endObject()
                )
                .get();
        return response;
    }

    public GetResponse get() {
        GetResponse response = transportClient.prepareGet("school", "teacher", "1").get();
        return response;
    }

    public DeleteResponse delete() {
        DeleteResponse response = transportClient.prepareDelete("school", "teacher", "1").get();
        return response;
    }
}
