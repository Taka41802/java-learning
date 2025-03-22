練習問題
public class Sample{
    public void method(int num){
        if (num < 0 ) return;
        System.out.println("A");
        return;
        System.out.println("B");
    }
}

複製した勇者の剣の名前を変更してみる
public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("ミナト");
        Sword s = new Sword("はがねの剣");

        h1.setSword(s);
        System.out.println("装備：" + h1.getSword().getName());
        System.out.println("clone()で複製します");
        Hero h2 = h1.clone();

        System.out.println("コピー元の勇者の剣の名前を変えます");
        h1.getSword().setName("ひのきの棒");
        System.out.println("コピー元とコピー先の勇者の装備を表示します");
        System.out.println("コピー元：" + h1.getSword().getName() + "／コピー先：" + h2.getSword().getName());
    }
}


深いコピーに対応したソード/ヒーロークラス
public class Hero implements Cloneable {
    String name;    // 名前
    int hp;         // HP
    Sword sword;    // 装備している武器

    public Hero clone() {
        Hero result = new Hero();
        result.name = this.name;
        result.hp = this.hp;
        result.sword = this.sword.clone();
        return result;
    }

    public Hero() {
        this.name = "";
    }
    public Hero(String name) {
        this.name = name;
    }
    public Sword getSword() {
        return this.sword;
    }
    public void setSword(Sword sword) {
        this.sword = sword;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}