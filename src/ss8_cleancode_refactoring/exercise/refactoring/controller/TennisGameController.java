package ss8_cleancode_refactoring.exercise.refactoring.controller;

import ss8_cleancode_refactoring.exercise.refactoring.model.TennisGame;
import ss8_cleancode_refactoring.exercise.refactoring.model.TennisGame1;

import java.util.Scanner;

public class TennisGameController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter score of play1: ");
        int score1 = Integer.parseInt(scan.nextLine());

        System.out.println("Enter score of play2: ");
        int score2 = Integer.parseInt(scan.nextLine());

        TennisGame1 tennis = new TennisGame1(score1, score2);
        System.out.println(tennis.toString());


        System.out.println(TennisGame.getScore(score1, score2));
    }
}
