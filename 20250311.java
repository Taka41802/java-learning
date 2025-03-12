クラスに対するアクセス制御は2つしかない
・何も書かないことでブライベートにするか
・publicにするか

非publicの特徴として、
①クラス名がソースファイル名と異なっても良い
②1つのソースファイルに複数のクラスを宣言することができる

publicクラスとプライベートクラスを混ぜることも可能

練習問題
public class Wand {
    private String name;     // 杖の名前
    private double power;    // 杖の魔力
}
public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;
    public void heal(Hero h) {
        int basePoint = 10;                                   // 基本回復ポイント
        int recovPoint = (int)(basePoint * this.wand.power);  // 杖による増幅
        h.setHp(h.getHp() + recovPoint);                      // 勇者のHPを回復する
        System.out.println(h.getName() + "のHPを" + recovPoint + "回復した！");
    }
}

public class Wand {
    private String name;     // 杖の名前
    private double power;    // 杖の魔力
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public double getPower() { return this.power; }
    public void setPower(double power) { this.power = power; }
}

public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;
    public void heal(Hero h) {
        int basePoint = 10;                                            // 基本回復ポイント
        int recovPoint = (int)(basePoint * this.getWand().getPower()); // 杖による増幅
        h.setHp(h.getHp() + recovPoint);                               // 勇者のHPを回復する
        System.out.println(h.getName() + "のHPを" + recovPoint + "回復した！");
    }
    public int getHp() { return this.hp; }
    public void setHp(int hp) { this.hp = hp; }
    public int getMp() { return this.mp; }
    public void setMp(int mp) { this.mp = mp; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public Wand getWand() { return this.wand; }
    public void setWand(Wand wand) { this.wand = wand; }
}

public class Wand {
    private String name;     // 杖の名前
    private double power;    // 杖の魔力
    public String getName() { return this.name; }
    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("杖に設定されようとしている名前が異常です");
        }
        this.name = name;
    }
    public double getPower() { return this.power; }
    public void setPower(double power) {
        if (power < 0.5 || power > 100.0) {
            throw new IllegalArgumentException("杖に設定されようとしている魔力が異常です");
        }
        this.power = power;
    }
}

public class Wizard {
    private int hp;       private int mp;
    private String name;  private Wand wand;
    public void heal(Hero h) {
        int basePoint = 10;                                            // 基本回復ポイント
        int recovPoint = (int)(basePoint * this.getWand().getPower()); // 杖による増幅
        h.setHp(h.getHp() + recovPoint);                               // 勇者のHPを回復する
        System.out.println(h.getName() + "のHPを" + recovPoint + "回復した！");
    }
    public int getHp() { return this.hp; }
    public void setHp(int hp) {
        if (hp < 0) { this.hp = 0; } else { this.hp = hp; }
    }
    public int getMp() { return this.mp; }
    public void setMp(int mp) {
        if (mp < 0) {
            throw new IllegalArgumentException("設定されようとしているMPが異常です");
        }
        this.mp = mp;
    }
    public String getName() { return this.name; }
    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("魔法使いに設定されようとしている名前が異常です");
        }
        this.name = name;
    }
    public Wand getWand() { return this.wand; }
    public void setWand(Wand wand) {
        if (wand == null) {
            throw new IllegalArgumentException("設定されようとしている杖がnullです");
        }
        this.wand = wand;
    }
}

何も定義していないクラスでtoString()を呼ぶ
public class Empty {}

public class Main {
    public static void main(String[] args) {
        Empty e = new Empty();
        String s = e.toString();
        System.out.println(s);
    }
}

全てのインスタンスはオブジェクトの型を持つようになる