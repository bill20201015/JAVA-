import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author sk
 * @version 1.0
 */
public class demo {
    public static void main(String[] args) throws IOException {
        //打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //输入网站地址
        HttpGet httpGet = new HttpGet("https://www.mengruan.com/weicheng/27266.htm");

        //回车，发出请求。返回请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //解析请求
        if(response.getStatusLine().getStatusCode() == 200){
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf8");

            System.out.println(content);
        }


    }
}
