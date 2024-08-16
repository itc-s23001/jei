public class d52Q6kadai {
    public static void main(String[] args) {
        Drink[] drinks = {
            new Drink("Gomacola", 150),
            new Drink("MrPepper", 130),
            new Drink("SaltWater", 320)
        };

        VendingMachine vm = new VendingMachine(drinks);
        vm.display();
        vm.insertMoney(500);
        vm.purchaseDrink(0); // Gomacolaを購入
        vm.returnChange();    // お釣り 350円を返却
    }
}

class Drink {
    private String name;
    private int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "[" + name + "] " + price + "円";
    }
}

class VendingMachine {
    private Drink[] drinks;
    private int cash = 0;

    VendingMachine(Drink[] drinks) {
        this.drinks = drinks;
    }

    // 商品を表示する
    public void display() {
        for (int i = 0; i < drinks.length; i++) {
            System.out.println(" [" + (i + 1) + "] " + drinks[i]);
        }
    }

    // お金を投入する
    public void insertMoney(int amount) {
        cash += amount;
        System.out.println(amount + "円を投入しました");
    }

    // ドリンクを購入する
    public void purchaseDrink(int index) {
        if (index < 0 || index >= drinks.length) {
            System.out.println("無効な選択です");
            return;
        }

        Drink selectedDrink = drinks[index];
        if (cash >= selectedDrink.getPrice()) {
            System.out.println(selectedDrink.getName() + " が排出されました");
            cash -= selectedDrink.getPrice();
        } else {
            System.out.println("お金が足りません");
        }
    }

    // お釣りを返却する
    public void returnChange() {
        if (cash == 0) {
            System.out.println("お釣り なし");
        } else {
            System.out.println("お釣り " + cash + "円");
            cash = 0;
        }
    }
}

