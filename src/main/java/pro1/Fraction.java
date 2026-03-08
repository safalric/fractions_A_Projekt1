package pro1;

public class Fraction {
    private long n;
    private long d;

    public Fraction(long n, long d) {
        if (d == 0) {
            throw new IllegalArgumentException("nesmí býý nula");
        }

        if (n == 0) {
            this.n = 0;
            this.d = 1;
            return;
        }

        long gcd = NumericUtils.gcd(n, d);
        long reducedN = n / gcd;
        long reducedD = d / gcd;

        if (reducedD < 0) {
            reducedN = -reducedN;
            reducedD = -reducedD;
        }

        this.n = reducedN;
        this.d = reducedD;
    }

    public Fraction add(Fraction other) {
        long resultN = this.n * other.d + other.n * this.d;
        long resultD = this.d * other.d;
        return new Fraction(resultN, resultD);
    }

    @Override
    public String toString() {
        return n + " / " + d;
    }

    public static Fraction parse(String s) {
        String[] parts = s.split("\\+");
        Fraction result = new Fraction(0, 1);

        for (String part : parts) {
            String trimmedPart = part.trim();
            Fraction parsedPart;

            if (trimmedPart.contains("%")) {
                long value = Long.parseLong(trimmedPart.replace("%", "").trim());
                parsedPart = new Fraction(value, 100);
            } else {
                String[] nd = trimmedPart.split("/");
                long numerator = Long.parseLong(nd[0].trim());
                long denominator = Long.parseLong(nd[1].trim());
                parsedPart = new Fraction(numerator, denominator);
            }

            result = result.add(parsedPart);
        }

        return result;
    }
}
