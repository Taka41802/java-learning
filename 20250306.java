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