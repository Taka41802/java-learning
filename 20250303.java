public class Main {
    public static void main(String[] args) {
        int a = 3;
        int b = a += 5;
        System.out.println(10 * -num);
    }
}
順番に処理されるため
a = a + 5; (a = 3+ 5)と同じ
b = a;
16が表示される

インクリメントとデクリメント
int a = 10;
a++; は a = 10 + 1; と同じ
++a; は a = 11 + 1; と同じ
前置インクリメントは答えが11だが、後置インクリメントは答えが12になることに注意が必要

オーバーライド
・親クラスから継承した子クラスを上書きすること
オーバーロード
・同じ名前でメソッドを定義すること（仮引数の型が違うことや個数が違う場合のみ）
シグネチャ
・オーバーロードした際のメソッド名、引数の個数や型などをまとめた情報のこと

equalsメソッドはオーバライドすることを前提としている
その際に複数の条件がある、1つだけ挙げるとすれば
null以外の参照値xについて、x.equals(null)はfalseを返すこと

public class Main {
    public static void main(String[] args) {
        int[] scores = new int[5];
        System.out.println(scores[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] scores = {20, 30, 40, 50, 80};
        int sum = scores[1] + scores[2] + scores[3] + scores[4] + scores[5];
        int avg = sum / scores.length;
        System.out.println("合計点:" + sum);
        System.out.println("平均点:" + avg);
    }
}
上記はエラーが出る、このようなエラーを例外と呼ぶ（今回は配列の５指定しているためのエラー）
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
at Main.main(Main.java:4)
特にArrayIndexOutOfBoundsExceptionが出た場合は
エラーの原因が存在しない要素を使おうとしたからである

配列は添字に変数を用いることで真価を発揮する
実際の開発では固定の値よりも変数の方が多い
public class Main {
    public static void main(String[] args) {
        int[] scores = {20, 30, 40, 50, 80};
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }
}

ループによる修正したコード
public class Main {
    public static void main(String[] args) {
        int[] scores = {20, 30, 40, 50, 80};
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        int avg = sum / scores.length;
        System.out.println("合計点:" + sum);
        System.out.println("平均点:" + avg);
    }
}
合計点:220
平均点:44

50点以上の科目を調べる
public class Main {
    public static void main(String[] args) {
        int[] scores = {20, 30, 40, 50, 80};
        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 50) {
                count++;
            }
        }
        System.out.println("50点以上の科目の数は:" + count);
    }
}
50点以上の科目の数は:2

ランダム延期配列表示（通常の方法）
public class Main {
    public static void main(String[] args) {
        int[] seq = new int[10];

        // 塩基配列をランダムに生成
        for (int i = 0; i < seq.length; i++) {
            seq[i] = new java.util.Random().nextInt(4);
        }

        // 生成した塩基配列の記号を表示
        for (int i = 0; i < seq.length; i++) {
            switch (seq[i]) {
                case 0:
                    System.out.print("A ");
                    break;
                case 1:
                    System.out.print("T ");
                    break;
                case 2:
                    System.out.print("G ");
                    break;
                case 3:
                    System.out.print("C ");
                    break;
            }
        }
    }
}
