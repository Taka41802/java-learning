剣を装備した勇者を生み出す
// まず、Swordクラスを定義しておく
public class Sword {
    String name;
    int damage;
}

// 次にHeroクラスを定義する
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
}

public class Main {
    public static void main(String[] args) {
        Sword s = new Sword();
        s.name = "炎の剣";
        s.damage = 10;
        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = 100;
        h.sword = s;
        System.out.println("現在の武器は" + h.sword.name);
    }
}

ウィザードクラスを作る
public class Wizard {
    String name;
    int hp;
    public void heal(Hero h) {
        h.hp += 10;
        System.out.println(h.name + "のHPを10回復した！");
    }
}

魔法使いと勇者を生み出す
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        h1.name = "ミナト";
        h1.hp = 100;
        Hero h2 = new Hero();
        h2.name = "アサカ";
        h2.hp = 100;
        Wizard w = new Wizard();
        w.name = "スガワラ";
        w.hp = 50;
        w.heal(h1);    // ミナトを回復させる（HP: 100 -> 110）
        w.heal(h2);    // アサカを回復させる（HP: 100 -> 110）
        w.heal(h2);    // アサカを回復させる（HP: 110 -> 120）
    }
}

newを使って文字列のインスタンスを生成（非推奨）
public class Main {
    public static void main(String[] args) {
        String s = new String("こんにちは");
        System.out.println(s);
    }
}

生まれた直後の動作を定義したHeroクラス
これによりnewされた直後に自動的に実行される処理を組むことができる（コンストラクタ）
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
    public Hero() {
        this.hp = 100;    // hpフィールドを100で初期化
    }
}

コンストラクタが定義されたHeroを生み出す
public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();

        System.out.println(h.hp);
    }
}

コンストラクタと見なされる条件
①メソッド名がクラスメイト完全に等しい
②メソッド宣言に戻り値が記述されていない（voidもだめ）

コンストラクタで引数を追加情報として受け取る
このままだと引数エラー
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
    public Hero(String name) {
        this.hp = 100;
        this.name = name;    // 引数の値でnameフィールドを初期化
    }
}

newの際に引数を渡すことで表示されるようになる
public class Main {
    public static void main(String[] args) {
        Hero h = new Hero("ミナト");

        System.out.println(h.hp);
        System.out.println(h.name);
    }
}

コンストラクタのオーバーロード
これにより引数なしでインスタンスを作れる
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
    public Hero(String name) {
        this.hp = 100;
        this.name = name;    // 引数の値でnameフィールドを初期化
    }
    public Hero() {
        this.hp = 100;
        this.name = "ダミー";
    }
}

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("ミナト");
        System.out.println(h1.name);
        Hero h2 = new Hero();
        System.out.println(h2.name);
    }
}

コンストラクタの特例
クラスに1つもコンストラクタが定義されていない場合に限って、「引数なし、処理内容なし」の
コンストラクタ（デフォルトコンストラクタ）がコンパイル時に自動的に追加される

以下のように記述することで別のコンストラクタを呼び出すことができる
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
    public Hero(String name) {    // コンストラクタ①
        this.hp = 100;
        this.name = name;
    }
    public Hero() {    // コンストラクタ②
        this("ダミー");
    }
}






