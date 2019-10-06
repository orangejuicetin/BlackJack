// basic building block of deck 
public class Card {
	private int value;
	private String valueString; 
	
	// for any normal numbered card 
	public Card(int value) { 
		this.value = value; 
		this.valueString = null; 
	}
	
	// for any royals (K, Q, J) or aces
	public Card(String valueString) { 
		this.valueString = valueString; 
		if (valueString == "kings" || valueString == "queens" ||
				valueString == "jacks" || valueString == "aces") { 
			this.value = 10; 
		} else if (valueString == "ace") { 
			this.value = 11; 
		}
	}
	
	public int getValue() { 
		if (valueString != null) { 
			if (valueString == "kings" || valueString == "queens" ||
					valueString == "jacks") { 
				return 10;
			} else if (valueString == "ace") { 
				return value; 
			}
		}
		return value; 
	}
	
	// value setting ONLY for the ace hand
	public void decreaseAce(int value) { 
		if (this.valueString == "aces") { 
			if (value == 11 || value == 1) {
				this.value = value; 
			}
		}
	}
	
	public String getValueString() { 
		if (this.valueString != null) { 
			return this.valueString; 
		}
		return null; 
	}
}
