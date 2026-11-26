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
}