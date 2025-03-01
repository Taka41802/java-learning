if構文
冗長でスッキリないコード
public class Main {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = new java.util.Random().nextInt(4) + 1;
        if (fortune == 1) {
            System.out.println("大吉");
        } else if (fortune == 2) {
            System.out.println("中吉");
        } else if (fortune == 3) {
            System.out.println("吉");
        } else {
            System.out.println("凶");
        }
    }
}
一部のコードは条件を満たすとswitch文に変更することができる
public class Main {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = 1;
        switch (fortune) {
            case 1:
                System.out.println("大吉");
                break;
                /* ここにbreak;を入れ忘れている */
            case 2:
                System.out.println("中吉");
                break;
            case 3:
                System.out.println("吉");
                break;
            default:
                System.out.println("凶");
        }
    }
}

上記のようにbreak;を毎回入れなくてはいけない
忘れると
あなたの運勢を占います
大吉
中吉
のように表示される

あえてbreak;を書かない分岐を作ることもできる
public class Main {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = new java.util.Random().nextInt(5) + 1;
        switch (fortune) {
            case 1:
            case 2:
                System.out.println("いいね！");
                break;
            case 3:
                System.out.println("普通です");
                break;
            case 4:
            case 5:
                System.out.println("うーん…");
        }
    }
}

回数指定の繰り返し処理はfor文を使うと便利
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("こんにちは");
        }
    }
}

for (int i = 0; i < 10; i++) {
    上記の構文の変数iなどは必ず3つ同じものを使うことがルール

①初期化処理
　最初に一度だけ行われる処理＝ループ変数
②繰り返し条件
　ブロックの内容を実行する前にこのループを継続するか判定する条件式
　基本的にこの部分の数字を変更するだけで、さまざまな場面に対応できる。
③繰り返し時処理
　}まで到達した直後に自動的に実行される処理

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("現在" + (i + 1) + "周目→");
        }
    }
}

制御構造のネスト
for文のループを2重にして九九の表を出力する
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1;j < 10;j++) {
                System.out.print(i * j);  // 掛け算の結果を出力
                System.out.print(" ");    // 空白を出力
            }
            System.out.println("");     // 改行を出力
        }
    }
}

繰り返しの中断
javaでは2つ中断方法がある
・break文
　繰り返し処理自体を中断できる
・continue文
　今回の周だけを中断して次の周にいける

練習問題
weight == 60 ;           ◯
(age1 + age2) * 2 > 60;  ◯
age % 2 == 1;            ◯
name == "湊";            ✖︎ name.equals("湊");


自分の答え
public class Main{
    public static void main(String [] args){
    int isHungry = 1;
    String food = "ハンバーガー";
    System.out.println("こんにちは");
      if (isHungry == 0){
          System.out.println("お腹がいっぱいです");
      }else {
　　　　　　System.out.println("はらぺこです");
　　　　　　System.out.println(food + "をいただきます");
      }
    }
　　　　　　System.out.println("ごちそうさまでした");
}

模範回答
public class Main {
    public static void main(String[] args) {
        int isHungry = 1;
        String food = "おにぎり";
        System.out.println("こんにちは");
        if (isHungry== 0) {
            System.out.println("お腹がいっぱいです");
        } else {
            System.out.println("はらぺこです");
        }
        if (isHungry == 1) {
            System.out.println(food + "をいただきます");
        }
        System.out.println("ごちそうさまでした");
    }
}

public class Main {
    public static void main(String[] args) {
        boolean tenki = true;
        if (tenki == true) {
            System.out.println("洗濯をします");
            System.out.println("散歩にいきます");
        } else
            System.out.println("DVDを見ます");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.print("［メニュー］1：検索 2：登録 3：削除 4：変更>");
        int selected = new java.util.Scanner(System.in).nextInt();
        switch (selected) {
            case 1:
                System.out.println("検索します");
                break;
            case 2:
                System.out.println("登録します");
                break;
            case 3:
                System.out.println("削除します");
                break;
            case 4:
                System.out.println("変更します");
                break;
        }
    }
}
