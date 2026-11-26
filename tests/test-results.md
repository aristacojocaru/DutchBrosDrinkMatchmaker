
# Testing Log

## 11/26 - Drink Base Selection

Got the welcome screen and drink base options working.

- Picked 2 and got Rebel.
- Tried 9, "hello", and leaving the input blank. All three gave an error and let me try again.
- Picked 1 and got Coffee.
- Tried 8, then 3. It rejected 8 and correctly gave me Lemonade.

Everything worked without crashing during these tests.

Next step: add different flavor options depending on which drink base the customer picks.



## 11/26 - Flavor Options

Added two different flavor lists since Rebel, lemonade, soda, and tea all share the same flavors.

- Tested coffee and got all 7 flavors, including peppermint.
- Tested the other four bases and got the same 11 flavors for each.
- Tried invalid base selections again to make sure the previous code still worked.

All the flavor menus worked. I also tried selecting a flavor before realizing I hadn't added flavor selection yet.

Next step: let customers actually choose 2-3 flavors.



## 11/26 - Choosing Flavors

Added the option to choose 2 or 3 flavors and used an ArrayList to keep track of the customer's choices.

- Tried vanilla and peppermint with coffee.
- Tried strawberry, peach, and coconut with a Rebel.
- Tried choosing 1 and 4 flavors, but the program only accepted 2 or 3.
- Tried picking strawberry twice and it made me choose a different flavor.
- Tested random numbers, letters, and blank inputs.
- Made sure flavors 10 and 11 could still be selected.

Everything worked as expected.

Next step: start putting together the actual drink database so the program can recommend drinks.


## 11/26 - Drink Database and Expanded Flavors

Added 19 drink recipes to a CSV file and expanded the flavor
options to 10 coffee flavors and 16 fruity flavors.

- Initially got 4 compilation errors because the Drink class
  was missing. Fixed this by implementing Drink.java.
- Selected Blackberry and Vanilla and successfully loaded
  all 19 drinks.
- Tested Chocolate Macadamia Nut and Cinnamon. Both worked.
- Tested Orange, Kiwi, and White Chocolate. All three worked.
- Temporarily renamed drinks.csv to see what would happen
  if the file was missing. The program displayed an error
  message instead of crashing and loaded 0 drinks.
- Restored the CSV file after testing.

All tests passed after fixing the compilation error.

Next step: create the algorithm that matches the customer's
selected flavors to an actual Dutch Bros drink.


## 11/26 - Drink Matching Algorithm and Customer Choice

Added the algorithm that matches the customer's selected
flavors to an existing Dutch Bros drink.

- Selected Vanilla and Caramel and got Golden Eagle.
- Selected Strawberry and Peach and originally got
  Double Rainbro as the closest match.
- Realized customers might not want extra flavors added,
  so I added the option to accept the recommendation
  or keep their original flavors.
- Added Rose City (Strawberry and Peach) to the CSV,
  bringing the database to 20 recipes.
- Tested Rose City and got an exact match.
- Accepted Shark Attack and got all four recipe flavors.
- Declined Shark Attack and kept only Blue Raspberry
  and Coconut.
- Entered 9, "hello", and a blank response when asked
  to accept the recommendation. All were rejected.
- Selected Strawberry, Peach, and Coconut for a Soda
  and got an exact match for Double Rainbro.
- Tested a missing CSV file again. The program returned
  a custom drink instead of crashing.
- Tested Vanilla and Coconut in a coffee. The program
  returned a custom coffee instead of a fruity recipe.
- Tested Caramel and Vanilla in reverse order and
  still got Golden Eagle.

All 14 planned checks passed throughout development.
The final regression test also passed.

One small thing to fix later is making the final drink
heading consistent for custom drinks.

Next step: add size, preparation, and milk options.

