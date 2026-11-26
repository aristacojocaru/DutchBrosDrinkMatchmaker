import java.util.Scanner;
import java.util.ArrayList;

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
                    "Peppermint", "Chocolate Macadamia Nut",
                    "Coconut", "Cinnamon"};
        } else {
            flavors = new String[]{"Strawberry", "Blue Raspberry",
                    "Peach", "Passion Fruit", "Coconut", "Pomegranate",
                    "Raspberry", "Watermelon", "Blackberry", "Vanilla",
                    "Lime", "Orange", "Grapefruit", "Kiwi",
                    "Banana", "White Chocolate"};
        }

        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ". " + flavors[i]);
        }

        System.out.println("How many flavors would you like? (2 or 3)");
        String amount = scanner.nextLine();

        while (!amount.equals("2") && !amount.equals("3")) {
            System.out.println("Please choose 2 or 3 flavors.");
            amount = scanner.nextLine();
        }

        int numberOfFlavors = Integer.parseInt(amount);
        ArrayList<String> selectedFlavors = new ArrayList<>();

        while (selectedFlavors.size() < numberOfFlavors) {
            System.out.println("Choose flavor #" + (selectedFlavors.size() + 1) + ":");
            String input = scanner.nextLine();

            if (!input.matches("[0-9]{1,2}")) {
                System.out.println("Please enter a valid flavor number.");
                continue;
            }

            int flavorNumber = Integer.parseInt(input);

            if (flavorNumber < 1 || flavorNumber > flavors.length) {
                System.out.println("Invalid flavor number!");
            } else if (selectedFlavors.contains(flavors[flavorNumber - 1])) {
                System.out.println("You already picked that flavor!");
            } else {
                selectedFlavors.add(flavors[flavorNumber - 1]);
            }
        }

        System.out.println("Your selected flavors: " + selectedFlavors);

        ArrayList<Drink> drinks = DrinkMatcher.loadDrinks();
        System.out.println("Loaded " + drinks.size() + " drinks from the database.");

        scanner.close();
    }
}