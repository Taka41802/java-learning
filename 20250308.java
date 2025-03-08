抽象度の高いクラス
public abstract class Creature {
    public abstract void run();
}

インターフェースとして宣言したクラス
public interface Creature {
    public abstract void run();
}

一般的な書き方をしたインターフェース
public interface Creature {
    void run();
}
上記のようにインターフェースを宣言したクラスの中では自動的にpublicかつabstractになるため書かなくて良い

なぜインターフェースと呼ばれるのか
public interface CleaningService {
    Shirt washShirt(Shirt s);
    Towl washTowl(Towl t);
    Coat washCoat(Coat c);
}
