import java.util.Arrays;

public class Main {

    public int[] arrayConverter(int[] array){
            int len = 0;
            int[] convertedArray = new int[len];
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] == 4) {
                    len = array.length - i;
                    convertedArray = new int[len - 1];
                    for (int j = i + 1, index = 0; j < array.length; j++, index++) {
                        convertedArray[index] = array[j];
                    }
                    break;
                } else if (i == 0) {
                    throw new RuntimeException("Number 4 is missing in array");
                }
            }
            return convertedArray;
    }

    public boolean numberFourAndOneInArray(int[] array){
        int counterOne = 0;
        int counterFour = 0;
        for (int j : array) {
            if (j == 1) {
                counterOne++;
            }
            if (j == 4) {
                counterFour++;
            }
        }
        return counterFour != 0 && counterOne != 0 && (counterOne + counterFour) == array.length;
    }

}
