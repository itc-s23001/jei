//s23001
//d52Q27の問題を修正した。

enum Signal {
    RED("赤"), YELLOW("黄"), GREEN("緑");

    private final String colorName;

    Signal(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return this.colorName;
    }
}

public class d52Q27kadai {
    public static void main(String[] args) {
        Signal sig = Signal.YELLOW;
        System.out.println(getSignalMessage(sig));
    }

    public static String getSignalMessage(Signal signal) {
        return signal.getColorName();
    }
}

