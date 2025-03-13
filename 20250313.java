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

イテレータを使ったArrayListの繰り返し処理
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("湊");
        names.add("朝香");
        names.add("菅原");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
    }
}

setの基本特性
・それぞれの要素には重複が許されない
・それぞれの要素には、基本的に順序関係がない

Listと注意する点
①重複した値を格納しようとすると無視される
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<String>();
        colors.add("赤");
        colors.add("青");
        colors.add("黄");
        colors.add("赤");
        System.out.println("色は" + colors.size() + "種類");
    }
}
色は3種類

②set()やget()がない

③要素を1つずつ取り出す場合の順序は不明
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> colors = new HashSet<String>();
        colors.add("赤");
        colors.add("青");
        colors.add("黄");
        for (String s : colors) {
            System.out.print(s + "→");
        }
    }
}
青→赤→黄→

TreeSetから文字列を取り出す
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>();
        words.add("dog");
        words.add("cat");
        words.add("wolf");
        words.add("panda");
        for (String s : words) {
            System.out.print(s + "→");
        }
    }
}






