完全限定クラス名（FQCN）
パッケージ名.クラス名

完全限定クラス名を省略する
import パッケージ名.クラス名;(ソースコードより上に、ただしpackage文より後に記述する)

package calcapp.main;
import calcapp.logics.CalcLogic;

public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = CalcLogic.tasu(a, b);　　　　　　　　　　　　//FQCNでなくてもエラーにならない
        int delta = calcapp.logics.CalcLogic.hiku(a, b);　　　//FQCNを指定しても良い
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}

calcapp.logicsの全クラスのインポート
package calcapp.main;
import calcapp.logics.*;

public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = CalcLogic.tasu(a, b);
        int delta = calcapp.logics.CalcLogic.hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}

javaには名前空間の概念がある
パッケージが違えば同じクラス名を使用することができる
他の会社などとパッケージ名が被ってしまう可能性があるため、会社のドメイン名を前後逆にして使用することが多い

APIを利用する
public class Main {
    public static void main(String[] args) {
        int[] heights = {172, 149, 152, 191, 155};
        java.util.Arrays.sort(heights);
        for (int h : heights) {
            System.out.println(h);
        }
    }
}

練習問題
自分の回答
import comment.Zenhan;

public class Main {
    public static void main(String[] args) throws Exception {
        doWarusa();
        doTogame();
        comment.Kouhan.callDeae();
        comment.Kouhan.showMondokoro();
    }
}

package comment.Zenhan;
public static void doWarusa() {
    System.out.println("きなこでござる。食えませんがの。");
}
public static void doTogame() {
    System.out.println("この老いぼれの目はごまかせませんぞ。");
}

package comment.Kouhan;
public static void callDeae() {
    System.out.println("えぇい、こしゃくな。くせ者だ！であえい！");
}
public static void showMondokoro() throws Exception {
    System.out.println("飛車さん、角さん。もういいでしょう。");
    System.out.println("この紋所が目にはいらぬか！");
    doTogame();    // もう一度、とがめる
}

模範回答
import comment.Zenhan;

public class Main {
    public static void main(String[] args) throws Exception {
        Zenhan.doWarusa();
        Zenhan.doTogame();
        comment.Kouhan.callDeae();
        comment.Kouhan.showMondokoro();
    }
}

package comment;

public class Zenhan {
    public static void doWarusa() {
        System.out.println("きなこでござる。食えませんがの。");
    }

    public static void doTogame() {
        System.out.println("この老いぼれの目はごまかせませんぞ。");
    }
}

package comment;

public class Kouhan {
    public static void callDeae() {
        System.out.println("えぇい、こしゃくな。くせ者だ！であえい！");
    }

    public static void showMondokoro() throws Exception {
        System.out.println("飛車さん、角さん。もういいでしょう。");
        System.out.println("この紋所が目にはいらぬか！");
        doTogame();    // もう一度、とがめる
    }
}

コンパイルする
javac Main.java Zenhan.java Kouhan.java

待ち時間を入れる
public class Kouhan {
    public static void callDeae() {
        System.out.println("えぇい、こしゃくな。くせ者だ！であえい！");
    }

    public static void showMondokoro() throws Exception {
        System.out.println("飛車さん、角さん。もういいでしょう。");
        System.out.println("この紋所が目にはいらぬか！");
        PrimeRun p = new PrimeRun(143);
        new Thread(p).start();
        doTogame();    // もう一度、とがめる
    }
}

模範回答
public class Kouhan {
    public static void callDeae() {
        System.out.println("えぇい、こしゃくな。くせ者だ！であえい！");
    }

    public static void showMondokoro() throws Exception {
        System.out.println("飛車さん、角さん。もういいでしょう。");
        System.out.println("この紋所が目にはいらぬか！");
        Thread.sleep(3000);
        doTogame();    // もう一度、とがめる
    }
}

オブジェクト指向の考え方
public class Main {
    public static void main(String[] args) {
        // （以下の内容をJavaで記述していく）
        // 勇者よ、この仮想世界に生まれよ！
        // お化けキノコよ、この仮想世界に生まれよ！
        // 勇者よ、戦え！
        // お化けキノコよ、逃げろ！
    }
}

クラス図の設計図に準じて書いていく
public class Hero {
    String name;
    int hp;
    public void attack() {/* … */}
    public void sleep() {/* … */}
    public void sit(int sec) {/* … */}
    public void slip() {/* … */}
    public void run() {/* … */}
}

クラスの宣言方法（ファイル名を揃えることに注意！）
public class Hero {
}

属性の宣言
クラスブロック内に宣言された変数をフィールドという
public class Hero {
    String name;  // 名前の宣言
    int hp;       // HPの宣言
}

フィールドを宣言すると同時に初期値も設定
public class Matango {
    int hp;
    int level = 10;
}

宣言の先頭にfinalをつけると定数フィールドになる
public class Matango {
    int hp;
    final int LEVEL = 10;
}

操作の宣言方法
thisは自分自身のインスタンスという意味
public class Hero {
    String name;
    int hp;

