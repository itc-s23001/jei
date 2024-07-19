//s23001
//範囲内の素数の数を出力するように改造

public class d50Q6kadai {
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]); // コマンドライン引数の最初の値を整数としてminに代入
        int max = Integer.parseInt(args[1]); // コマンドライン引数の二番目の値を整数としてmaxに代入
        if (max < min) { // maxがminより小さい場合、値を入れ替える
            int tmp = max;
            max = min;
            min = tmp;
        }

        PrimeNumbers primeNumbers = new PrimeNumbers(); // PrimeNumbersクラスのインスタンスを作成
        primeNumbers.initializePrimeNumbers(max); // maxまでの素数を初期化
        int[] part = primeNumbers.getParts(min, max); // minからmaxまでの素数を取得

        for (int prime : part) { // 素数を一つずつ出力
            System.out.printf("%d,", prime);
        }
        System.out.println("\n" + min + "から" + max + "までの素数は" + part.length + "個です");
    }
}


class PrimeNumbers {
    boolean[] isPrimeNumbers; // 素数判定用のブール配列

    void initializePrimeNumbers(int max) {
        isPrimeNumbers = new boolean[max + 1]; // max+1のサイズのブール配列を作成
        for (int i = 2; i <= max; i++) {
            isPrimeNumbers[i] = true; // 2からmaxまでを素数と仮定
        }

        for (int p = 2; p <= Math.sqrt(max); p++) { // maxの平方根までループ
            if (isPrimeNumbers[p]) { // pが素数の場合
                for (int m = p * 2; m <= max; m += p) { // pの倍数を全て素数ではないとする
                    isPrimeNumbers[m] = false;
                }
            }
        }
    }

    int[] getParts(int min, int max) {
        int count = 0;
        for (int n = min; n <= max; n++) { // minからmaxまでをチェック
            if(isPrimeNumbers[n]) { // 素数の場合
                count++; // 素数のカウントを増やす
            }
        }
        int[] part = new int[count]; // 素数の数だけのサイズの配列を作成
        int index = 0;
        for (int n = min; n <= max; n++) { // 再度minからmaxまでをチェック
            if (isPrimeNumbers[n]) { // 素数の場合
                part[index++] = n; // 配列に素数を追加
            }
        }
        return part; // 素数の配列を返す
    }
}

