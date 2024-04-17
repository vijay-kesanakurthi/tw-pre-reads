import org.junit.Test;
import powerpackage.PowerFinder;

public class PowerFinderTest {
    @Test
    public void oneRaisedToOneIsOne() {
        assert PowerFinder.calculate(1,1) == 1;
    }

    @Test
    public void twoRaisedToOneIsTwo() {
        assert PowerFinder.calculate(2,1) == 2;
    }

    @Test
    public void twoRaisedToTwoIsFour() {
        assert PowerFinder.calculate(2, 2) == 4;
    }

    @Test
    public void threeRaisedToTwoIs9() {
        assert PowerFinder.calculate(3, 2) == 3*3;
    }
}
