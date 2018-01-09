package com.JosiasOberholster;

/*
This is a updated version of older game
that has been made.
***************************************
UPDATE:
- Improved performance
- Fixed bug issues
- Total classes reduced to two
- More security is added
**************************************
Author: Josias JJ Oberholster
Last Changed: 1 July 2017.
*/

import java.util.Scanner;

public class Game_Setup {

	Scanner sc = new Scanner(System.in);
	private String playerHand, gameHand;
	private int playerScore, gameScore;
	private boolean active, again;

	/*Run this class first
	 *This method will introduce the player and give the
	 *player a short description on the game.
	 *No input will be required.*/
	private void Intro(){
		System.out.println("Welcome to a game of Rock, Paper and Scissor.");
		System.out.println("This game will ask for your hand, then comapre"
					   + "\nit with the game.");
		System.out.println("A score will be kept in this game.");
		System.out.println("[Rocke beats Scissor.]");
		System.out.println("[Scissor beats Paper.]");
		System.out.println("[Paper beats Rock]");
	}
	
	/*This method will get the player input and add it to ir's reference.
	 *There is a fail safe in place if input is not correct.*/
	private void PlayerHand(){
		active = true;
		System.out.println("Please choose your hand [Rock / Paper / Scissor]");
		do{
			String hand = sc.nextLine();
			
			if(hand.equalsIgnoreCase("rock") || 
			   hand.equalsIgnoreCase("paper") ||
			   hand.equalsIgnoreCase("scissor")){
				playerHand = hand;
				active = false;
			}else{
				System.out.println("ERROR: invalid input, try again");
				System.out.println("[Rock / Paper / Scissor]");
				playerHand = sc.nextLine();
			}
		}while(active);
	}
	
	/*This method will randomize the games' hand.
	 *No input required.*/
	private void GameHand(){
		String hand[] = {"rock", "paper", "scissor",
						 "paper", "scissor", "rock",
						 "scissor", "rock", "paper"};
		int handLength = hand.length;
		int handNumber = (int) (Math.random() * handLength -1);
		gameHand = hand[handNumber];
	}
	
	/*This method will compare the hands, and then return a 
	 *message that will state who wins.
	 *A score will be given to the winner.*/
	private void Compare(){
		//Check to see if player wins.
		if(playerHand.equalsIgnoreCase("rock") &&
		   gameHand.equalsIgnoreCase("paper")){
			System.out.println("Player wins");
			playerScore++;
		}else if(playerHand.equalsIgnoreCase("paper") &&
				gameHand.equalsIgnoreCase("rock")){
			System.out.println("Player wins");
			playerScore++;			
		}else if(playerHand.equalsIgnoreCase("scissor") &&
				gameHand.equalsIgnoreCase("paper")){
			System.out.println("Player wins");
			playerScore++;
		}
		
		//Check to see if game is a draw.
		else if(playerHand.equalsIgnoreCase("rock") &&
		   gameHand.equalsIgnoreCase("rock")){ 
			System.out.println("Game is a draw.");
		}else if(playerHand.equalsIgnoreCase("paper") &&
				gameHand.equalsIgnoreCase("paper")){
			System.out.println("Game is a draw.");			
		}else if(playerHand.equalsIgnoreCase("scissor") &&
				gameHand.equalsIgnoreCase("scissor")){
			System.out.println("Game is a draw.");
		}else{
			//If all other conditions are not met, player looses
			//and game gets a point.
			System.out.println("Game wins");
			gameScore++;
		}
	}
	
	/*Will return score when called.*/
	private void WriteScore(){
		System.out.println("");
		System.out.println("Player Score: " + playerScore);
		System.out.println("Game Score: " + gameScore);
	}
	
	/*The only method that can be called outside if the class
	 *The method will run the game in order, also it has a preset
	 *condition to repeat until "no" has been given as a input.*/
	public void StartGame(){
		Intro();
		do{
			active = true;
			again = true;
			PlayerHand();
			GameHand();
			System.out.println("Player has chosen: " + playerHand);
			System.out.println("Game has chosen: " + gameHand);
			Compare();
			WriteScore();
			
			do{
				System.out.println("Would you like to play again?");
				System.out.println("[yes / no]");
				String playAgain = sc.nextLine();
				if(playAgain.equalsIgnoreCase("yes")){
					again = false;
					active = true;
				}else if(playAgain.equalsIgnoreCase("no")){
					again = false;
					active = false;
					
					System.out.println("Final Score:");
					WriteScore();
				}else{
					System.out.println("ERROR: invalid input, try again");
				}
			}while(again);
		}while(active);	
	}
}
