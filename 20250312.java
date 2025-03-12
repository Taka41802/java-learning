全てのクラスはオブジェクト型を持つことで多態性を利用できる
public class Main {
    public static void main(String[] args) {
        Object o1 = new Empty();
        Object o2 = new Hero();
        Object o3 = "こんにちは";
    }
}

どんなインスタンスでも受け取れるメソッドを作ることもできる
public class Printer {
    public void printAnything(Object o) {
        // 何型でもいいから、引数を1つ受け取り画面に表示
        System.out.println(o.toString());
    }
}

ヒーロークラスの文字情報を表示する
public class Hero {
    String name;
    int hp;
    /* … */
}
public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = 100;
        System.out.println(h.toString());
    }
}
Hero@75b84c92

toStringをオーバーライドする
public class Hero {
    String name;
    int hp;
    /* … */
    public String toString() {
        return "名前：" + this.name + "／HP：" + this.hp;
    }
}

２人の勇者を比較する
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        h1.name = "ミナト";
        h1.hp = 100;
        Hero h2 = new Hero();
        h2.name = "ミナト";
        h2.hp = 100;
        if (h1.equals(h2) == true) {
            System.out.println("同じ内容です");
        } else {
            System.out.println("違う内容です");
        }
    }
}

名前が同じならば同じ勇者とする
public class Hero {
    String name;
    int hp;
    /* … */
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o instanceof Hero) {
            Hero h = (Hero)o;
            if (this.name.equals(h.name)) {
                return true;
            }
        }
        return false;
    }
}

各インスタンスのフィールドは独立している
public class Hero {
    String name;
    int hp;
    int money;
    /* … */
}

勇者で共通のお金を持つ場合
public class Hero {
    String name;
    int hp;
    static int money;
    /* … */
}

上記のようにstaticをつけたフィールドは静的フィールドと呼ばれます
①フィールド変数の実体がクラスに準備される
静的フィールドへのアクセス方法
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        Hero h2 = new Hero();
        System.out.println(h1.hp);
        System.out.println(Hero.money);
        /* … */
    }
}

②全インスタンスに、箱の分身が準備される
各インスタンスから静的フィールドを利用可能
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        Hero h2 = new Hero();
        Hero.money = 100;
        System.out.println(Hero.money);
        System.out.println(h1.money);
        h1.money = 300;
        System.out.println(h2.money);
    }
}

③インスタンスを1つも生み出さなくても共通の箱が利用できる
newをしなくても静的フィールドは利用可能
public class Main {
    public static void main(String[] args) {
        // 1人も勇者を生み出していない状況で…
        Hero.money = 100;
        System.out.println(Hero.money);
    }
}

staticはメソッドにもつけられる
所持金をランダムに設定する
public class Hero {
    String name;
    int hp;
    static int money;
    /* … */
    static void setRandomMoney() {
        Hero.money = (int)(Math.random() * 1000);
    }
}

newをせずとも静的メソッドは呼び出し可能
public class Main {
    public static void main(String[] args) {
        Hero.setRandomMoney();
        System.out.println(Hero.money);
        Hero h1 = new Hero();
        System.out.println(h1.money);
    }
}

静的メソッドから非静的メンバを利用する（エラー）
public class Hero {
    String name;
    int hp;
    static int money;
    /* … */
    static void setRandomMoney() {
        Hero.money = (int)(Math.random() * 1000);
        System.out.println(this.name + "たちの所持金を初期化しました");
    }
}

練習問題
public class Account{
    String accountNumber;
    int balance;

    public String toString(){
        return "¥¥" + this.balance +
                "(口座番号：" + this.accountNumber + ")";
    }
    public boolean equals(object o){
        if (this == o){
            retern ture;
        }
        if (o instanceof Account){
            Account a = (Account) o;
            String an1 = this.accountNumber.trim();
            String an2 = a.accountNumber.trim();
            if (an1.equals(an2)){
                return true;
            }
        }
        return false;
    }
}

