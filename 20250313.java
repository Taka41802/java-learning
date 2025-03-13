コレクション
ArrayListについて
①import文を記述する
②<>記号を使って、格納するインスタンスの型を指定する
③宣言時のサイズ指定は不要、要素はいつでも追加できる

配列との違い
メモリ効率や性能は配列の方が良い
でも、自動的にサイズを増やすことができるため、実際の現場ではArrayListが多く使われる
ArrayListはインスタンス以外は格納できない

ラッパークラスをArrayListに格納する
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> points = new ArrayList<Integer>();
        points.add(10);
        points.add(80);
        points.add(75);
        for (int i : points) {
            System.out.println(i);
        }
    }
}

