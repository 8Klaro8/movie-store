import java.util.ArrayList;
import java.util.Scanner;

class test{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> myWords = new ArrayList<String>();

        myWords.add("One Piece");
        myWords.add("Two Kingdom");
        myWords.add("Three Tree");


        System.out.println("What do you want to search for?");
        String userInput = scan.nextLine();
        userInput = userInput.toLowerCase();
        searchFunction(myWords, userInput);
    }

    private static void searchFunction(ArrayList<String> myWords, String userInput) {
        for (int i = 0; i < myWords.size(); i++) {
            String lowerCased = myWords.get(i).toLowerCase();
            if (lowerCased.contains(userInput)){
                System.out.println(myWords.get(i));
            }
        }
    }
}