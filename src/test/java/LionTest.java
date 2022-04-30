import com.example.Feline;
import com.example.Lion;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getManeData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }
    private final String lionSex;
    private final boolean hasMane;

    public LionTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        boolean expectedValue = hasMane;
        // Act
        boolean actualValue = lion.doesHaveMane();
        // Assert
        Assert.assertEquals(expectedValue, actualValue);
    }

//    @Test
//    public void doesHaveManeReturnsTrueIfLionIsMale() throws Exception {
//        // Arrange
//        String lionSex = "Самец";
//        Lion lion = new Lion(lionSex, feline);
//        boolean expectedValue = true;
//        // Act
//        boolean actualValue = lion.doesHaveMane();
//        // Assert
//        Assert.assertEquals(expectedValue, actualValue);
//    }
//
//    @Test
//    public void doesHaveManeReturnsFalseIfLionIsFemale() throws Exception {
//        // Arrange
//        String lionSex = "Самка";
//        Lion lion = new Lion(lionSex, feline);
//        boolean expectedValue = false;
//        // Act
//        boolean actualValue = lion.doesHaveMane();
//        // Assert
//        Assert.assertEquals(expectedValue, actualValue);
//    }

    @Test(expected = Exception.class)
    public void LionThrowsExceptionWhenSexIsIncorrect() throws Exception {
        String incorrectLionSex = "Самса";
        Lion lion = new Lion(incorrectLionSex, feline);
    }

    @Test()
    public void LionThrowsExceptionWithCorrectTextWhenSexIsIncorrect() throws Exception {
        Exception exception = null;
        String incorrectLionSex = "Самса";
        String expectedExceptionText = "Используйте допустимые значения пола животного - самец или самка";

        try {
            Lion lion = new Lion(incorrectLionSex, feline);
        } catch (Exception ex) {
            exception = ex;
        }

        Assert.assertNotEquals(null, exception);
        Assert.assertEquals(expectedExceptionText, exception.getMessage());
    }

    @Test()
    public void getKittensReturnsCorrectNumOfLionKittens() throws Exception {
        String lionSex = "Самка";
        Lion lion = new Lion(lionSex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedNumberOfKittens = 1;

        int actualNumberOfKittens = lion.getKittens();

        Assert.assertEquals(expectedNumberOfKittens, actualNumberOfKittens);
    }

    @Test()
    public void getFoodReturnsCorrectLionFood() throws Exception {
        String lionSex = "Самка";
        Lion lion = new Lion(lionSex, feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedListOfFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualListOfFood = lion.getFood();

        Assert.assertEquals(expectedListOfFood, actualListOfFood);
    }
}
