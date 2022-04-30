import com.example.Alex;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test()
    public void getFriendsReturnsCorrectListOfAlexFriends() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedListOfFriends = Arrays.asList("зебра Марти", "бегемотиха Глория", "жираф Мелман");

        List<String> actualListOfFriends = alex.getFriends();

        Assert.assertEquals(expectedListOfFriends, actualListOfFriends);
    }

    @Test
    public void getPlaceOfLivingReturnsCorrectPlaceForAlex() throws Exception {
        Alex alex = new Alex(feline);
        String expectedPlaceOfLiving = "Нью-Йоркский зоопарк";

        String actualPlaceOfLiving = alex.getPlaceOfLiving();

        Assert.assertEquals(expectedPlaceOfLiving, actualPlaceOfLiving);
    }

    @Test()
    public void getKittensReturnsCorrectNumOfLionKittens() throws Exception {
        Alex alex = new Alex(feline);
        int expectedNumberOfKittens = 0;

        int actualNumberOfKittens = alex.getKittens();

        Assert.assertEquals(expectedNumberOfKittens, actualNumberOfKittens);
    }

    @Test
    public void doesHaveManeReturnsTrueForAlex() throws Exception {
        // Arrange
        Alex alex = new Alex(feline);
        boolean expectedValue = true;
        // Act
        boolean actualValue = alex.doesHaveMane();
        // Assert
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test()
    public void getFoodReturnsCorrectAlexFood() throws Exception {
        Alex alex = new Alex(feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedListOfFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualListOfFood = alex.getFood();

        Assert.assertEquals(expectedListOfFood, actualListOfFood);
    }

}
