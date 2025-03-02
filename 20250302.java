配列について
・配列に含まれる各要素の型は揃える必要がある
　そのため、同一種類のデータしか格納できない

配列変数の宣言　
int [] scores;
上記のint[]型はint型とは別物になるので注意が必要！

要素の作成と代入
scores = new int [5];

public class Main {
    public static void main(String[] args) {
        int[] scores;
        scores = new int[5];
    }
}

宣言と作成、代入を一気にすることもできる
public class Main {
    public static void main(String[] args) {
        int[] scores = new int[5];
    }
}

幾つの要素を作ったのか、自分で覚えなくても確認できる
public class Main {
    public static void main(String[] args) {
        int[] scores = new int[5];
        int num = scores.length;
        System.out.println("要素の数: " + num);
    }
}
