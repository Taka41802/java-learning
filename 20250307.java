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

練習問題
自分の回答
public class Thief {
    String name;
    int hp;
    int mp;
}
public Thief(String name,int hp,int mp){
    this.name = name;
    this.hp = hp;
    this.mp = mp;
}
public Thief(String name,int hp){
    this("name");
    this(hp);
    this.mp = 5;
}
public Thief(String name){
    this("name");
    this.hp = 40;
    this.mp = 5;
}

模範回答
public class Thief {
    String name;
    int hp;
    int mp;

    public Thief(String name, int hp, int mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }
    public Thief(String name, int hp) {
        this(name, hp, 5);
    }
    public Thief(String name) {
        this(name, 40);
    }
}

継承
似通ったクラスの開発
戦うと逃げるしかできないHeroクラス
public class Hero {
    String name = "ミナト";
    int hp = 100;
    // 戦う
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        m.hp -= 5;
        System.out.println("5ポイントのダメージをあたえた！");
    }
    // 逃げる
    public void run() {
        System.out.println(this.name + "は逃げ出した！");
    }
}

より多くのことができるスーパーヒーロークラス
public class SuperHero {
    String name = "ミナト";
    int hp = 100;
    boolean flying;
    // 戦う
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        m.hp -= 5;
        System.out.println("5ポイントのダメージをあたえた！");
    }
    // 逃げる
    public void run() {
        System.out.println(this.name + "は逃げ出した！");
    }
    // 飛ぶ
    public void fly() {
        this.flying = true;
        System.out.println("飛び上がった！");
    }
    // 着地する
    public void land() {
        this.flying = false;
        System.out.println("着地した！");
    }
}

継承を利用してHeroクラスからSuperHeroクラスを作成する
差分のみを記述すれば良い
public class SuperHero extends Hero {
    boolean flying;
    public void fly() {
        this.flying = true;
        System.out.println("飛び上がった！");
    }
    public void land() {
        this.flying = false;
        System.out.println("着地した！");
    }
}

上記のように継承すれば以下のようなクラスにないメソッドを呼び出せる
public class Main {
    public static void main(String[] args) {
        SuperHero sh = new SuperHero();
        sh.run();
    }
}

便利な継承だが多重継承はjavaでは禁止

メソッドの再定義をすることができる（オーバーライド）
public class SuperHero extends Hero {
    boolean flying;
    public void fly() {
        this.flying = true;
        System.out.println("飛び上がった！");
    }
    public void land(){
        this.flying = false;
        System.out.println("着地した！");
    }
    public void run() {
        System.out.println(this.name + "は撤退した");
    }
}

ためにし呼び出してみると以下のような結果になる
public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.run();
        SuperHero sh = new SuperHero();
        sh.run();
    }
}
ミナトは逃げ出した！
ミナトは撤退した

final宣言されているクラスは継承不可！
メソッドも同じため以下の場合だとslip()は継承できない
public class Hero {
    String name = "ミナト";
    int hp = 100;

    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        m.hp -= 5;
        System.out.println("5ポイントのダメージをあたえた!");
    }
    public final void slip() {
        this.hp -= 5;
        System.out.println(this.name + "は転んだ!");
        System.out.println("5のダメージ");
    }
    public void run() {
        System.out.println(this.name + "は逃げ出した！");
    }
}

インスタンスの多重構造になっているときは外側にある子インスタンスから対応しようとします
そのため親インスタンスに同じメソッドがあっても実行しません

親インスタンスのメソッドが役に立つ事例
スーパーヒーローは空を飛んでいる状態で攻撃すると2回攻撃できる
public class SuperHero extends Hero {
    boolean flying;
    public void fly(){
        this.flying = true;
        System.out.println("飛び上がった！");
    }
    public void land() {
        this.flying = false;
        System.out.println("着地した！");
    }
    public void run() {
        System.out.println("撤退した");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        m.hp -= 5;
        System.out.println("5ポイントのダメージをあたえた!");
        if (this.flying) {
            System.out.println(this.name + "の攻撃！");
            m.hp -= 5;
            System.out.println("5ポイントのダメージをあたえた!");
        }
    }
}
この状態では今後ヒーロークラスで攻撃が１０になったときに５ダメージを2回することになってしまいます（オーバーライドしているため）

