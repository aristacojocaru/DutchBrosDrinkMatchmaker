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

        ArrayList<Drink> recommendations =
                DrinkMatcher.findMatches(base, selectedFlavors, drinks);

        Drink match = null;

        System.out.println("\nYour Drink Recommendations:");

        if (recommendations.isEmpty()) {
            System.out.println("No matching recipes found!");
            System.out.println("Let's create a custom drink instead.");
        } else {
            Drink bestMatch = recommendations.get(0);

            boolean exactMatch = bestMatch.flavors.length == selectedFlavors.size()
                    && selectedFlavors.containsAll(java.util.Arrays.asList(bestMatch.flavors));

            if (exactMatch) {
                match = bestMatch;
                System.out.println("We found an exact match!");
            } else {
                System.out.println("Here are your closest matches!");

                for (int i = 0; i < recommendations.size(); i++) {
                    Drink drink = recommendations.get(i);

                    System.out.println((i + 1) + ". " + drink.name);
                    System.out.println("   Flavors: " + String.join(", ", drink.flavors));
                }

                int customOption = recommendations.size() + 1;

                System.out.println(customOption + ". Keep my original flavors");
                System.out.println("\nWhich drink would you like?");

                String decision = scanner.nextLine();

                while (!decision.matches("[1-" + customOption + "]")) {
                    System.out.println("Please choose a number from 1-" + customOption + ".");
                    decision = scanner.nextLine();
                }

                int selectedOption = Integer.parseInt(decision);

                if (selectedOption != customOption) {
                    match = recommendations.get(selectedOption - 1);
                }
            }
        }

        System.out.println("\nYour selected drink:");

        if (match == null) {
            System.out.println("Custom " + base);
            System.out.println("Flavors: " + String.join(", ", selectedFlavors));
        } else {
            System.out.println(match.name + " (" + base + ")");
            System.out.println("Flavors: " + String.join(", ", match.flavors));
        }

        System.out.println("\nWhat size would you like?");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        String sizeChoice = scanner.nextLine();

        while (!sizeChoice.matches("[1-3]")) {
            System.out.println("Please choose a size from 1-3.");
            sizeChoice = scanner.nextLine();
        }

        String size = "";

        if (sizeChoice.equals("1")) {
            size = "Small";
        } else if (sizeChoice.equals("2")) {
            size = "Medium";
        } else {
            size = "Large";
        }

        System.out.println("You picked " + size + "!");

        String[] preparationOptions;

        if (base.equals("Coffee")) {
            preparationOptions = new String[]{"Hot", "Iced", "Blended"};
        } else if (base.equals("Rebel") || base.equals("Lemonade")) {
            preparationOptions = new String[]{"Iced", "Blended"};
        } else if (base.equals("Tea")) {
            preparationOptions = new String[]{"Hot", "Iced"};
        } else {
            preparationOptions = new String[]{"Iced"};
        }

        String preparation;

        if (preparationOptions.length == 1) {
            preparation = preparationOptions[0];
        } else {
            System.out.println("\nHow would you like your drink prepared?");

            for (int i = 0; i < preparationOptions.length; i++) {
                System.out.println((i + 1) + ". " + preparationOptions[i]);
            }

            String prepChoice = scanner.nextLine();

            while (!prepChoice.matches("[1-" + preparationOptions.length + "]")) {
                System.out.println("Please choose a valid preparation option.");
                prepChoice = scanner.nextLine();
            }

            preparation = preparationOptions[Integer.parseInt(prepChoice) - 1];
        }

        System.out.println("Preparation: " + preparation);

        String milk = "";

        if (base.equals("Coffee")) {
            String[] milkOptions = {"Default Milk", "2% Milk",
                    "Half and Half", "Chocolate Milk", "Nonfat Milk",
                    "Oat Milk", "Almond Milk", "Coconut Milk"};

            System.out.println("\nWhat kind of milk would you like?");

            for (int i = 0; i < milkOptions.length; i++) {
                System.out.println((i + 1) + ". " + milkOptions[i]);
            }

            String milkChoice = scanner.nextLine();

            while (!milkChoice.matches("[1-8]")) {
                System.out.println("Please choose a milk option from 1-8.");
                milkChoice = scanner.nextLine();
            }

            milk = milkOptions[Integer.parseInt(milkChoice) - 1];

            System.out.println("Milk: " + milk);
        }

        String teaType = "";

        if (base.equals("Tea")) {
            System.out.println("\nWhat kind of tea would you like?");
            System.out.println("1. Black Tea");
            System.out.println("2. Green Tea");

            String teaChoice = scanner.nextLine();

            while (!teaChoice.matches("[1-2]")) {
                System.out.println("Please choose 1 or 2.");
                teaChoice = scanner.nextLine();
            }

            if (teaChoice.equals("1")) {
                teaType = "Black Tea";
            } else {
                teaType = "Green Tea";
            }

            System.out.println("Tea type: " + teaType);
        }

        boolean dirtySoda = false;

        if (base.equals("Soda")) {
            System.out.println("\nWould you like to add sweet cream to make it a Dirty Soda?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            String creamChoice = scanner.nextLine();

            while (!creamChoice.matches("[1-2]")) {
                System.out.println("Please choose 1 or 2.");
                creamChoice = scanner.nextLine();
            }

            if (creamChoice.equals("1")) {
                dirtySoda = true;
                System.out.println("Sweet cream added!");
            } else {
                System.out.println("Keeping your regular soda!");
            }
        }

        System.out.println("\n==============================");
        System.out.println("      YOUR FINAL ORDER");
        System.out.println("==============================");

        if (match == null) {
            System.out.println("Drink: Custom " + base);
            System.out.println("Flavors: " + String.join(", ", selectedFlavors));
        } else {
            System.out.println("Drink: " + match.name + " (" + base + ")");
            System.out.println("Flavors: " + String.join(", ", match.flavors));
        }

        System.out.println("Size: " + size);
        System.out.println("Preparation: " + preparation);

        if (base.equals("Coffee")) {
            System.out.println("Milk: " + milk);
        }

        if (base.equals("Tea")) {
            System.out.println("Tea type: " + teaType);
        }

        if (dirtySoda) {
            System.out.println("Add-on: Sweet Cream (Dirty Soda)");
        }

        System.out.println("==============================");
        System.out.println("Thanks for using the Dutch Bros Drink Matchmaker!");
        System.out.println("Enjoy your drink!");

        scanner.close();
    }
}