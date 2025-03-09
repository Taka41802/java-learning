インターフェースの効果
①同じインターフェースをimplementsする複数の子クラスたちに、共通のメソッド群を実装するように強制できる。
②あるクラスがインターフェースを実装していれば、少なくともそのインターフェースが定めたメソッドは持っていることが保証できる。

インターフェースは多重継承をすることができる
これは、クラスにはないインターフェースの特権

インターフェースを継承する
public interface Human extends Creature {
    void talk();
    void watch();
    void hear();
    // さらに、親インタフェースからrun()を継承する
}

上記でextendsを使っているのは、implementsとextendsは使い分けをする必要があるから
以下のように同時に使うこともできる
public class Fool extends Character implements Human {
    // Characterからhpやnameなどのフィールドを継承している
    // Characterから継承した抽象メソッドattack()を実装
    public void attack(Matango m) {
        System.out.println(this.name + "は戦わずに遊んでいる");
    }
    // さらにHumanから継承した4つの抽象メソッドを実装
    public void talk() { /* … */ }
    public void watch() { /* … */ }
    public void hear() { /* … */ }
    public void run() { /* … */ }
}

public abstract class Character {
    String name;
    int hp;
    public abstract void run();
    public abstract void attack(Matango m);
}

public interface Human extends Creature {
    void talk();
    void watch();
    void hear();
    // さらに、親インタフェースからrun()を継承する
}

public interface Creature {
    void run();
}

public class Matango {
    int hp;
    final int LEVEL = 10;
    char suffix;
    public void run() {
        System.out.println("お化けキノコ" + this.suffix + "は逃げ出した！");
    }
}
