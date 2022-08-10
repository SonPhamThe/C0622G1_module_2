package ss8_cleancode_refactoring.exercise.refactoring.model;

public class TennisGame {
    public static final int scoreZero = 0;
    public static final int scoreFirst = 1;
    public static final int scoreSecond = 2;
    public static final int scoreThird = 3;

    public static String getScore(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        String score = "";
        int result = scoreOfFirstPlayer - scoreOfSecondPlayer;
        int totalScore = 0;
        int i;
        if (scoreOfFirstPlayer == scoreOfSecondPlayer) {
            displayScore(scoreOfFirstPlayer);
        } else if (scoreOfFirstPlayer >= 4 || scoreOfSecondPlayer >= 4) {
            switch (result) {
                case 1:
                    return score += "Advantage Player1";
                case -1:
                    return score += "Advantage Player2";
                case 2:
                    return score += "Player1 is winner";
                case -2:
                    return score += "Player2 is winner";
                default:
                    return score += "I don't know is winner";
            }

        } else {
            for (i = 0; i < 3; i++) {
                if (i == 1) totalScore = scoreOfFirstPlayer;
                else totalScore = scoreOfSecondPlayer;
                displayScore(totalScore);
            }
        }
        return score;
    }

    public static void displayScore(int n) {
        String string = "";
        switch (n) {
            case scoreZero:
                string += "Love";
                break;
            case scoreFirst:
                string += "15";
                break;
            case scoreSecond:
                string += "30";
                break;
            case scoreThird:
                string += "40";
                break;
            default:
                string += "Deuce";
                break;
        }
    }
}
