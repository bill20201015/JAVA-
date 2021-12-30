import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
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
public class getNovels {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\shangkai\\Desktop\\java应用技术基础\\novels.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println(file.getName());
        }
        System.out.println(file.getName());

        //模仿客户端发出请求，主要使用HttpClients工具
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for (int i = 0; i < 1000; i++) {
            String uri = "https://m.soshuw.com/JueMeiZongCaiDiTieShenKuangYi/"+(856822 + i)+".html";// 需要爬取的页面uri
            HttpGet httpGet = new HttpGet(uri);

            //回车，发出请求。返回请求
            CloseableHttpResponse response = httpClient.execute(httpGet);

            //解析请求
            if(response.getStatusLine().getStatusCode() == 200){// 计算机网络中的200好像代表成功访问什么的
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                String html = content;// 这是未解析的html代码， 需要后续处理
                // 处理如下这样的数据， <meta charset="UTF-8">
                //<title>第1章 山边小村_凡人修仙传免费阅读全文小说无防盗章节_作者忘语_搜书网手机版(m.soshuw.com)</title>

                //第一步，将内容解析为document类
                Document document = Jsoup.parse(html);

                //第二步，根据我们前端html页面的标签解析数据
                //这里观察不同网站的格式即可，需要修改select里的数据
                Elements elements1 = document.select("h1[class=headline]");
                String title = elements1.text();
                Elements elements2 = document.select("div[class=content]").select("p");
                String mainText = elements2.text();
                System.out.println(title);
                //System.out.println(mainText);

                // 写入text文件中
                FileWriter fileWriter = new FileWriter("C:\\Users\\shangkai\\Desktop\\java应用技术基础\\novels.txt", true);
                fileWriter.write(title);
                fileWriter.write("\n");
                fileWriter.write(mainText);
                fileWriter.write("\n\n"); // 在章和标题间留一些空格便于阅读

                fileWriter.close();
                System.out.println("ok");
            }
        }


    }


}


