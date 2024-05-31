class d48Q6kadai {
    public static void main(String[] args) {
        if(args.length != 4) {
            System.out.println("数値を四つ指定してください");
            return;
        }

        Achievement teamA = new Achievement();
        teamA.set(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Achievement teamB = new Achievement();
        teamB.set(Integer.parseInt(args[2]), Integer.parseInt(args[3])); // 修正: args[3]

        Match match = new Match();
        match.setAchievements(teamA, teamB); // 修正: setAchievementsメソッドを呼び出し
        System.out.println(match.showResult());
        System.out.println(match.determineWinner()); // 勝敗判定結果を表示
    }
}

class Match {
    Achievement teamA;
    Achievement teamB;

    void setAchievements(Achievement a, Achievement b) {
        teamA = a;
        teamB = b;
    }

    String showResult() {
        return
        "Team A: " + winPoint(teamA.point, teamB.point, teamA.tryNumber, teamB.tryNumber) + // 修正: 引数を追加
        ", Team B: " + winPoint(teamB.point, teamA.point, teamB.tryNumber, teamA.tryNumber); // 修正: 引数を追加
    }

    int winPoint(int teamXPoint, int teamYPoint, int teamXTryNumber, int teamYTryNumber) { // 修正: 引数を追加
        return matchPoint(teamXPoint, teamYPoint) + bonusPoint(teamXTryNumber, teamYTryNumber);
    }

    int matchPoint(int teamXPoint, int teamYPoint) {
        if (teamXPoint == teamYPoint) {
            return 2;
        } else if (teamXPoint > teamYPoint) {
            return 4;
        } else if (teamXPoint - teamYPoint >= 7) {
            return 1;
        }
        return 0;
    }

    int bonusPoint(int teamXTryNumber, int teamYTryNumber) { // 修正: 引数を追加
        return (teamXTryNumber >= 4 ? 1 : 0); // 修正: intを返す
    }

    String determineWinner() { // 勝敗を判定する新しいメソッド
        int teamAPoints = winPoint(teamA.point, teamB.point, teamA.tryNumber, teamB.tryNumber);
        int teamBPoints = winPoint(teamB.point, teamA.point, teamB.tryNumber, teamA.tryNumber);

        if (teamAPoints > teamBPoints) {
            return "チームAの勝利！";
        } else if (teamBPoints > teamAPoints) {
            return "チームBの勝利！";
        } else {
            return "引き分け！";
        }
    }
}

class Achievement {
    int point;
    int tryNumber;

    void set(int teamPoint, int teamTryNumber) {
        point = teamPoint;
        tryNumber = teamTryNumber;
    }
}

