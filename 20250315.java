例外処理を用意していないとエラーになる
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileWriter fw = new FileWriter("data.txt");
        /* : */
    }
}
例外java.io.IOExceptionは報告されません。スローするには、捕捉または宣言する必要があります

以下のようにtry-catch文でException系例外の発生に備える
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            /* : */
        } catch(IOException e) {
            System.out.println("エラーが発生しました。");
        }
    }
}


ざっくりと例外を捕捉する
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            fw.write("hello!");
            fw.close();
        } catch(Exception e) {
            System.out.println("何らかの例外が発生しました");
        }
    }
}

開いたファイルを閉じるとエラーが起こる
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("data.txt");
            fw.write("hello!");
        } catch (Exception e) {
            System.out.println("エラーです");
        }
        fw.close();
    }
}
