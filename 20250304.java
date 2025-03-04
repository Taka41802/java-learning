従来のfor文
public class Main {
    public static void main(String[] args) {
        int[] scores = {20, 30, 40, 50, 80};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }
}

拡張for文
public class Main {
    public static void main(String[] args) {
        int[] scores = {20, 30, 40, 50, 80};
        for (int value : scores) {
            System.out.println(value);
        }
    }
}

配列をより深く理解する
public class Main {
    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3};
        int[] arrayB;
        arrayB = arrayA;
        arrayB[0] = 100;
        System.out.println(arrayA[0]);
    }
}
答えは100が表示される

ガベージコレクション
・以下のようなif文内でしか使えない配列がメモリに残ってしまうことがあります。
　このような状態になるとjavaのどのようなプログラムからも読み書きができない状態となってしまいます。
　そのためメモリ上のゴミとなって残り続けてしまいます。
　しかし、javaにはガベージコレクションという機能があり、自動的にメモリのゴミを排除する機能があります。
public class Main {
    public static void main(String[] args) {
        boolean judge = true;
        if (judge == true) {
            int[] array = {1, 2, 3};
        }
    }
}

nullを利用することで配列の参照を切り、ガベージコレクションの対象とすることができる
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        array = null;
        array[0] = 10;
    }
}

二次元配列の利用
public class Main {
    public static void main(String[] args) {
        int[][] scores = new int[2][3];
        scores[0][0] = 40;
        scores[0][1] = 50;
        scores[0][2] = 60;
        scores[1][0] = 80;
        scores[1][1] = 60;
        scores[1][2] = 70;
        System.out.println(scores[1][1]);
    }
}

親配列と子配列の要素数の表示
以下のような初期化をすることができる！
public class Main {
    public static void main(String[] args) {
        int[][] scores = {{40, 50, 60}, {80, 60, 70}};
        System.out.println(scores.length);
        System.out.println(scores[0].length);
    }
}


練習問題
int [] points = new int[4];
double [] weights = new double[5];
boolean [] answers = new boolean[3];
String [] nemes = new String[3];

public class Main{
    public static void main(String[] args){
        int [] moneyList = new int[121902,8302,55100];
        for(int i = 0; i = moneyList.length; i++) {
            System.out.println(moneyList[i]);
        }
        for(int value : moneyList ){
            System.out.println(value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] counts = null;
        float[] heights = {171.3F, 175.0F};
        System.out.println(counts[1]);
        System.out.println(heights[2]);
    }
}
Exception in thread "main" java.lang.NullPointerException: Cannot load from int array because "<local1>" is null
at Main.main(Main.java:5)
6　ArrayIndexOutOfBoundsException

自分の回答
public class Main{
    public static void main(String[] args){
        int [] numbers = new int{3,4,9};
        System.out.println("1桁の数字を入力してください");
        int input = new java.util.Scanner(System.in).nextInt();
        for (int t : numbers){
            if (t == 9){
                System.out.println("当たり！");
            }
        }
    }
}

模範回答
public class Main {
    public static void main(String[] args) {
        // (1)配列の準備
        int[] numbers = {3, 4, 9};

        // (2)メッセージの表示
        System.out.println("1桁の数字を入力してください");

        // (3)キーボードからの数字入力
        int input = new java.util.Scanner(System.in).nextInt();

        // (4)配列を回しながら判定
        for (int n : numbers) {
            if (n == input) {
                System.out.println("アタリ！");
            }
        }
    }
}

シンプルなメソッドの定義
public class Main {
    public static void hello() {
        System.out.println("湊さん、こんにちは");
    }
}

メソッドの呼び出し
・メソッドは必ず呼び出す必要がある
public class Main {
    public static void main(String[] args) {
        System.out.println("メソッドを呼び出します");
        hello();
        System.out.println("メソッドの呼び出しが終わりました");
    }
    public static void hello() {
        System.out.println("湊さん、こんにちは");
    }
}

Mainメソッド以外からメソッドを呼び出す
public class Main {
    public static void methodA() {
        System.out.println("methodA");
        methodB();
    }
    public static void methodB() {
        System.out.println("methodB");
    }
    public static void main(String[] args) {
        methodA();
    }
}

引数の例
public class Main {
    public static void main(String[] args) {
        System.out.println("メソッドを呼び出します");
        hello("湊");
        hello("朝香");
        hello("菅原");
        System.out.println("メソッドの呼び出しが終わりました");
    }
    public static void hello(String name) {
        System.out.println(name + "さん、こんにちは");
    }
}
引数を渡さない場合でもhello()のように必ず()をつける
        ()には何も渡さないという意味も含まれている

引数が複数ある場合
public class Main {
    public static void main(String[] args) {
        add(100, 20);
        add(200, 50);
    }
    // 複数の値を受け取るaddメソッド
    public static void add(int x, int y) {
        int ans = x + y;
        System.out.println(x + "+" + y + "=" + ans);
    }
}

引数使わずに値を渡せるのか？（コンパイルエラー）
public class Main {
    public static void main(String[] args) {
        int x = 100;
        int y = 10;
        add();
    }
    public static void add() {
        int ans = x + y;
        System.out.println(x + "+" + y + "=" + ans);
    }
}
スコープ外から呼び出そうとしたためエラーが起こる

戻り値の例
public class Main {
    public static int add(int x, int y) {
        int ans = x + y;
        return ans;
    }
    public static void main(String[] args) {
        int ans = add(100, 10);
        System.out.println("100 + 10 = " + ans);
    }
}

戻り値をそのまま使う
public class Main {
    public static int add(int x, int y) {
        int ans = x + y;
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(add(add(10, 20), add(30, 40)));
    }
}

return文の後に処理を書くとコンパイルエラーになる
public class Main {
    public static int sample() {
        // :
        return 1;
        int x = 10;
    }
}

オーバーロードの利用
・メソッド名に同じ名前をつけることはできない
例外的に処理が似ているものを同じ名前のメソッドにすることができる
public class Main {
    // 1つ目のaddメソッド
    public static int add(int x, int y) {
        return x + y;
    }
    // 2つ目のaddメソッド
    public static double add(double x, double y) {
        return x + y;
    }
    // 3つ目のaddメソッド
    public static String add(String x, String y) {
        return x + y;
    }
    public static void main(String[] args) {
        System.out.println(add(10, 20));
        /* 1つ目のaddメソッドが呼び出される */
        System.out.println(add(3.5, 2.7));
        /* 2つ目のaddメソッドが呼び出される */
        System.out.println(add("Hello", "World"));
    }                    /* 3つ目のaddメソッドが呼び出される */

}

以下のように引数が違う場合も使用できる
public class Main {
    public static int add(int x, int y) {
        return x + y;
    }
    public static int add(int x, int y, int z) {
        return x + y + z;
    }
    public static void main(String[] args){
        System.out.println("10+20=" + add(10, 20));
        System.out.println("10+20+30=" + add(10, 20, 30));
    }
}

引数に配列を用いる方法
public class Main {
    // int型配列を受け取り、すべての要素を表示するメソッド
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        printArray(array);    // 配列を渡す
    }
}

