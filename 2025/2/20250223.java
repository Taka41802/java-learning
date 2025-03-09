パッケージの目的
・名前空間を提供して、名前の衝突を避ける
・アクセス装飾子と組み合わせてアクセス制御機能を提供する
・クラスの分類を可能にする

パッケージ宣言をする際はソースコードの先頭に記述する
package sample;
public class Test{
    // any code
}

ダメな例
import aaa.*;
package sample;
public class Test{
    // any code
}

パッケージ宣言より前に記述できるのはコメントのみ

最初の２行と最後の２行はお決まりのパターンがある
public class Main {
    public static void main(String [] args){

    }
}
javaではソースファイルの名前とクラス名は同じにする必要がある

データの型を宣言してから変数名をつける
        型にはメモリの量が違うが、最近のコンピューターは多くのメモリを搭載しているため基本的にはintを使えばおk
float,doubleは真に厳密な計算ができないため、金額の計算に使用してはいけない

変数の初期化とは変数宣言と代入を１行で行うこと
finalをつけて宣言することで変数を定数にすることができる

練習問題
public class Main {
    public static void main(String [] args){
        int a = 3;
        int b = 5;
        int c = a*b;
        System.out.println("縦幅3 横幅5 の長方形の面積は、"+c );
    }
}