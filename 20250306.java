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















