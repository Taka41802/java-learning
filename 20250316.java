例外インスタンスを自分で投げる
public class Person {
    int age;
    public void setAge(int age) {
        if (age < 0) {     // ここで引数をチェック
            throw new IllegalArgumentException("年齢は正の数を指定すべきです。指定値=" + age);
        }
        this.age = age;    // 問題ないなら、フィールドに値をセット
    }
}

public class Main {
    public static void main(String[] args){
        Person p = new Person();
        p.setAge(-128);
    }
}


Exception in thread "main" java.lang.IllegalArgumentException: 年齢は正の数を指定すべきです。指定値=-128
at Person.setAge(Person.java:5)
at Main.main(Main.java:4)

public class UnsupportedMusicFileException extends Exception {
    // エラーメッセージを受け取るコンストラクタ
    public UnsupportedMusicFileException(String msg) {
        super(msg);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // 試験的に例外を発生させる
            throw new UnsupportedMusicFileException("未対応のファイルです");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

練習問題
public class Main {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.length());
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException例外をcatchしました");
            System.out.println("ーースタックトレース（ここから）ーー");
            e.printStackTrace();
            System.out.println("ーースタックトレース（ここまで）ーー");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            int i = Integer.parseInt("三");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException例外をcatchしました");
        }
    }
}

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("プログラムが起動しました");
        throw new IOException();
    }
}