    void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は、眠って回復した！");
    }
}

メソッドの追加
フィールドを用いるときには明示的にthisをつける！
public class Hero {
    String name;
    int hp;
    public void sleep() {
        this.hp = 100;
        System.out.println(this.name + "は、眠って回復した！");
    }
    public void sit(int sec) {
        this.hp += sec;
        System.out.println(this.name + "は、" + sec + "秒座った！");
        System.out.println("HPが" + sec + "ポイント回復した");
    }
    public void slip() {
        this.hp -= 5;
        System.out.println(this.name + "は、転んだ！");
        System.out.println("5のダメージ！");
    }
    public void run() {
        System.out.println(this.name + "は、逃げ出した！");
        System.out.println("GAMEOVER");
        System.out.println("最終HPは" + this.hp + "でした");
    }
}

hero型の変数を宣言
public class Main {
    public static void main(String[] args) {
        Hero h;
    }
}

勇者インスタンスを生成
public class Main {
    public static void main(String[] args) {
        // 1.勇者を生成
        Hero h = new Hero();
    }
}

勇者インスタンスを生成して初期値を代入
public class Main {
    public static void main(String[] args) {
        // 1.勇者を生成
        Hero h = new Hero();
        // 2.フィールドに初期値をセット
        h.name = "ミナト";
        h.hp = 100;
        System.out.println("勇者" + h.name + "を生み出しました！");
    }
}

仮想世界に勇者を生み出すプログラム
public class Main {
    public static void main(String[] args) {
        // 1.勇者を生成
        Hero h = new Hero();
        // 2.フィールドに初期値をセット
        h.name = "ミナト";
        h.hp = 100;
        System.out.println("勇者" + h.name + "を生み出しました！");
        // 3.勇者のメソッドを呼び出してゆく
        h.sit(5);
        h.slip();
        h.sit(25);
        h.run();
    }
}

オブジェクト指向を使わない方法で作ったプログラム
public class Main {
    public static void main(String[] args) {
        int yusha_hp = 100;
        int matango1_hp = 50;
        int matango2_hp = 48;
        String yusha_name = "ミナト";
        int matango1_level = 10;
        int matango2_level = 10;
        System.out.println(yusha_name + "は5秒座った！");
        yusha_hp += 5;
        System.out.println("HPが5ポイント回復した");
        /* ： */
        /* ： */
    }
}

お化けキノコクラスの定義
public class Matango {
    int hp;
    final int LEVEL = 10;
    char suffix;
    public void run() {
        System.out.println("お化けキノコ" + this.suffix + "は逃げ出した！");
    }
}

仮想世界に勇者とお化けキノコ２匹を生み出す
public class Main {
    public static void main(String[] args) {
        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = 100;

        Matango m1 = new Matango();
        m1.hp = 50;
        m1.suffix = 'A';

        Matango m2 = new Matango();
        m2.hp = 48;
        m2.suffix = 'B';

        // 冒険のはじまり
        h.slip();
        m1.run();
        m2.run();
        h.run();
    }
}

練習問題
public class Cleric{
}

public class Cleric{
    String name;
    int hp = 50;
    final int maxhp = 50;
    int mp = 10;
    final int maxmp = 10;
}

public class Cleric{
    String name;
    int hp = 50;
    final int maxhp = 50;
    int mp = 10;
    final int maxmp = 10;


    自分の回答
    public void selfAid(){
        if (mp > 5){
            hp = 50;
            System.out.println("体力を最大まで回復します");
        }
    }
}
模範回答
public void selfAid() {
    System.out.println(this.name + "はセルフエイドを唱えた！");
    this.hp = this.MAX_HP;
    this.mp -= 5;
    System.out.println("HPが最大まで回復した");
}

自分の回答
public void pray(){
    System.out.println("聖職者は祈った！");

    System.out.println("mpが回復した");
}

模範回答
public int pray(int sec) {
    System.out.println(this.name + "は" + sec + "秒間天に祈った！");

    // 論理上の回復量を乱数を用いて決定する
    int recover = new Random().nextInt(3) + sec;

    // 実際の回復量を計算する
    int recoverActual = Math.min(this.MAX_MP - this.mp, recover);

    this.mp += recoverActual;
    System.out.println("MPが" + recoverActual + "回復した");
    return recoverActual;
}

heroクラスをインスタンス化して利用する
public class Main{
    public static void main(String[] args) {
        Hero h;
        h = new Hero();
        h.hp = 100;
    }
}

2つのHero型変数を利用する
public class Main {
    public static void main(String[] args) {
        Hero h1;
        h1 = new Hero();
        h1.hp = 100;
        Hero h2;
        h2 = h1;
        h2.hp = 200;
        System.out.println(h1.hp);
    }
}


Sword型フィールドを持つHeroクラス
public class Main {
    public static void main(String[] args) {
        Hero h1;
        h1 = new Hero();
        h1.hp = 100;
        Hero h2;
        h2 = h1;
        h2.hp = 200;
        System.out.println(h1.hp);
    }
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
