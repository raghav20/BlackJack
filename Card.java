public class Card{
	
        }

	}
	public int getNumber(){
		return myNumber;
	}
	public String toString(){

		String[] number = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		String numStr = null;
		numStr = number[myNumber-1];
		return numStr + " of " + mySuit.toString();
	}
}
