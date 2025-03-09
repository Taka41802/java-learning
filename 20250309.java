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

練習問題
自分の回答
public interface TangibleAsset {
    String name;
    int price;
    String color;
    String isbn;
}

public class Book implements TangibleAsset{ // コンストラクタ
    public Book(String name, int price, String color, String isbn) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.isbn = isbn;
    }
    // メソッド
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public String getColor() { return this.color; }
    public String getIsbn() { return this.isbn; }
}

public class Computer implements TangibleAsset{
    public Computer(String name, int price, String color, String makerName) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.makerName = makerName;
    }
    // メソッド
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public String getColor() { return this.color; }
    public String getMakerName() { return this.makerName; }
}

模範回答
public abstract class TangibleAsset {
    String name;
    int price;
    String color;
    public TangibleAsset(String name, int price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public String getColor() { return this.color; }
}

public class Book extends TangibleAsset {
    String isbn;
    public Book(String name, int price, String color, String isbn) {
        super(name, price, color);
        this.isbn = isbn;
    }
    public String getIsbn() { return this.isbn; }
}

public class Computer extends TangibleAsset {
    String makerName;
    public Computer(String name, int price, String color, String makerName) {
        super(name, price, color);
        this.makerName = makerName;
    }
    public String getMakerName() { return this.makerName; }
}
