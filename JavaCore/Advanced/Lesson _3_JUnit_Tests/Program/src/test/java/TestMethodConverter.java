import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMethodConverter {
    static Main main;
    private int[] testArray;
    private int[] testAnswerArray;


    public TestMethodConverter(int[] testAnswerArray, int[] testArray) {
        this.testArray = testArray;
        this.testAnswerArray = testAnswerArray;
    }

    @BeforeClass
    public static void init() {
        main = new Main();
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new int[][][]{
                {{1, 7}, {1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {{2, 3, 0, 1, 7}, {1, 2, 4, 4, 2, 3, 0, 1, 7}},
                {{7}, {1, 2, 4, 4, 2, 3, 5, 4, 7}},
                {{2, 5, 8, 2, 3, 9, 1, 7}, {4, 2, 5, 8, 2, 3, 9, 1, 7}},
        });
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(testAnswerArray, main.arrayConverter(testArray));
    }

    @Test(expected = RuntimeException.class)
    public void exceptionOfMethodConverter() {
        int [] testArray = new int[]{1, 2, 3, 5, 6, 7, 8, 9};
        main.arrayConverter(testArray);
    }
}
