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

なぜインターフェースと呼ばれるのか（インターフェースは日本語で接点）
public interface CleaningService {
    Shirt washShirt(Shirt s);
    Towl washTowl(Towl t);
    Coat washCoat(Coat c);
}

インターフェースは店頭メニューとして考えると理解しやすい
public class KyotoCleaningShop implements CleaningService {
    String ownerName;    // 店主の名前
    String address;      // 住所
    String phone;        // 電話番号
    /* シャツを洗う */
    public Shirt washShirt(Shirt s) {
        // 大型洗濯機15分
        return s;
    }
    /* タオルを洗う */
    public Towl washTowl(Towl t) {
        // 大型洗濯機10分
        return t;
    }
    /* コートを洗う */
    public Coat washCoat(Coat c) {
        // ドライ20分
        return c;
    }
}

インターフェースを継承する場合はextendsではなく、implementsを使用する
インターフェースも抽象クラスのためオーバーライドをして実装する必要があります。