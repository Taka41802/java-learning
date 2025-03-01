if構文
冗長でスッキリないコード
public class Main {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = new java.util.Random().nextInt(4) + 1;
        if (fortune == 1) {
            System.out.println("大吉");
        } else if (fortune == 2) {
            System.out.println("中吉");
        } else if (fortune == 3) {
            System.out.println("吉");
        } else {
            System.out.println("凶");
        }
    }
}
一部のコードは条件を満たすとswitch文に変更することができる
public class Main {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = 1;
        switch (fortune) {
            case 1:
                System.out.println("大吉");
                break;
                /* ここにbreak;を入れ忘れている */
            case 2:
                System.out.println("中吉");
                break;
            case 3:
                System.out.println("吉");
                break;
            default:
                System.out.println("凶");
        }
    }
}

上記のようにbreak;を毎回入れなくてはいけない
忘れると
あなたの運勢を占います
大吉
中吉
のように表示される

あえてbreak;を書かない分岐を作ることもできる
public class Main {
    public static void main(String[] args) {
        System.out.println("あなたの運勢を占います");
        int fortune = new java.util.Random().nextInt(5) + 1;
        switch (fortune) {
            case 1:
            case 2:
                System.out.println("いいね！");
                break;
            case 3:
                System.out.println("普通です");
                break;
            case 4:
            case 5:
                System.out.println("うーん…");
        }
    }
}
