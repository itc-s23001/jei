//s23001
//列挙型の課題

enum Condition {
    ROAD, MUD, SNOW
}

class d50Q26kadai {
    public static void main(String[] args) {
        Condition[] conditions = Condition.values();
        for (Condition condition : conditions) {
            System.out.println(condition);
        }
    }
}

