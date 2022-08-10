package ss8_cleancode_refactoring.exercise.refactoring.model;

public class TennisGame1 {
    private int scoreOfFirstPlayer;
    private int scoreOfSecondPlayer;

    public TennisGame1() {
    }

    public TennisGame1(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        this.scoreOfFirstPlayer = scoreOfFirstPlayer;
        this.scoreOfSecondPlayer = scoreOfSecondPlayer;
    }

    public int getPlayer1Score() {
        return scoreOfFirstPlayer;
    }

    public void setPlayer1Score(int scoreOfFirstPlayer) {
        this.scoreOfFirstPlayer = scoreOfFirstPlayer;
    }

    public int getPlayer2Score() {
        return scoreOfSecondPlayer;
    }

    public void setPlayer2Score(int scoreOfSecondPlayer) {
        this.scoreOfSecondPlayer = scoreOfSecondPlayer;
    }

    @Override
    public String toString() {
        return "TennisGameController have " +
                "player1Score = " + scoreOfFirstPlayer +
                ", and player2Score = " + scoreOfSecondPlayer;
    }
}
