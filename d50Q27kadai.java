// s23001 d50Q27kadai
// Q27のプログラムをアレンジした

class d50Q27kadai {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("エラー: 入力が必要です。");
            return;
        }

        int ans;
        try {
            ans = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("エラー: 数字を入力してください。");
            return;
        }

        String mode;

        switch (ans) {
            case 1:
                mode = "Warm";
                break;
            case 2:
                mode = "Cool";
                break;
            default:
                mode = "Wind";
                break;
        }

        System.out.println("モード: " + mode);
    }
}

