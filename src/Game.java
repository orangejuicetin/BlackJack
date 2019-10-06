// main method through which we'll conduct our game
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
	public static void main(String[] args) { 
		/* 
		 * one thing to note; no suits have been included because they're
		 * irrelevant to the game unless it's suited cards, which I've accounted for.
		 * Otherwise, have fun!
		 */
		
		Deck deck = new Deck(); 
		
		deck.shuffle(); // shuffles deck in beginning to give it random order
		
		Scanner scan = new Scanner(System.in); 
		System.out.println("Please input your name: "); 
		
		String name = scan.nextLine(); // get the name 
		
		System.out.println("Hello " + name + "! Pleasure to meet you."); 
		System.out.println("Here's your first hand!"); 
		
		Card first = deck.drawCard(); 
		Card second = deck.drawCard(); 
		int total = first.getValue() + second.getValue(); 
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("You have a " + first.getValue() + " and a " + second.getValue());
		System.out.println("This is the dealer's first hand:"); 
		
		Card dealerFirst = deck.drawCard(); 
		Card dealerSecond = deck.drawCard(); 
		int dealerTotal = dealerFirst.getValue() + dealerSecond.getValue(); 
		
		System.out.println(dealerFirst.getValue()); 
		
		System.out.println("Would you like to hit or stand?"); 

		String move = scan.nextLine(); // get the move string 
		
//		// rudimentary implementation to case on moves, but
//		// likely won't be more than 11 draws (even in worst case where 
//		// you draw the lowest card each time)
//		
//		String move2 = null; 
//		String move3 = null; 
//		String move4 = null; 
//		String move5 = null; 
//		String move6 = null; 
//		String move7 = null; 
//		String move8 = null; 
//		String move9 = null; 
//		String move10 = null;
//		String move11 = null; 

		if (move.equals("hit")) { 
			Card draw = deck.drawCard(); 
			System.out.println("You now have a " + first.getValue() +
					", " + second.getValue() + ", and a " + draw.getValue()); 
			total += draw.getValue(); 
			if (total > 21) { 
				System.out.println("Bust! better luck next time boiii :D");
				System.exit(0); 
			} else { 
				while (move.equals("hit")) { 
					System.out.println("Would you like to hit or stand?");
					move = scan.nextLine(); 
					Card next = deck.drawCard(); 
					System.out.println("Your current total is now " + total + next.getValue());
					total += next.getValue(); 
					if (total > 21) { 
						System.out.println("Bust! better luck next time boiii :D"); 
						System.exit(0); 
					}
				}
			}
		}
		if (move.equals("stand")) { 
			System.out.println("your final total is " + total); 
		}
		
		System.out.println("The dealer total is: " + dealerTotal); 
		if (total < dealerTotal) { 
			System.out.println("You lose! Good try ~ play again to see if you'll win next time!"); 
		} else if (total > dealerTotal) {
			System.out.println("Congrats, you win!"); 
		} else { 
			System.out.println("Push! It's a tie ~ play again to see if you'll win ;))"); 
		}
		scan.close(); 
	}	
}
