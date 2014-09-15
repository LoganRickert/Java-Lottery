/*
 * This project picks three random numbers between 1 and 10 and then asks the 
 * user for 3 numbers between 1 and 10. If the user gets all three numbers
 * correct in the exact order, they win $10,000. If the user gets 3 correct,
 * but not in the correct order, they win $5,000. If they get 1 or 2 correct,
 * they get $1,000 or $2,000 respectfully.

 * If you pick none correct, you lose $1,000. If you have no money left, you
 * lose.
 */

package lottery;

import java.util.Scanner;

/**
 * @author Logan Rickert
 */
public class Lottery {

    public static void main(String[] args) {
        
        // init classes
        Scanner keyboard = new Scanner(System.in);
        
        // init variables
        boolean playing = true;
        int money = 1000;
        
        // Sets the numbers to pick between.
        final int BETWEEN_A = 1;
        final int BETWEEN_B = 10;
        
        // Start playing loop.
        while(playing == true){
            
            // init variables
            int wins = 0;
            String win_output = "";
            
            int lottery1 = (int) Math.ceil(Math.random() * BETWEEN_B - Math.random() * BETWEEN_A);   
            int lottery2 = (int) Math.ceil(Math.random() * BETWEEN_B - Math.random() * BETWEEN_A);       
            int lottery3 = (int) Math.ceil(Math.random() * BETWEEN_B - Math.random() * BETWEEN_A);

            // Makes sure all numbers are unique.
            while(lottery2 == lottery1){
                lottery2 = (int) Math.ceil(Math.random() * BETWEEN_B - Math.random() * BETWEEN_A);
            }

            while(lottery3 == lottery1 && lottery3 == lottery2){
                lottery3 = (int) Math.ceil(Math.random() * BETWEEN_B - Math.random() * BETWEEN_A);
            }
            
            // Asks user for input.
            System.out.printf("Please enter 3 integers between %d and %d: ", BETWEEN_A, BETWEEN_B);
            int pick1 = keyboard.nextInt();
            int pick2 = keyboard.nextInt();
            int pick3 = keyboard.nextInt();

            // Makes sure the user inputs a number between 1 and 10.
            while(pick1 > (BETWEEN_B + 1) || pick1 < (BETWEEN_A - 1)){
                System.out.printf("The first number you have picked is not "
                        + "between %d and %d! Please try again: ", BETWEEN_A, BETWEEN_B);
                pick1 = keyboard.nextInt();
            }
            while(pick2 > (BETWEEN_B + 1) || pick2 < (BETWEEN_A - 1)){
                System.out.printf("The second number you have picked is not "
                        + "between %d and %d! Please try again: ", BETWEEN_A, BETWEEN_B);
                pick2 = keyboard.nextInt();
            }
            while(pick3 > (BETWEEN_B + 1) || pick3 < (BETWEEN_A - 1)){
                System.out.printf("The third number you have picked is not "
                        + "between %d and %d! Please try again: ", BETWEEN_A, BETWEEN_B);
                pick3 = keyboard.nextInt();
            }
            
            // Calculates how many wins you have.
            if(pick1 == lottery1 || pick1 == lottery2 || pick1 == lottery3){
                wins += 1;
            }
            if(pick2 == lottery1 || pick2 == lottery2 || pick2 == lottery3){
                wins += 1;
            }
            if(pick3 == lottery1 || pick3 == lottery2 || pick3 == lottery3){
                wins += 1;
            }
            if(pick1 == lottery1 && pick2 == lottery2 && pick3 == lottery3){
                wins += 1;
            }

            // Calculates the output and adds your money.
            if(wins == 4){
                win_output = "Congrats! You won $10,000!";
                money += 10000;
            }
            if(wins == 3){
                win_output = "Congrats! You won $5,000!";
                money += 5000;
            }
            if(wins == 2){
                win_output = "Congrats! You won $2,000!";
                money += 2000;
            }
            if(wins == 1){
                win_output = "Congrats! You won $1,000!";
                money += 1000;
            }
            if(wins == 0){
                win_output = "You lost $1,000!";
                money -= 1000;
            }

            // Tells the user how many they picked correctly and what they numbers
            // were and how much they won or lost.
            System.out.println("You picked " + wins + " correctly! The numbers were " 
                    + lottery1 + " " + lottery2 + " " + lottery3 + ". " + win_output);
            
            // If the user has no money left, end the game.
            if(money <= 0){
                System.out.println("You have no more money left! You lose :(");
                System.exit(0);
            }
            
            // Asks the user if they want to play again. If "yes", then repeat
            // loop, else quit.
            System.out.printf("You have $%,d. Would you like to play again? (yes / no) ", money);
            
            playing = (("yes").equalsIgnoreCase(keyboard.next()));
        }
        
        // The end!
        System.out.println("Thanks for playing!");
    }
    
}
