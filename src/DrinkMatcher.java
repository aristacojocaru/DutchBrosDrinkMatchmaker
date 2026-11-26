import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class DrinkMatcher {

    public static ArrayList<Drink> loadDrinks() {
        ArrayList<Drink> drinks = new ArrayList<>();

        try (Scanner file = new Scanner(new File("drinks.csv"))) {

            // Skip the header because it is not an actual drink.
            if (file.hasNextLine()) {
                file.nextLine();
            }

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0];
                    String base = parts[1];
                    String[] flavors = parts[2].split("\\|");

                    drinks.add(new Drink(name, base, flavors));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find drinks.csv!");
        }

        return drinks;
    }

    public static Drink findMatch(String base,
                                  ArrayList<String> selectedFlavors,
                                  ArrayList<Drink> drinks) {

        Drink bestMatch = null;
        double bestScore = 0;

        for (Drink drink : drinks) {

            // Only compare drinks with the correct base.
            if (base.equals("Coffee")) {
                if (!drink.base.equals("Coffee")) {
                    continue;
                }
            } else {
                if (!drink.base.equals("Fruity")) {
                    continue;
                }
            }

            int matches = 0;

            for (String flavor : drink.flavors) {
                if (selectedFlavors.contains(flavor)) {
                    matches++;
                }
            }

            // Give higher scores to drinks with more matching flavors.
            double score = (double) matches /
                    (selectedFlavors.size() + drink.flavors.length - matches);

            if (matches >= 2 && score > bestScore) {
                bestScore = score;
                bestMatch = drink;
            }
        }

        return bestMatch;
    }

}