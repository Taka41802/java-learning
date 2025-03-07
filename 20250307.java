剣を装備した勇者を生み出す
// まず、Swordクラスを定義しておく
public class Sword {
    String name;
    int damage;
}

// 次にHeroクラスを定義する
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
}

public class Main {
    public static void main(String[] args) {
        Sword s = new Sword();
        s.name = "炎の剣";
        s.damage = 10;
        Hero h = new Hero();
        h.name = "ミナト";
        h.hp = 100;
        h.sword = s;
        System.out.println("現在の武器は" + h.sword.name);
    }
}

ウィザードクラスを作る
public class Wizard {
    String name;
    int hp;
    public void heal(Hero h) {
        h.hp += 10;
        System.out.println(h.name + "のHPを10回復した！");
    }
}

魔法使いと勇者を生み出す
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        h1.name = "ミナト";
        h1.hp = 100;
        Hero h2 = new Hero();
        h2.name = "アサカ";
        h2.hp = 100;
        Wizard w = new Wizard();
        w.name = "スガワラ";
        w.hp = 50;
        w.heal(h1);    // ミナトを回復させる（HP: 100 -> 110）
        w.heal(h2);    // アサカを回復させる（HP: 100 -> 110）
        w.heal(h2);    // アサカを回復させる（HP: 110 -> 120）
    }
}

newを使って文字列のインスタンスを生成（非推奨）
public class Main {
    public static void main(String[] args) {
        String s = new String("こんにちは");
        System.out.println(s);
    }
}

生まれた直後の動作を定義したHeroクラス
public class Hero {
    String name;
    int hp;
    Sword sword;
    public void attack() {
        System.out.println(this.name + "は攻撃した！");
        System.out.println("敵に5ポイントのダメージをあたえた！");
    }
    public Hero() {
        this.hp = 100;    // hpフィールドを100で初期化
    }
}















