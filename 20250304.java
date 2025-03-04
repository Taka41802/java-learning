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

