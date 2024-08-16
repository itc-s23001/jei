public class d52Q5 {
    public static void main(String[] args) {
        // コマンドライン引数がない場合の処理
        if (args.length == 0) {
            System.out.println("エラー: 引数が必要です。");
            return;
        }

        int[] values = new int[args.length];

        // コマンドライン引数を整数に変換
        try {
            for (int i = 0; i < args.length; i++) {
                values[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("エラー: 数字以外の引数が含まれています。");
            return;
        }

        // 上部スケール表示
        System.out.println("        +----+----+----+----");

        // 棒グラフ表示
        for (int value : values) {
            // スケールを10単位で計算
            int scaledValue = value / 10;

            // 数値と対応する*を出力
            System.out.printf("%5d : ", value);

            // スケールに応じて*を出力
            for (int j = 0; j < scaledValue; j++) {
                System.out.print("*");
            }

            System.out.println(); // 改行
        }

        // 下部スケール表示
        System.out.println("~            ");
    }
}