文字列調査メソッドを利用した例
public class Main {
    public static void main(String[] args) {
        String s1 = "スッキリJava";
        String s2 = "Java";
        String s3 = "java";
        if (s2.equals(s3)) {
            System.out.println("s2とs3は等しい");
        }
        if (s2.equalsIgnoreCase(s3)) {
            System.out.println("s2とs3はケースを区別しなければ等しい");
        }
        System.out.println("s1の長さは" + s1.length() + "です");
        if (s1.isEmpty()) {
            System.out.println("s1は空文字です");
        }
    }
}

文字列検索メソッドを利用した例
public class Main {
    public static void main(String[] args) {
        String s1 = "Java and JavaScript";
        if (s1.contains("Java")) {
            System.out.println("文字列s1は、Javaを含んでいます");
        }
        if (s1.endsWith("Java")) {
            System.out.println("文字列s1は、Javaが末尾にあります");
        }
        System.out.println("文字列s1で最初にJavaが登場する位置は" + s1.indexOf("Java"));
        System.out.println("文字列s1で最後にJavaが登場する位置は" + s1.lastIndexOf("Java"));
    }
}

文字列切り出しメソッドを利用した例
public class Main {
    public static void main(String[] args) {
        String s1 = "Java programing";
        System.out.println("文字列s1の4文字目以降は" + s1.substring(3));        // ⇒ a programing
        System.out.println("文字列s1の4～8文字目以降は" + s1.substring(3, 8));  // ⇒ a pro
    }
}

StringBuilderを利用して文字列を1万回連結する
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("Java");
        }
        String s = sb.toString();
    }
}

Stringインスタンスはインスタンス時に初期化され以降二度と変化することはない
Stringインスタンスに代入しているように見えているのは新しくnewで連結後の情報を持つインスタンスを作っていルカらになる

プレイヤー名判定メソッド
public class Main {
    public static void main(String[] args) {
    }

    public boolean isValidPlayerName(String name) {
        if (name.length() != 8) {
            return false;
        }
        char first = name.charAt(0);
        if (!(first >= 'A' && first <= 'Z')) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            char c = name.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= '0' && first <= '9'))) {
                return false;
            }
        }
        return true;
    }
}

matchesメソッドを使った場合
public class Main {
    public static void main(String[] args) {
    }

    public boolean isValidPlayerName(String name) {
        return name.matches("[A-Z][A-Z0-9]{7}");
    }
}

splitメソッドを使った文字列の分割
public class Main {
    public static void main(String[] args) {
        String s = "abc,def:ghi";
        String[] words = s.split("[,:]");
        for (String w : words) {
            System.out.print(w + "->");
        }
    }
}

replaceAllメソッドを使った文字列の置換
public class Main {
    public static void main(String[] args) {
        String s = "abc,def:ghi";
        String w = s.replaceAll("[beh]", "X");
        System.out.println(w);  // aXc,dXf:gXi
    }
}

桁を揃えてキャラクターを表示する
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.name = "minato";
        hero.job = "hero";
        hero.gold = 280;

        final String FORMAT = "%-9s %-13s 所持金%,6d";
        String s = String.format(FORMAT, hero.getName(), hero.getJob(), hero.getGold());
        System.out.println(s);
    }
}
minato    hero          所持金   280

処理時間を計測する
public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // ここでなんらかの時間がかかる処理
        long end = System.currentTimeMillis();
        System.out.println("処理にかかった時間は..." + (end-start) + "ミリ秒でした");
    }
}

現在の日時を表示する
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        Date past = new Date(1600705425827L);
        System.out.println(past);
    }
}
Wed Mar 12 13:31:57 JST 2025
        1741753917471
Tue Sep 22 01:23:45 JST 2020

6つのint値とDate型の相互変換
import java.util.Calendar;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        // 6つのint値からDateインスタンスを生成
        c.set(2019,8,22,1,23,45);
        c.set(Calendar.MONTH, 9);     /* 月を9（10月）に変更 */
        Date d = c.getTime();
        System.out.println(d);
        // Dateインスタンスからint値を生成
        Date now = new Date();
        c.setTime(now);
        int y = c.get(Calendar.YEAR);  /* 年を取り出す */
        System.out.println("今年は" + y + "年です");
    }
}

