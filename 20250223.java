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
