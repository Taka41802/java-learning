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












