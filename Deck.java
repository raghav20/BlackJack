import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck{
    private ArrayList<Card> myCards = new ArrayList<Card>();
    private int numCards;
    public Deck(){
        this(1,false);
    }
    public Deck(int numDecks,boolean shuffle){
        this.numCards = numDecks*52;
        for(int d=0;d<numDecks;d++){
            for(int s=0;s<4;s++){
                for(int n=1;n<=13;n++){
                    myCards.add(new Card(Suit.values()[s],n));

                }
            }
        }
        if(shuffle){
            this.shuffle();
        }
      }
    private void shuffle(){
        Random rNumber = new Random();

        int j;
        for(int i=0;i<numCards;i++){
            j = rNumber.nextInt(this.numCards);
            Collections.swap(myCards,i,j);
        }
    }
    public Card dealNextCard(){
        Card top = this.myCards.get(0);
        this.myCards.remove(0);
        return top;
    }
    public void printDeck(int numPrint){
        for(int c=0;c<numPrint;c++){
            System.out.printf("% 3d %d %s\n",c+1,this.numCards,this.myCards.get(c).toString());
        }

    }

}