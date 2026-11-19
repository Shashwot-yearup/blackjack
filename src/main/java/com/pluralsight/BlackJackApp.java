package com.pluralsight;


import java.util.Scanner;

public class BlackJackApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        play(input);
    }

    //Method to run the program.
    public static void play(Scanner input) {

        System.out.println("Welcome to the BlackJack Game!\n");

        //Gets name for player one
        System.out.println("Please enter your name for player 1");
        String player1 = input.nextLine();

        //Gets name for player Two
        System.out.println("Please enter your name for player 2");
        String player2 = input.nextLine();

        //Creates deck and also shuffles it.
        Deck deck = new Deck();
        deck.shuffle();

        //Creates hands
        Hand hand = new Hand();
        Hand hand2 = new Hand();

        //forLoop to deal each player.
        for (int i = 0; i < 2; i++) {
            hand.deal(deck.deal());
            hand2.deal(deck.deal());
        }

        System.out.println("\n" + player1 + "'s hand: "
                + hand.getValue());

        System.out.println("\n" + player2 + "'s hand: "
                + hand2.getValue());

        int player1score = hand.getValue();
        int player2score = hand2.getValue();

        //If else to check who own.
        if (player1score > 21 && player2score > 21) {
            System.out.println("Both players went over 21. No winner!");
        } else if (player1score > 21) {
            System.out.println(player2 + " wins!");
        } else if (player2score > 21) {
            System.out.println(player1 + " wins!");
        } else if (player1score > player2score) {
            System.out.println(player1 + " wins!");
        } else if (player2score > player1score) {
            System.out.println(player2 + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}