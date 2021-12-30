import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sk
 * @version 1.0
 */
public class getMath {
    public static void main(String[] args) throws IOException {
        //打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //输入网站地址
        HttpGet httpGet = new HttpGet("https://kaoyan.eol.cn/kao_shi_da_gang/shuxue/202109/t20210916_2155978.shtml");

        //回车，发出请求。返回请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(123);
        //解析请求
        if(response.getStatusLine().getStatusCode() == 200){
            System.out.println(123);
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf8");

            Document document = Jsoup.parse(content);

            Elements elements = document.select("div[class=TRS_Editor]").select("p");
            String text = "2020考研数学大纲\n";
            for (Element o : elements) {
                text += o.text();
                text += "\n";
            }

            File file =  new File("C:\\Users\\shangkai\\Desktop\\math.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(text);


            System.out.println(text);
        }
    }
}
