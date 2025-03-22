練習問題
public class Sample{
    public void method(int num){
        if (num < 0 ) return;
        System.out.println("A");
        return;
        System.out.println("B");
    }
}

複製した勇者の剣の名前を変更してみる
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("ミナト");
        Sword s = new Sword("はがねの剣");

        h1.setSword(s);
        System.out.println("装備：" + h1.getSword().getName());
        System.out.println("clone()で複製します");
        Hero h2 = h1.clone();

        System.out.println("コピー元の勇者の剣の名前を変えます");
        h1.getSword().setName("ひのきの棒");
        System.out.println("コピー元とコピー先の勇者の装備を表示します");
        System.out.println("コピー元：" + h1.getSword().getName() + "／コピー先：" + h2.getSword().getName());
    }
}


深いコピーに対応したソード/ヒーロークラス
public class Hero implements Cloneable {
    String name;    // 名前
    int hp;         // HP
    Sword sword;    // 装備している武器

    public Hero clone() {
        Hero result = new Hero();
        result.name = this.name;
        result.hp = this.hp;
        result.sword = this.sword.clone();
        return result;
    }

    public Hero() {
        this.name = "";
    }
    public Hero(String name) {
        this.name = name;
    }
    public Sword getSword() {
        return this.sword;
    }
    public void setSword(Sword sword) {
        this.sword = sword;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Sword implements Cloneable {
    private String name;

    public Sword clone() {
        Sword result = new Sword();
        result.name = this.name;
        return result;
    }

    public Sword() {
        this.name = "";
    }
    public Sword(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("ミナト");
        Sword s = new Sword("はがねの剣");

        h1.setSword(s);
        System.out.println("装備：" + h1.getSword().getName());
        System.out.println("clone()で複製します");
        Hero h2 = h1.clone();

        System.out.println("コピー元の勇者の剣の名前を変えます");
        h1.getSword().setName("ひのきの棒");
        System.out.println("コピー元とコピー先の勇者の装備を表示します");
        System.out.println("コピー元：" + h1.getSword().getName() + "／コピー先：" + h2.getSword().getName());
    }
}


ログイン情報を表すクラス
public class LoginHistory {
    private String user;
    private int retry;
    private boolean result;

    public LoginHistory(String user, int retry, boolean result) {
        this.user = user;
        this.retry= retry;
        this.result= result;
    }

    // 3フィールドのgetter宣言（省略）
    // toString()をオーバーライド（省略）
    // equals()をオーバーライド（省略）
    // hashCode()をオーバーライド（省略）
}

java１６以降レコードという特別な種類のクラスを使えるようになった
public record LoginHistory(String user, int retry, boolean result) {
}

LoginHistory Recordの利用
public class Main{
    public static void main(String[] args) {
        LoginHistory h = new LoginHistory("USER1", 0, true);
        System.out.println("ログインを試みたユーザー名は" + h.user());
    }
}

追加のコンストラクタ宣言
public record LoginHistory(String user, int retry, boolean result) {
    public LoginHistory() {
        this("unknown", 0, false);
    }
}

public class Main{
    public static void main(String[] args) {
        LoginHistory h = new LoginHistory();
        System.out.println("ログインを試みたユーザー名は" + h.user());
    }
}

コンパクト・コンストラクタ
public record LoginHistory(String user, int retry, boolean result) {
    public LoginHistory {
        if (retry < 0) throw new IllegalArgumentException();
    }
}
