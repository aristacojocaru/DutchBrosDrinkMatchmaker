import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Dutch Bros Drink Matchmaker!");
        System.out.println("What kind of drink are you craving?");
        System.out.println("1. Coffee");
        System.out.println("2. Rebel");
        System.out.println("3. Lemonade");
        System.out.println("4. Soda");
        System.out.println("5. Tea");

        String choice = scanner.nextLine();

        while (!choice.matches("[1-5]")) {
            System.out.println("Invalid choice! Pick a number from 1-5.");
            choice = scanner.nextLine();
        }

        String base = "";

        if (choice.equals("1")) {
            base = "Coffee";
        } else if (choice.equals("2")) {
            base = "Rebel";
        } else if (choice.equals("3")) {
            base = "Lemonade";
        } else if (choice.equals("4")) {
            base = "Soda";
        } else {
            base = "Tea";
        }

        System.out.println("You picked " + base + "!");

        System.out.println("Here are your flavor options:");

        String[] flavors;

        if (base.equals("Coffee")) {
            flavors = new String[]{"Vanilla", "Caramel", "Chocolate",
                    "Hazelnut", "White Chocolate", "Irish Cream",
                    "Peppermint"};
        } else {
            flavors = new String[]{"Strawberry", "Blue Raspberry",
                    "Peach", "Passion Fruit", "Coconut", "Pomegranate",
                    "Raspberry", "Watermelon", "Blackberry", "Vanilla",
                    "Lime"};
        }

        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ". " + flavors[i]);
        }

        scanner.close();
    }
}