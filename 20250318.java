オーバーライド
public class Hero {
    private String name;
    private int hp, mp;

    public String toString() {
        return "勇者(名前=" + this.name + "/HP=" + this.hp + "/MP=" + this.mp + ")";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setMp(int mp) {
        this.mp = mp;
    }
}

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        h1.setName("ミナト");
        h1.setHp(100);
        h1.setMp(50);

        System.out.println(h1.toString());
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("RPG: スッキリ魔王征伐");
        System.out.println("Ver.0.1 by 湊");
        System.out.println("＜ただいま鋭意学習・制作中＞");
        System.out.println("プログラムを終了します");
    }
}
