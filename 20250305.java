ソースファイルを　javacコマンドでコンパイルする
そうなると一つのクラスから.javaと.classのファイルができる
javaではこれが完成品となる

クラスをパッケージに分ける
package calcapp.main;

public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = CalcLogic.tasu(a, b);
        int delta = CalcLogic.hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}

package calcapp.logics;

public class CalcLogic {
    public static int tasu(int a, int b) {
        return (a + b);
    }
    public static int hiku(int a, int b) {
        return (a - b);
    }
}

package文はソースコードの先頭に書く
勘違いしがちだが、パッケージに親子関係や階層関係はない
それぞれが独立している

どのパッケージのどのクラスかを明示する必要がある
パッケージ名.クラス名.メソッド名

int total = CalcLogic.tasu(a, b);
int delta = CalcLogic.hiku(a, b);

package calcapp.main;

public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = calcapp.logics.CalcLogic.tasu(a, b);
        int delta = calcapp.logics.CalcLogic.hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}


























