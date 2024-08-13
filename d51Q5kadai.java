//s23001
//d51Q5のコードをアレンジして基本使用料金をプラス100円、従量料金単価をプラス各1円上げた。

public class d51Q5kadai {
    public static void main(String[] args) {
        // 各区分の上限値
        double[] level = {0.0, 24.0, 57.0, Double.MAX_VALUE};
        // 単位の範囲
        double[] unit = {0.0, 2.0, 3.0, 5.0};
        // 従量料金単価を1円プラスしている
        int[] rate = {0, 21, 19, 16}; // 基本料金 + 1円

        if (args.length != 1) {
            System.out.println("引数の個数が不正");
            return;
        }

        double amount = Double.parseDouble(args[0]);
        if (amount < 0.0) {
            System.out.println("0.0以上の使用量を入力");
            return;
        }

        int i, price = 1400; // 基本使用料金に100円追加
        for (i = 1; amount >= level[i]; i++) {
            price += (int)((level[i] - level[i - 1]) / unit[i]) * rate[i];
        }
        price += (int)Math.ceil((amount - level[i - 1]) / unit[i]) * rate[i];
        System.out.println("今月のガス料金 " + price + "円");
    }
}

