1. Write a method to which a non-empty one-dimensional integer array is passed as an argument.
   The method should return a new array, which was obtained by pulling
   from the original array of elements after the last four.
   The input array must contain at least one quadruple,
   otherwise, the method must throw a RuntimeException.

   Write a set of tests for this method (3-4 variants of the input data).
   In: [1 2 4 4 2 3 4 1 7] -> out: [1 7].
2. Write a method that checks the composition of an array of numbers 1 and 4.
   If it does not contain at least one four or one, then the method will return false;
   If there is a number other than 1 or 4 then return false;
   Write a set of tests for this method (3-4 variants of the input data).

   [1 1 1 4 4 1 4 4] -> true
   [1 1 1 1 1 1] -> false
   [4 4 4 4] -> false
   [1 4 4 1 1 4 3] -> false