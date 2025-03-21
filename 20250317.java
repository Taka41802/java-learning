ストリーム
ファイルから1文字ずつ読み込む（実務では例外処理も書く）
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("data.txt");
        int input = fr.read();
        while (input != -1) {
            System.out.print((char)input);
            input = fr.read();
        }
        fr.close();
    }
}

ファイルに1文字ずつ書き込む
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("data.txt");
        fw.write('そ');
        fw.write('れ');
        fw.write('で');
        fw.write('は');
        fw.close();
    }
}

wedページの取得
import java.io.InputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        URL u = new URL("https://book.impress.co.jp/");
        InputStream is = u.openStream();
        int i = is.read();
        while (i != -1) {
            char c = (char)i;
            System.out.print(c);
            i = is.read();
        }
    }
}
実行する以下のようになる
Exception in thread "main" java.net.UnknownHostException: book.impress.co.jp
at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:567)
at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327)
at java.base/java.net.Socket.connect(Socket.java:760)
at java.base/sun.security.ssl.SSLSocketImpl.connect(SSLSocketImpl.java:304)
at java.base/sun.security.ssl.BaseSSLSocketImpl.connect(BaseSSLSocketImpl.java:181)
at java.base/sun.net.NetworkClient.doConnect(NetworkClient.java:183)
at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:531)
at java.base/sun.net.www.http.HttpClient.openServer(HttpClient.java:636)
at java.base/sun.net.www.protocol.https.HttpsClient.<init>(HttpsClient.java:264)
at java.base/sun.net.www.protocol.https.HttpsClient.New(HttpsClient.java:377)
at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.getNewHttpClient(AbstractDelegateHttpsURLConnection.java:193)
at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1243)
at java.base/sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1129)
at java.base/sun.net.www.protocol.https.AbstractDelegateHttpsURLConnection.connect(AbstractDelegateHttpsURLConnection.java:179)
at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1691)
at java.base/sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1615)
at java.base/sun.net.www.protocol.https.HttpsURLConnectionImpl.getInputStream(HttpsURLConnectionImpl.java:223)
at java.base/java.net.URL.openStream(URL.java:1325)
at Main.main(Main.java:7)

DBに接続してSQLを送信する
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        String dburl = "jdbc:h2:~/test";
        String sql = "INSERT INTO EMPLOYEES(NAME) VALUES('aoki')";
        Connection conn = DriverManager.getConnection(dburl);
        conn.createStatement().executeUpdate(sql);
        conn.close();
    }
}

javaではGUIも作ることができる
import java.awt.FlowLayout;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("はじめてのGUI");
        JLabel label = new JLabel("Hello World!!");
        JButton button = new JButton("押してね");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}

webアプリケーションを作る場合はサーブレットを使う
import java.io.*;
        import java.util.Date;
import javax.servlet.http.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Date d = new Date();
        PrintWriter w = res.getWriter();
        res.setContentType("text/html");
        w.write("<html><body>");
        w.write("Today is " + d.toString());
        w.write("</body></html>");
    }
}
