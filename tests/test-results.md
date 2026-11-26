
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


