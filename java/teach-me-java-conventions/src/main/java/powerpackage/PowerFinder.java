package powerpackage;

public class PowerFinder {
    public static int calculate(int base, int exponent) {
        int result = 1;
        for (int iterator = 0; iterator <exponent; iterator++) {
            result *= base;
        }
        return result;
    }

}
