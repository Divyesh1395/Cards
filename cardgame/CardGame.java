
package cardgame;

import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author DIVYESH
 */

class Card{
    String category;
    char values;
    
    Card(String category, char values){
       this.category = category;
       this.values = values;
    }
    
    /*Card getCard(){
        return Card;
    }*/
    
    @Override
    public String toString(){
        String str = "";
        switch(values){
            case 'A': str += "Ace";
            break;
            case '2': str += "Two";
            break;
            case '3': str += "Three";
            break;
            case '4': str += "Four";
            break;
            case '5': str += "Five";
            break;
            case '6': str += "Six";
            break;
            case '7': str += "Seven";
            break;
            case '8': str += "Eight";
            break;
            case '9': str += "Nine";
            break;
            case 'T': str += "Ten";
            break;
            case 'J': str += "Jack";
            break;
            case 'Q': str += "Queen";
            break;
            case 'K': str += "King";
            break;
        }
        str += " of " + category;
        return str;
    }
}

public class CardGame {

    public static void main(String[] args) {
        Card cards[] = new Card[52];
        Random ran = new Random();
        
        {
            cards[0] = new Card("Clubs",'A');
            for(int i=1; i<9; i++){
                cards[i] = new Card("Clubs", (char)(i+49));
            }
            cards[9] = new Card("Clubs",'T');
            cards[10] = new Card("Clubs",'J');
            cards[11] = new Card("Clubs",'Q');
            cards[12] = new Card("Clubs",'K');

            cards[13] = new Card("Diamonds",'A');
            for(int i=14; i<22; i++){
                cards[i] = new Card("Diamonds", (char)(i+36));
            }
            cards[22] = new Card("Diamonds",'T');
            cards[23] = new Card("Diamonds",'J');
            cards[24] = new Card("Diamonds",'Q');
            cards[25] = new Card("Diamonds",'K');

            cards[26] = new Card("Hearts",'A');
            for(int i=27; i<35; i++){
                cards[i] = new Card("Hearts", (char)(i+23));
            }
            cards[35] = new Card("Hearts",'T');
            cards[36] = new Card("Hearts",'J');
            cards[37] = new Card("Hearts",'Q');
            cards[38] = new Card("Hearts",'K');

            cards[39] = new Card("Spades",'A');
            for(int i=40; i<48; i++){
                cards[i] = new Card("Spades", (char)(i+10));
            }
            cards[48] = new Card("Spades",'T');
            cards[49] = new Card("Spades",'J'); 
            cards[50] = new Card("Spades",'Q');
            cards[51] = new Card("Spades",'K');
        }
        
        for(int i=0; i<52; i++){
            if((i%13) == 0) System.out.println();
            System.out.println(cards[i]);
        }
        
        for(;;){
            try{
                for(int i=1; i<25; i++){
                    int a = ran.nextInt(51);
                    int b = ran.nextInt(51);
                    Card temp = cards[a];
                    cards[a] = cards[b];
                    cards[b] = temp;
                }
                System.out.println("\nCards Shuffled ");
                System.out.println("\nPick a Card enter a number between 1 to 52 inclusive only");
                Scanner scan = new Scanner(System.in);
                int index = scan.nextInt();
                if(index>=1 && index<=52){
                    System.out.println("\nYou picked : " + cards[index-1]);
                }
                else if(index == 0) break;
            }
            catch(java.util.InputMismatchException e){
                System.out.println("\n-----Only Numbers are allowed-----");
                continue;
            }
        }
     
    }
    
}
