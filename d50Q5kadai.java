//s23001
//forを使ってソート途中の配列を出力するようにした

class d50Q5kadai {
    public static void main(String[] args) {
        // コマンドライン引数がない場合のエラーチェック
        if (args.length == 0) {
            System.out.println("エラー: 少なくとも1つの整数を入力してください。");
            return;
        }

        // 整数配列の初期化
        int[] num = new int[args.length];

        // 引数を整数に変換して配列に格納
        try {
            for (int i = 0; i < args.length; i++) {
                num[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("エラー: 引数は全て整数でなければなりません。");
            return;
        }

        // 挿入ソートアルゴリズムによる配列のソート
        insertionSort(num);

        // ソートされた配列を表示
        for (int val : num) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // 挿入ソートアルゴリズムの実装
    private static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            // 現在の要素を適切な位置に挿入する
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}

