public class PrimeNumberChecker {
    private final int number;

    public PrimeNumberChecker(int number) {
        this.number = number;
    }

    public boolean check() {
        if (number < 2) {
            return false;
        }
        var range = number / 2;
        for (int i = 2; i <= range; i++) {
            if (isDivisible(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDivisible(int i) {
        return number % i == 0;
    }
}
