import java.util.*;
public class Deck {
	private List<Card> cards; 
	public Deck() { 
		cards = new ArrayList<Card>(); 
		for (int i = 2; i <= 10; i++) { 
			cards.add(new Card(i)); 
			cards.add(new Card(i)); 
			cards.add(new Card(i)); 
			cards.add(new Card(i)); 
		}
		for (int i = 0; i < 4; i++) { 
			cards.add(new Card("jacks"));
		} 
		for (int i = 0; i < 4; i++) { 
			cards.add(new Card("queens"));
		} 
		for (int i = 0; i < 4; i++) { 
			cards.add(new Card("kings"));
		} 
		for (int i = 0; i < 4; i++) { 
			cards.add(new Card("aces"));
		} 
	}
	
	public Card drawCard() { 
		int index = (int) (Math.random() * 53); 
		Card output = cards.get(index);
		cards.remove(index); 
		return output; 
	}

	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int index = i + (int) (Math.random() * (51 - i));
			Card replace = cards.get(index);
			Card curr = cards.get(i);
			cards.set(i, replace);
			cards.set(index, curr);
		}
	}
	
}
