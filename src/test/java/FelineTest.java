import com.example.Feline;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void eatMeatReturnsCorrectFelineFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedListOfFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualListOfFood = feline.eatMeat();

        Assert.assertEquals(expectedListOfFood, actualListOfFood);
    }

    @Test
    public void getFamilyReturnsCorrectFamilyForFeline() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnsCorrectNumOfFelineKittens() {
        Feline feline = new Feline();
        int expectedNumberOfKittens = 1;

        int actualNumberOfKittens = feline.getKittens();

        Assert.assertEquals(expectedNumberOfKittens, actualNumberOfKittens);
    }

}
