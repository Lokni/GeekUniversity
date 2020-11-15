1. Write a method that swaps two array elements
  (the array can be of any reference type);
2. Write a method that converts the array to ArrayList;
3. Big task:

    There are classes Fruit -> Apple, Orange (no more fruit needed);
    A Box class into which fruits can be stored. The boxes are conventionally sorted by fruit type,
    therefore, you cannot put both apples and oranges in one box;
    An ArrayList can be used to store the fruit inside the box;
    Make a getWeight () method that calculates the weight of the box,
    knowing the number of fruits and the weight of one fruit (apple weight - 1.0f, orange - 1.5f.
    It doesn't matter, in what units it is);
    Inside the Box class, make a compare method that allows you to compare the current box
    with the one which will be passed to compare as a parameter,
    true - if they are equal in weight, false - otherwise
   (we can compare boxes with apples to boxes with oranges);
    Write a method that allows you to pour fruits from the current box into another
   (remember about sorting fruits: you cannot pour apples into a box with oranges).
    Accordingly, there are no fruits left in the current box, and objects are thrown into another,
    which were in this box;
    Let's not forget about the method of adding fruit to the box.