メソッドで配列を呼び出した場合、値渡しではなく参照渡しになるため呼び出し先で加えた変更が呼び出し元にも影響することになる
同じ配列を参照していることを確認する
public class Main {
    // int型配列を受け取り、
    // 配列内の要素すべてに1を加えるメソッド
    public static void incArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]++;
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        incArray(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}


戻り値に配列を用いる
public class Main {
    public static int[] makeArray(int size) {
        int[] newArray = new int[size];
        for (int i = 0; i < newArray.length; i++ ) {
            newArray[i] = i;
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] array = makeArray(3);
        for (int i : array) {
            System.out.println(i);
        }
    }
}


練習問題
自分の回答
public class Main{
    public static void introduceOneself(String[] args){
        String name = "鈴木太郎";
        int age = 27;
        double height = "170.5";
        cher zodiac = "牛";
        System.out.println("私は" + name + age + "です。");
        System.out.println("身長" + height "で、干支は" + zodiac "になります");
    }
    public static void main(String[] args){
        introduceOneself();
    }
}

模範回答
public class Main {
    public static void main(String[] args) {
        introduceOneself();
    }

    public static void introduceOneself() {
        String name = "Minato";
        int age = 22;
        double height = 169.9;
        char zodiac = '辰';
        System.out.println("私の名前は" + name + "です");
        System.out.println("歳は" + age + "です");
        System.out.println("身長は" + height + "cmです");
        System.out.println("十二支は" + zodiac + "です");
    }
}

回答修正
public class Main{
    public static void introduceOneself(){
        String name = "鈴木太郎";
        int age = 27;
        double height = 170.5;
        char zodiac = '牛';
        System.out.println("私は" + name + "、年齢は" + age + "です。");
        System.out.println("身長" + height + "で、干支は" + zodiac + "になります");
    }
    public static void main(String[] args){
        introduceOneself();
    }
}

以下回答
public class Main {
    public static void main(String[] args) {
        String title = "お誘い";
        String address = "uso800@xxxx.com";
        String text = "今度、飲みにいきませんか";
        email(title, address, text);
    }
    public static void email(String title, String address, String text) {
        System.out.println(address + "に、以下のメールを送信しました");
        System.out.println("件名：" + title);
        System.out.println("本文：" + text);
    }
}


public class Main {
    public static void main(String[] args) {
        String address = "uso800@xxxx.com";
        String text = "今度、飲みにいきませんか";
        email(address, text);
    }
    public static void email(String address, String text) {
        System.out.println(address + "に、以下のメールを送信しました");
        System.out.println("件名：無題");
        System.out.println("本文：" + text);
    }
    public static void email(String title, String address, String text) {
        System.out.println(address + "に、以下のメールを送信しました");
        System.out.println("件名：" + title);
        System.out.println("本文：" + text);
    }
}

public class Main {
    public static void main(String[] args) {
        double triangleArea = calcTriangleArea(10.0, 5.0);
        System.out.println("三角形の面積：" + triangleArea + "平方cm");
        double circleArea = calcCircleArea(5.0);
        System.out.println("円の面積：" + circleArea + "平方cm");
    }
    public static double calcTriangleArea(double bottom, double height) {
        double area = (bottom * height) / 2;
        return area;
    }
    public static double calcCircleArea(double radius) {
        double area = radius * radius * 3.14;
        return area;
    }
}

ソースファイルを分ける
計算機プログラム
public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = tasu(a, b);
        int delta = hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
    public static int tasu(int a, int b) {
        return (a + b);
    }
    public static int hiku(int a, int b) {
        return (a - b);
    }
}

新しくクラスを作る
public class CalcLogic {
    public static int tasu(int a, int b) {
        return (a + b);
    }
    public static int hiku(int a, int b) {
        return (a - b);
    }
}

以下残されたmainメソッド
public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = tasu(a, b);
        int delta = hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}

このままだとコンパイルエラーになるため書き換える
public class Calc {
    public static void main(String[] args) {
        int a = 10; int b = 2;
        int total = CalcLogic.tasu(a, b);
        int delta = CalcLogic.hiku(a, b);
        System.out.println("足すと" + total + "、引くと" + delta);
    }
}