そんなときは親インスタンスのメソッドを呼びだして上げると解決できる
public class SuperHero extends Hero {
    boolean flying;
    public void fly() {
        this.flying = true;
        System.out.println("飛び上がった！");
    }
    public void land() {
        this.flying = false;
        System.out.println("着地した！");
    }
    public void run() {
        System.out.println("撤退した");
    }
    public void attack(Matango m) {
        super.attack(m);
        if (this.flying) {
            super.attack(m);
        }
    }
}

superを使っても孫インスタンスが親の親インスタンスにアクセスすることはできない

継承とコンストラクタ
public class Hero {
    String name = "ミナト";
    int hp = 100;

    public Hero() {
        System.out.println("Heroのコンストラクタが動作");
    }
    public void attack(Matango m) {
        System.out.println(this.name + "の攻撃！");
        m.hp -= 5;
        System.out.println("5ポイントのダメージをあたえた!");
    }
    public final void slip() {
        this.hp -= 5;
        System.out.println(this.name + "は転んだ!");
        System.out.println("5のダメージ");
    }
    public void run() {
        System.out.println(this.name + "は逃げ出した！");
    }
}

public class SuperHero extends Hero {
    boolean flying;

    public SuperHero() {
        System.out.println("SuperHeroのコンストラクタが動作");
    }
    public void fly() {
        this.flying = true;
        System.out.println("飛び上がった！");
    }
    public void land() {
        this.flying = false;
        System.out.println("着地した！");
    }
    public void run() {
        System.out.println("撤退した");
    }
    public void attack(Matango m) {
        super.attack(m);
        if (this.flying) {
            super.attack(m);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SuperHero sh = new SuperHero();
    }
}

この部分にsuper();が必要
public SuperHero() {
    super();
    System.out.println("SuperHeroのコンストラクタが動作");
}


コンストラクタを呼び出せない状況
public class Item {
    String name;
    int price;
    public Item(String name) {
        this.name = name;
        this.price = 0;
    }
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class Weapon extends Item { /* … */ }

public class Main {
    public static void main(String[] args) {
        Weapon w = new Weapon();
    }
}


上記のような状態の場合
引数が０のコンストラクタがないため呼び出すことができない
このような場合はsuper()を使って引数を渡すことができる
public class Weapon extends Item {
    public Weapon(){
        super("名無しの剣");
    }
}

継承が正しく行われているか（ルール）
子クラスis-a親クラスのルールがある
間違った継承とは概念としてis-aの関係がないのに、継承を使ってしまうことである

例　アイテムクラスを利用してハウスクラスを作る
　　ハウスはアイテムの一種であるは間違った継承の使い方である

is-aの原則が成立しないならば、たとえ楽ができるとしても継承を使ってはいけない
理由は2つ
・将来、クラスを拡張していった場合に現実世界との矛盾が生じるから
・オブジェクト指向の３大機能の1つ多能性を利用できなくなる

練習問題
public class Matango {
    int hp = 50;
    char suffix;
    public Matango(char suffix) {
        this.suffix = suffix;
    }
    public void attack(Hero h) {
        System.out.println("キノコ" + this.suffix + "の攻撃");
        System.out.println("10のダメージ");
        h.hp -= 10;
    }
}

自分の回答
public class PoisonMatango extends Matango{
    public void attack(Hero h) {
        int poison =5;
       super.attack(Hero h);
       if (poison > 0){
        System.out.println("さらに毒の胞子をばら撒いた！");
           h.hp = hp - hp/5;

       }
    }
}

模範回答
public class PoisonMatango extends Matango {
    int poisonCount = 5;
    public PoisonMatango(char suffix) {
        super(suffix);
    }
    public void attack(Hero h) {
        super.attack(h);
        if (poisonCount > 0) {
            System.out.println("さらに毒の胞子をばらまいた！");
            int dmg = h.hp / 5;
            h.hp -= dmg;
            System.out.println(dmg + "ポイントのダメージ！");
            this.poisonCount--;
        }
    }
}
