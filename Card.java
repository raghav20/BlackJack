public class Card{
	private Suit mySuit;
	private int myNumber;
	public Card(Suit aSuit,int aNumber){
		this.mySuit = aSuit;
        if(aNumber >=1 && aNumber<=13){
            this.myNumber = aNumber;
        }
        else{
            System.err.println(aNumber+"is not a valid card number");
            System.exit(1);
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