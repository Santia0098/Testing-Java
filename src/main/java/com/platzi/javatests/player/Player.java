package com.platzi.javatests.player;

public class Player {

    private Dice dice;
    private int minNumberToWin;

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }

    public Player(Dice dice, int minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }
}