String型とDate型の相互変換
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // 文字列からDateインスタンスを生成
        Date d = f.parse("2020/09/22 01:23:45");
        System.out.println(d);
        // Dateインスタンスから文字列を生成
        Date now = new Date();
        String s = f.format(now);
        System.out.println("現在は" + s + "です");
    }
}

InstantおよびZonedDateTimeの利用例
import java.time.*;

public class Main {
    public static void main(String[] args) {
        // Instantの生成
        Instant i1 = Instant.now();

        // Instantとlong値との相互変換
        Instant i2 = Instant.ofEpochMilli(1600705425827L);
        long l = i2.toEpochMilli();

        // ZonedDateTimeの生成方法
        ZonedDateTime z1 = ZonedDateTime.now();
        ZonedDateTime z2 = ZonedDateTime.of(2020, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));

        // InstantとZoneDateTimeの相互変換
        Instant i3 = z2.toInstant();
        ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

        // ZonedDateTimeの利用方法
        System.out.println("東京:" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
        System.out.println("ロンドン:" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
        if(z2.isEqual(z3)) {
            System.out.println("これらは同じ瞬間を指しています");
        }
    }
}

LocalDateTimeの利用例
import java.time.*;

public class Main {
    public static void main(String[] args) {
        // LocalDateTimeの生成方法
        LocalDateTime l1 = LocalDateTime.now();
        LocalDateTime l2 = LocalDateTime.of(2020, 1, 1, 9, 5, 0, 0);

        // LocalDateTimeとZoneDateTimeの相互変換
        ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
        LocalDateTime l3 = z1.toLocalDateTime();
    }
}

各種日時クラスのメソッド利用例
import java.time.*;
        import java.time.format.*;

public class Main {
    public static void main(String[] args) {
        // 文字列からLocalDateを生成
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate ldate = LocalDate.parse("2020/09/22", fmt);

        // 1000日後を計算する
        LocalDate ldatep = ldate.plusDays(1000);
        String str = ldatep.format(fmt);
        System.out.println("1000日後は" + str);

        // 現在日付との比較
        LocalDate now = LocalDate.now();
        if(now.isAfter(ldatep)){
            System.out.println("1000日後は過去日付です");
        }
    }
}

Periodクラスの利用例
import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2020,1,1);
        LocalDate d2 = LocalDate.of(2020,1,4);

        // 3日間を表すPeriodを2通りの方法で生成
        Period p1 = Period.ofDays(3);
        Period p2 = Period.between(d1, d2);

        // d2のさらに3日後を計算する
        LocalDate d3 = d2.plus(p2);
    }
}

練習問題
public class Main{
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++){
            sb.append(i+1).append(",");
        }
        String s = sb.toString();
        String[] a = s.split(",");
    }
}

public class Main {
    public static void main(String[] args) {
    }

    public String concatPath(String folder, String file) {
        if (!folder.endsWith("¥¥")) {
            folder += "¥¥";
        }
        return folder + file;
    }
}

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 1. 現在の日時をDate型で取得
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        // 2.取得した日時情報をCalendarにセット
        c.setTime(now);
        // 3.Calendarから「日」の情報を取得
        int day = c.get(Calendar.DAY_OF_MONTH);
        // 4.取得した値に100を足してCalendarの「日」にセット
        day += 100;
        c.set(Calendar.DAY_OF_MONTH, day);
        // 5.Calendarの日付情報をDate型に変換
        Date future = c.getTime();
        // 6.指定された形式で表示
        SimpleDateFormat f = new SimpleDateFormat("西暦yyyy年MM月dd日");
        System.out.println(f.format(future));
    }
}

import java.time.*;
        import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate future = now.plusDays(100);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("西暦yyyy年MM月dd日");
        System.out.println(future.format(fmt));
    }
}















