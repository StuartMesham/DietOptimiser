# Diet Optimiser
An evolutionary diet optimiser which takes as input a menu of food items, their nutritional information and rating (how much you like them), your desired amount of each type of nutrient and the maximum number of items you would be happy to eat.

The optimiser generates and outputs a diet that closely matches your desired nutrient intakes, tastes as good as possible (based on your ratings of each item) and does not exceed your specified maximum number of items.

![Screenshot 2020-03-04 at 16 03 30](https://user-images.githubusercontent.com/28049022/75892716-7575f400-5e3a-11ea-94a1-515517e84583.png)


![Screenshot 2020-03-04 at 16 03 40](https://user-images.githubusercontent.com/28049022/75892829-a22a0b80-5e3a-11ea-8a22-278c1ab0e3d7.png)


![Screenshot 2020-03-04 at 16 04 04](https://user-images.githubusercontent.com/28049022/75892890-b66e0880-5e3a-11ea-9fb1-e332df01c4dc.png)

There is no GUI for customising the menu of food items. The menu can be customised programatically by editing the following lines of code in the `Interface.java` file:

```java
Food[] foods = new Food[15];
foods[0] = new Food("broccoli", 3, 100, 60, 75);
foods[1] = new Food("ice cream", 9, 35, 49, 32);
foods[2] = new Food("sandwich", 7, 60, 72, 41);
foods[3] = new Food("chocolate", 10, 18, 23, 71);
foods[4] = new Food("burger", 10, 65, 72, 75);
foods[5] = new Food("salad", 6, 82, 81, 84);
foods[6] = new Food("fish", 5, 61, 83, 91);
foods[7] = new Food("chips", 7, 62, 35, 32);
foods[8] = new Food("protein shake", 7, 100, 81, 100);
foods[9] = new Food("sparkling water", 0, 1, 0, 0);
foods[10] = new Food("cellphone", -2, 0, 0, 0);
foods[11] = new Food("salmon", 6, 10, 8, 5);
foods[12] = new Food("bacon", 9, 100, 100, 100);
foods[13] = new Food("dog", 10, 93, 43, 23);
foods[14] = new Food("apple", 7, 100, 5, 15);
```

The signature of the Food class' constructor is:
```java
Food(String name, int rating, int vitA, int vitB, int vitC)
```

### Cost function

The cost function (deciding the fitness of a particular diet; lower means better) is implemented in the `cost()` function in the `Diet.java` file.

In short, the cost for a particular diet is calculated as follows:
```
dietCost = 10 * (10 - dietAverageItemRating) + |VitA - TargetVitA| + |VitB - TargetVitB| + |VitC - TargetVitC|
```

### Evolution parameters

Parameters such as the number of generations, population size, children per parent, max mutations per child, max recombination events per child can be customised by calling the set methods on the `Evolution` class.

For example:
```java
evolution.setGenerationSize(100);
evolution.setGenerations(2000);
evolution.setChildrenPerParent(2);
```

The parameters for the simulation that is run by the GUI are set in lines 22-24 of the `CalculateThread.java` file.

### Another example run

![Screenshot 2020-03-04 at 17 17 48](https://user-images.githubusercontent.com/28049022/75895687-a7895500-5e3e-11ea-8ed0-d37f7b168e2e.png)
![Screenshot 2020-03-04 at 17 17 51](https://user-images.githubusercontent.com/28049022/75895705-ad7f3600-5e3e-11ea-940d-ce455df6476f.png)

## Usage instructions

Run the following command from the project root directory:
```bash
ant run
```