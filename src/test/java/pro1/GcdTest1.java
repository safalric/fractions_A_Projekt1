package pro1;

import org.junit.jupiter.api.Assertions;

class GcdTest1
{
    @org.junit.jupiter.api.Test
    void test_20_50()
    {
        Assertions.assertEquals(10, NumericUtils.gcd(20, 50));
    }

    @org.junit.jupiter.api.Test
    void test_20_1000()
    {
        Assertions.assertEquals(20, NumericUtils.gcd(20, 1000));
    }

    @org.junit.jupiter.api.Test
    void test_primes()
    {
        Assertions.assertEquals(1, NumericUtils.gcd(7919, 7907));
    }

    @org.junit.jupiter.api.Test
    void test_equal_numbers()
    {
        Assertions.assertEquals(15, NumericUtils.gcd(15, 15));
    }

    @org.junit.jupiter.api.Test
    void test_with_zero()
    {
        Assertions.assertEquals(14, NumericUtils.gcd(0, 14));
    }

    @org.junit.jupiter.api.Test
    void test_negative_input()
    {
        Assertions.assertEquals(6, NumericUtils.gcd(-18, 24));
    }
}