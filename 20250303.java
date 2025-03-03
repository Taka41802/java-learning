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