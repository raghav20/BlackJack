/**
 * Created by praghav on 05/04/2014.
 */
import java.util.Scanner;
public class Game {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {


        int money=100;
        int bet;
        boolean userWins;
        //add 2 -2 cards from both dealer and player.

        while(true){
            Deck theDeck= new Deck(1,true);
            Player me = new Player("Raghav");
            Player dealer = new Player("Dealer");
            System.out.println("You have $" + money );
            System.out.println("How much money you want to bet");
            bet = sc.nextInt();
            if(bet <0 || bet >money){
                System.out.println("your bet must be between 0 and " + money);

            }

            if(bet ==0){
                break;
            }

            userWins = startGame(theDeck,me,dealer);

            if(userWins){
                money = money+bet;
            }else{
                money = money-bet;
            }
            System.out.println();
            if(money <= 0){
                System.out.println("You have run out of money" );
                break;
            }

        }
        sc.close();
    }
    public static boolean startGame(Deck theDeck,Player me,Player dealer){
       // Scanner sc = new Scanner(System.in);

        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        System.out.println("Cards are dealing");
        //printing players hand.
        me.printHand(true);
        dealer.printHand(true);
        System.out.println("\n");

        boolean meDone = false;
        boolean dealerDone = false;

        String ans;
        while (!meDone || !dealerDone){
            if(!meDone){
                System.out.println("Hit or Stay? (Enter H or S)");
                ans =  sc.next();
                if(ans.compareToIgnoreCase("H") == 0){
                    meDone = !me.addCard(theDeck.dealNextCard());
                    me.printHand(true);

                }else{
                    meDone = true;
                }

            }
            if(!dealerDone) {
                if(dealer.getHandSum()<17) {
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    dealer.printHand(false);
                }
                else {
                    System.out.println("Dealer Stays");
                    dealerDone = true;
                }
            }
            System.out.println("");
        }
       // sc.close();
        me.printHand(true);
        dealer.printHand(true);
        //sc.close();
        return(getWinner(me,dealer));
    }

    public static boolean getWinner(Player me,Player dealer){
        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();
        System.out.println("Dealer Sum" +dealerSum );
        System.out.println("My Sum" +mySum );
        if((mySum > dealerSum && !me.isBurst()) || dealer.isBurst()){
            System.out.println("Player wins");
            return true;
        }
        else {
            System.out.println("Dealer Wins");
            return false;
        }
    }


}
