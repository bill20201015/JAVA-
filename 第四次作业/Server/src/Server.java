import tools.InfixToSuffix;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sk
 * @version 1.0
 */
public class Server {
    private ServerSocket ss = null;

    public Server() {
        try {
            InfixToSuffix infixToSuffix = new InfixToSuffix();
            //设置端口
            ss = new ServerSocket(9998);
            System.out.println("设置监听端口为9999，服务器正在启动");

            //d等待客户端连接
            Socket socket = ss.accept();
            System.out.println("客户端连接成功，客户端名字为"+socket.getInetAddress().toString());

            //获取输入流
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //获取输出流
            OutputStream outputStream = socket.getOutputStream();

            PrintStream ps = new PrintStream(outputStream);

            String text = bufferedReader.readLine();
            int n = text.length();
            String[] expression = new String[n];
            for (int i = 0; i < n; i++) {
                expression[i] = Character.toString(text.charAt(i));
            }
            String[] expression1 = new String[]{"(", "2", "+", "3",")", "*", "6"};
            for (int i = 0; i < n; i++) {
                System.out.println(expression1[i] + " " + expression[i]);
            }
            String[] str = infixToSuffix.translation(expression);

            double ret = infixToSuffix.calculateSuffix(str);
            ps.println("客户端接收到消息:" + ret);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
