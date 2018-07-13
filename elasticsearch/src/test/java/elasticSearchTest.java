import cn.zhang.service.ESService;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zhangzhixing on 2017/7/4.
 */
public class elasticSearchTest {
    ESService esService;

    @Before
    public void before() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch_zhangzhixing")
                .build();
        TransportClient transportClient = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        esService = new ESService(transportClient);
    }

    @Test
    public void indexTest() throws IOException {
        esService.index();
    }

    @Test
    public void getTest() {
        esService.get();
    }

    @Test
    public void deleteTest() {
        esService.delete();
    }
}
