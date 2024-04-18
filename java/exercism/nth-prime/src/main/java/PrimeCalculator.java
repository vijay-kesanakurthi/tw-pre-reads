class PrimeCalculator {

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 2, count = 0;; i++) {
            if (isPrime(i)) {
                count++;
                if (count == nth) {
                    return i;
                }
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
