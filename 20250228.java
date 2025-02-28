命令文の実行
System.out.println()
    画面に文字を表示する命令
System.out.print()
    上記と違い表示するが、改行されない
例　public class Main {
    public static void main(String[] args) {
        String name = "すがわら";
        System.out.print("私の名前は");
        System.out.print(name);
        System.out.print("です");
    }
}
結果　私の名前はすがわらです

int m = Math.max(1,2)
        引数として値が大きい方が代入される
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int m = Math.max(a, b);
        System.out.println("比較実験：" + a + "と" + b + "とで大きいほうは…" + m);
    }
}
結果　比較実験：5と3とで大きいほうは…5

int n = Integer.parseInt(1);
　　　　　文字列を数値に変換させる
public class Main {
    public static void main(String[] args) {
        String age = "31";
        int n = Integer.parseInt(age);
        System.out.println("あなたは来年、" + (n + 1) + "歳になりますね。");
    }
}
結果　あなたは来年、32歳になりますね。
