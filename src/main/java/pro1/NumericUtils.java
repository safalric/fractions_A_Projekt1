package pro1;

public class NumericUtils
{
    // Eukleidův algoritmus, výsledek je vždy >= 0.
    public static long gcd(long a, long b)
    {
        long p = Math.abs(a);
        long q = Math.abs(b);

        if (p == 0) return q;
        if (q == 0) return p;

        while (q != 0) {
            long r = p % q;
            p = q;
            q = r;
        }
        return p;
    }
}
