
import java.io.*;
import java.net.Socket;

/**
 * @author sk
 * @version 1.0
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9998);

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ps.println("(2+3)*6");// 输入表达式

        String text = bufferedReader.readLine();
        System.out.println("表达式答案为：" + text);


    }
}
