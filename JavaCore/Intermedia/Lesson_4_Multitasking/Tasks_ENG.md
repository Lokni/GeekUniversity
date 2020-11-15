1. You need to write two methods that do the following:

1) Create a one-dimensional long array, for example:
   static final int size = 10000000;
   static final int h = size / 2;
   float[] arr = new float[size];
2) Fill this array with ones;
3) Time of execution is timed: long a = System.currentTimeMillis ();
4) They pass through the entire array and for each cell calculate a new value using the formula:
   arr[i] = (float) (arr[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2)) ;
5) The end time of the System.currentTimeMillis() method is checked;
6) The operating time is displayed in the console: System.out.println(System.currentTimeMillis() - a);
   The difference between the first method and the second:
   The first one just runs through the array and calculates the values.
   The second splits the array into two arrays, calculates new values ​​in two threads
   and then glues these arrays back into one.

   An example of dividing one array into two:
   System.arraycopy (arr, 0, a1, 0, h);
   System.arraycopy (arr, h, a2, 0, h);

   Example of back gluing:
   System.arraycopy (a1, 0, arr, 0, h);
   System.arraycopy (a2, 0, arr, h, h);

   Note:
   System.arraycopy () copies data from one array to another:
   System.arraycopy (source array, from where we start to take data from the source array,
   array-destination, from where we begin to write data to the array-destination, how many cells we copy)
   By measurements of time:
   For the first method, you need to count the time only for the calculation cycle:
   for (int i = 0; i < size; i ++) {
   arr[i] = (float) (arr[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2)) ;
   }
   For the second method, measure the time to split the array by 2,
   rendering each of the two arrays and gluing.