キャラクターであるため攻撃はできるが、ファイアボールを打てる職業かわからないためエラーが起こる
多態性ではざっくりと捉えるため、中にどのキャラクターが入っているかわからなくなってしまう

        メソッドが呼びだせた場合にどんな処理が起こるのか
public abstract class Monster {
    public void run(){
        System.out.println("モンスターは逃げ出した。");
    }
}

public class Slime extends Monster {
    public void run() {
        System.out.println("スライムはサササっと逃げ出した。");
    }
}

public class Main {
    public static void main(String[] args) {
        Slime s = new Slime(); Monster m = new Slime();
        s.run(); m.run();
    }
}

スライムはサササっと逃げ出した。
スライムはサササっと逃げ出した。

このようにインスタンスの中身によって動くメソッドが決まります
どのような型に入っているかは関係ありません

同一視して配列を利用する
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        Hero h2 = new Hero();
        Thief t1 = new Thief();
        Wizard w1 = new Wizard();
        Wizard w2 = new Wizard();
        // 冒険開始！
        // まず宿屋に泊まる
        h1.hp += 50;
        h2.hp += 50;
        t1.hp += 50;
        w1.hp += 50;
        w2.hp += 50;
    }
}

多態性と配列を組み合わせて宿屋に泊まる
public class Main {
    public static void main(String[] args) {
        Character[] c = new Character[5];
        c[0] = new Hero();
        c[1] = new Hero();
        c[2] = new Thief();
        c[3] = new Wizard();
        c[4] = new Wizard();
        // 宿屋に泊まる
        for (Character ch : c) {
            ch.hp += 50;
        }
    }
}

これにより今までは攻撃をする相手ごとに攻撃メソッドを作成していた
public class Hero extends Character {
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        System.out.println("敵に10ポイントのダメージをあたえた！");
        m.hp -= 10;
    }
    public void attack(Goblin g) {
        System.out.println(this.name + "の攻撃！");
        System.out.println("敵に10ポイントのダメージをあたえた！");
        g.hp -= 10;
    }
    // 以下スライム用など続く
}

モンスターならなんでも攻撃できる攻撃メソッドが出来上がる
public class Hero extends Character {
    public void attack(Monster m) {
        System.out.println(this.name + "の攻撃！");
        System.out.println("敵に10ポイントのダメージをあたえた！");
        m.hp -= 10;
    }
}


多態性を利用することで同じ指示で異なる動作をさせることができる
public class Main {
    public static void main(String[] args) {
        Monster[] monsters = new Monster[3];
        monsters[0] = new Slime();
        monsters[1] = new Goblin();
        monsters[2] = new DeathBat();
        for (Monster m : monsters) {
            m.run();
        }
    }
}
スライムは、体をうねらせて逃げ出した。
ゴブリンは、腕をふって逃げ出した。
地獄コウモリは、羽ばたいて逃げ出した。

カプセル化
アクセス制御されていないヒーロークラス
public class Hero {
    int hp;
    String name;
    Sword sword;

    public void bye() {
        System.out.println("勇者は別れを告げた");
    }
    public void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    public void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0 ) {
            this.die();
        }
    }
    /* … */
}
この状態で不具合が起きる
以下のようなコードになっていた
public class Inn {
    public void checkIn(Hero h) {
        h.hp = -100;
    }
}

public class King {
    public void talk(Hero h) {
        System.out.println("王様：ようこそ我が国へ、勇者" + h.name + "よ。");
        System.out.println("王様：長旅疲れたであろう。");
        System.out.println("王様：まずは城下町を見てくるとよい。ではまた会おう。");
        h.die();
        /* … */
    }
}
など
これらはヒーロークラス以外からは勇者のhpフィールドに値を設定できないや
dieメソッドを呼べるのはヒーロークラスだけである
上記のようなアクセス制御が盛り込まれていたらばくは事前に見つかったはずである

