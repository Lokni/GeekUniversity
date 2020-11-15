1. Write a method that receives a 4x4 two-dimensional string array as input,
   throwing a MyArraySizeException when feeding an array of a different size.
2. Next, the method must go through all the elements of the array, convert to int, and sum.
   If the conversion failed in some element of the array
   (for example, a cell contains a symbol or text instead of a number),
   an exception MyArrayDataException must be thrown - verbose,
   which cell contains the incorrect data.
3. In the main () method, call the resulting method, handle possible exceptions MySizeArrayException
   and MyArrayDataException and print the calculation result.