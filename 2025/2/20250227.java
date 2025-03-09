varを使った型推論には変数の初期化を行う必要がある
フィールド宣言にも使うことはできず、ローカル変数にしか使えない。

Stringオブジェクト
Stringオブジェクトは普遍なオブジェクトなためデータを変更できない
生成する方法　2つ
・newを使ってインスタンス化する
・""で括った文字列リテラルを記述する

concatメソッド
インスタンスが保持する文字列を、引数として渡された文字列と連結して新しい文字列を返すメソッド
"Hello," .concat("Java!")

cherAtメソッド
インスタンスが保持している文字列から、引数で指定された位置にある1文字だけを抜き出して戻す
String str = "abcde";
System.out.println(str.cherAt(4))
e が表示される

indexOfメソッド
引数で指定された文字が文字列のどの位置に存在するかを調べることができる
String str = "abcde";
System.out.println(str.indexOf("c"));
2が表示される
もし、文字列がない場合-1が表示される
上記の場合
System.out.println(str.indexOf("f"));などの場合