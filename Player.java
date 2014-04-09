import java.util.ArrayList;

/**
 * Created by praghav on 05/04/2014.
 */
public class Player {
    private String name;
    private ArrayList<Card>hand = new ArrayList<Card>();
    private int numCards;
    public Player(String aName){
        this.name = aName;
        this.emptyHand();
    }
    public void emptyHand(){
        this.hand.clear();
    }
    public boolean addCard(Card aCard){
        this.hand.add(numCards,aCard);
        numCards++;
        return(this.getHandSum()<=21);
    }
    public int getHandSum(){
        int handSum = 0;
        int cardNum;
        int numAces =0;
        for(int c=0;c<this.numCards;c++){
            cardNum = this.hand.get(c).getNumber();
            if(cardNum == 1){
                numAces++;
                handSum+=11;
            }
            else if(cardNum>10){
                handSum+=10;
            }else{
                handSum+=cardNum;
            }
        }
        while (handSum>21 && numAces >0){
            handSum -=10;
            numAces--;
        }
        return handSum;
    }
    public boolean isBurst(){
        if(this.getHandSum()>21)return true;
        else return false;
    }
    public void printHand(boolean showFirstCard){
        System.out.printf("%s cards :\n",this.name);
            for(int c=0;c<this.numCards;c++){
                if(c==0 && !showFirstCard) {
                    System.out.println("hidden");
                }else{
                    System.out.println(this.hand.get(c).toString());
                }
            }
    }

}
