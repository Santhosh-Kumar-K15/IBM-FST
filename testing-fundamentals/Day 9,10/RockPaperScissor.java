import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter player 1 name: ");
        String playerOne = obj.nextLine();

        //String[] options = {"rock", "paper","scissor"};


        System.out.print(playerOne + " Choose an option: (rock,paper,scissor)=> ");
        String playerOneChoice = obj.nextLine().toLowerCase();


        Random random = new Random();
        int computerChoiceNumber = random.nextInt(3);
        String computerChoice;
        switch (computerChoiceNumber){
            case 0:
                computerChoice = "rock";
                break;
            case 1:
                computerChoice = "paper";
                break;
            default:
                computerChoice = "scissor";

        }
        if(computerChoice.equals(playerOneChoice)){
            System.out.println(computerChoice+" Its an tie");
        }else if (computerChoice.equals("rock") && playerOneChoice.equals("paper")){
            System.out.println("Computer picks: "+computerChoice+" "+playerOne+" wins");
        } else if (computerChoice.equals("paper") && playerOneChoice.equals("rock")) {
            System.out.println("Computer picks: "+computerChoice+" ,Computer wins");
        } else if (computerChoice.equals("paper") && playerOneChoice.equals("scissor")) {
            System.out.println("Computer picks: "+computerChoice+" "+playerOne+" wins");
        } else if (computerChoice.equals("scissor") && playerOneChoice.equals("paper")) {
            System.out.println("Computer picks: "+computerChoice+" Computer wins");
        } else if (computerChoice.equals("scissor") && playerOneChoice.equals("rock")) {
            System.out.println("Computer picks: "+computerChoice+" "+playerOne+" wins");
        } else if (computerChoice.equals("rock") && playerOneChoice.equals("scissor")) {
            System.out.println("Computer picks: "+computerChoice+" ,Computer wins");
        } else System.out.println("Thanks for playing!!!");
    }
}
