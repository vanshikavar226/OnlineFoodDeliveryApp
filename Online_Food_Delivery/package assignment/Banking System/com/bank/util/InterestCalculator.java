package com.bank.util;
import static java.lang.Math.*;

public class InterestCalculator {

    public static double simpleInterest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    public static double compoundInterest(double p, double r, double t) {
        return p * pow((1 + r / 100), t) - p;
    }
}
