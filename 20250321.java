toString()の責務
インスタンスの中身の情報が知りたいならば、とにかくtoString()を呼び出せばいいと考えることができる
toString()のオーバーライド
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

銀行口座クラスのequals()をオーバーライド
public class Account {
    String accountNo;  // 口座番号（先頭に空白が入ることもある）

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if(!(o instanceof Account)) return false;
        Account r = (Account)o;
        if (!this.accountNo.trim().equals(r.accountNo.trim())) {
            return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.accountNo = "001";

        // (1)自分自身が引数として渡された場合、無条件でtrueを返す。
        System.out.println(a1.equals(a1));
        // (2)nullが引数として渡された場合、無条件でfalseを返す。
        System.out.println(a1.equals(null));
        // (3)型が異なるならば、falseを返す。
        String s1 = "";
        System.out.println(a1.equals(s1));
        // (4)型が同じなら、2つのインスタンスが持つフィールド同士を比較して等価か判定する
        Account a2 = new Account();
        a2.accountNo = "002";
        System.out.println(a1.equals(a2));
        a2.accountNo = "  001";
        System.out.println(a1.equals(a2));
    }
}
不具合につながる例
public class Hero {
    public String name;
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Hero> list = new ArrayList<>();
        Hero h1 = new Hero();
        h1.name = "ミナト";
        list.add(h1);
        System.out.println("要素数=" + list.size());
        h1 = new Hero();
        h1.name = "ミナト";
        list.remove(h1);
        System.out.println("要素数=" + list.size());
    }
}

要素数=1
要素数=1

remove()は引数として渡されたインスタンスについて、これと同じものを削除してとお願いするため
同じものの定義が正しく行われないと削除されなくなる

そのため、クラスを作ったら必ずequals()メソッドをオーバーライドする

配列をequals()で比較する
    import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 4, 5};
        System.out.println("誤った判定：" + a.equals(b));
        System.out.println("正しい判定：" + Arrays.equals(a, b));
    }
}

HashSetの利用でremove()できない例
class Hero {
    public String name;
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Hero)) return false;
        Hero h = (Hero) o;
        if (!this.name.trim().equals(h.name.trim())) {
            return false;
        }
        return true;
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Hero> list = new HashSet<>();
        Hero h1 = new Hero();
        h1.name = "ミナト";
        list.add(h1);
        System.out.println("要素数=" + list.size());
        h1 = new Hero();
        h1.name = "ミナト";
        list.remove(h1);
        System.out.println("要素数=" + list.size());
    }
}

HeroクラスでhashCodeをオーバーライド
import java.util.Objects;

public class Hero {
    String name;
    int hp;

    public int hashCode() {
        return Objects.hash(this.name, this.hp);
    }
}

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero();
        h1.name = "ミナト";
        h1.hp = 100;

        System.out.println(h1.hashCode());
    }
}

エラーが起きていたのは、hashCodeをオーバーライドしていなかったため

インスタンスの並び替え（エラー）
一つだけ制約があるため、それを意識せずに書くとエラーになる
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();
        /* : */
        Collections.sort(list);
    }
}

public class Account {
    String accountNo;  // 口座番号（先頭に空白が入ることもある）

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if(!(o instanceof Account)) return false;
        Account r = (Account) o;
        if (!this.accountNo.trim().equals(r.accountNo.trim())) {
            return false;
        }
        return true;
    }
}

アカウントクラスの自然順序付を定義
public class Account implements Comparable<Account> {
    int number;    // 口座番号
    int zandaka;   // 残高
    public int compareTo(Account obj) {
        if (this.number < obj.number) {
            return -1;
        }
        if (this.number > obj.number) {
            return 1;
        }
        return 0;
    }
}

残高順を実装したコンパレータ
public class Account implements Comparable<Account> {
    int number;    // 口座番号
    int zandaka;   // 残高
    public int compareTo(Account obj) {
        if(this.number < obj.number) {
            return -1;
        }
        if(this.number > obj.number) {
            return 1;
        }
        return 0;
    }
}

import java.util.Comparator;

public class ZandakaComparator implements Comparator<Account> {
    public int compare(Account x, Account y) {
        return (x.zandaka - y.zandaka);
    }
}


import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        a1.number = 200;
        a2.number = 100;
        a3.number = 300;
        a1.zandaka = 1000000;
        a2.zandaka = 500000;
        a3.zandaka = 100000;
        list.add(a1);
        list.add(a2);
        list.add(a3);

        System.out.println("ソート前：");
        for (Account a :list){
            System.out.println(a.number);
        }

        Collections.sort(list);  // 自然順序で並び替える

        System.out.println("自然順序でのソート後：");
        for (Account a :list){
            System.out.println(a.number);
        }

        Collections.sort(list, new ZandakaComparator());  // 残高順で並び替える

        System.out.println("残高順でのソート後：");
        for (Account a :list){
            System.out.println(a.number);
        }
    }
}


clone()による複製をサポートしたヒーロークラス
    implements Cloneableはマーカーインターフェイスになる
class Hero implements Cloneable {
    String name;    // 名前
    int hp;         // HP
    Sword sword;    // 装備している武器

    public Hero clone() {
        Hero result = new Hero();
        result.name = this.name;
        result.hp = this.hp;
        result.sword = this.sword;
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

public class Sword {
    private String name;

    public Sword() {
        this.name = "";
    }
    public Sword(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
