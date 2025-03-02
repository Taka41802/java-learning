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

５行目でscoresの2つ目の要素に30を代入している
public class Main {
    public static void main(String[] args) {
        int[] scores;
        scores = new int[5];
        scores[1] = 30;
        System.out.println(scores[1]);
    }
}

配列の初期化
変数の値を出す前には必ず値を代入して初期化する必要がある
初期化していない変数を使おうとするとコンパイルエラーが起こる
以下のコードはコンパイルエラーになる
public class Main {
    public static void main(String[] args) {
        int x;
        System.out.println(x);
    }
}

しかし、配列の要素は自動的に初期化されるのでコンパイルエラーにはならない
public class Main {
    public static void main(String[] args) {
        int[] scores = new int[5];
        System.out.println(scores[0]);
    }
}
上記のような場合、型によって返される値が決まっている
今回は０が返される