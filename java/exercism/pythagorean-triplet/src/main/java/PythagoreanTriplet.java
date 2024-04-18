import java.util.*;

public class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return String.format("(%d, %d, %d)", a, b, c);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof PythagoreanTriplet) {
            PythagoreanTriplet pt = (PythagoreanTriplet) o;
            return a == pt.a && b == pt.b && c == pt.c;
        } else {
            return false;
        }
    }

    public static TripletsList makeTripletsList() {
        return new TripletsList();
    }

    public static class TripletsList {
        private int sum;
        private Integer maxFactor = null;

        private static final double PERIMETER_RATIO_LIMIT = 1 + 1 + Math.sqrt(2);

        public TripletsList thatSumTo(int sum) {
            this.sum = sum;
            if (maxFactor == null) {
                maxFactor = sum;
            }
            return this;
        }

        public TripletsList withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }

        public List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            for (int a = 1; a <= Math.floor(sum / PERIMETER_RATIO_LIMIT); a++) {
                int numerator = a * a + (int) Math.pow(sum - a, 2);
                int denominator = 2 * (sum - a);
                if (numerator % denominator == 0) {
                    int c = numerator / denominator;
                    if (c <= maxFactor) {
                        int b = sum - a - c;
                        triplets.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            return triplets;
        }
    }
}