privateによるアクセス制御
public class Hero {
    private int hp;
    String name;
    Sword sword;

    public void bye() {
        System.out.println("勇者は別れを告げた");
    }
    public void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    public void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0 ) {
            this.die();
        }
    }
    /* … */
}
注意点　privateであっても自分のクラスからthisを使って読み書きは可能

dieメソッドもprivateに変更
public class Hero {
    private int hp;
    String name;
    Sword sword;

    public void bye() {
        System.out.println("勇者は別れを告げた");
    }
    private void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    public void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0 ) {
            this.die();
        }
    }
    /* … */
}

攻撃メソッドはさまざまなところで使用されるためpublicをつける
public class Hero {
    private int hp;
    String name;
    Sword sword;

    public void bye() {
        System.out.println("勇者は別れを告げた");
    }
    private void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0 ) {
            this.die();
        }
    }
    /* … */
}

メンバに関するアクセス修飾の定石
・フィールドは全てprivate
・メソッドは全てpublic
そのほかは微調整していけば良い（クラスは特に理由がなければpublicにする）

王様クラスで利用される名前フィールド
public class King {
    public void talk(Hero h) {
        System.out.println("王様：ようこそ我が国へ、勇者" + h.name + "よ。");
        System.out.println("王様：長旅疲れたであろう。");
        System.out.println("王様：まずは城下町を見てくるとよい。ではまた会おう。");
        h.bye();
        /* … */
    }
}

ヒーロークラスにgetNameメソッドを追加
public class Hero {
    private int hp;
    private String name;
    private Sword sword;

    public String getName(){
        return this.name;
    }
    public void bye() {
        System.out.println("勇者は別れを告げた");
    }
    private void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0 ) {
            this.die();
        }
    }
    /* … */
}

このメソッドを使うことにより
勇者の名前を表示することができる（ゲッターメソッド）
public class King {
    public void talk(Hero h) {
        System.out.println("王様：ようこそ我が国へ、勇者" + h.getName() + "よ。");
        System.out.println("王様：長旅疲れたであろう。");
        System.out.println("王様：まずは城下町を見てくるとよい。ではまた会おう。");
        h.bye();
        /* … */
    }
}

ヒーロークラスにsetterメソッドを追加
public class Hero {
    private int hp;
    private String name;
    private Sword sword;

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void bye() {
        System.out.println("勇者は別れを告げた");
    }
    private void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0 ) {
            this.die();
        }
    }
    /* … */
}

カプセル化を行う前
public class Hero {
    String name;
    /* … */
}

カプセル化を行った後
public class Hero {
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /* … */
}

メリット１
Read Only,Write Onlyのフィールドを実現できる

メリット２
フィールドの名前など、クラスの内部設計を自由に変更できる

メリット３
フィールドへのアクセスを検査できる
public class Hero {
    private int hp;
    private String name;
    private Sword sword;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("名前がnullである。処理を中断。");
        }
        if (name.length() <= 1) {
            throw new IllegalArgumentException("名前が短すぎる。処理を中断。");
        }
        if (name.length() >= 8) {
            throw new IllegalArgumentException("名前が長すぎる。処理を中断。");
        }
        this.name = name;
    }
    void bye() {
        System.out.println("勇者は別れを告げた");
    }
    private void die() {
        System.out.println(this.name + "は死んでしまった！");
        System.out.println("GAME OVERです。");
    }
    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は、眠って回復した！");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        /* … */
        System.out.println("お化けキノコ" + m.suffix + "から2ポイントの反撃を受けた");
        this.hp -= 2;
        if (this.hp <= 0) {
            this.die();
        }
    }
    /* … */
}
上記の場合だと
public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.setName("");
    }
}
このような状態になったときに
Exception in thread "main" java.lang.IllegalArgumentException: 名前が短すぎる。処理を中断。
at Hero.setName(Hero.java:14)
at Main.main(Main.java:4)
きちんと処理が中断されるようになる










