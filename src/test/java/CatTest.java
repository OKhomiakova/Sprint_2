import com.example.Cat;
import com.example.Feline;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundReturnsCorrectCatSound() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        Assert.assertEquals(expectedSound, actualSound);

    }

    @Test
    public void getFoodReturnsCorrectCatFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        List<String> expectedListOfFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualListOfFood = cat.getFood();

        Assert.assertEquals(expectedListOfFood, actualListOfFood);
    }
}
