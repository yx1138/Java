package edu.nyu.cs9053.homework2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: blangel
 * Date: 9/5/15
 * Time: 10:24 AM
 *
 * Hint, to compute the future value of an annuity
 * FVa = P * [ (((1 + r)^t) - 1) / r ]
 *  where P is the payment amount
 *  where r is the interest rate
 *  and where t is the time in years (e.g., 6 months t=0.5)
 *
 * Hint, to compute the future value of an annuity with compounding
 * FVac = P * [ (((1 + (r / m))^(m * t)) - 1) / (r / m) ]
 *  where P is the payment amount
 *  where r is the interest rate
 *  where m is the number of compounding periods in a year (e.g., annually m=1, semiannually m=2, quarterly m=4, monthly m=12)
 *  and where t is the time in years (e.g., 6 months t=0.5)
 */
public class AnnuityCalculator {

    /**
     * Use this scale when doing BigDecimal division.
     */
    private static final int DEFAULT_SCALE = 10;

    /**
     * Use this rounding mode when doing BigDecimal division.
     */
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

    public BigDecimal computeFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {

    }

    public BigDecimal computeFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {

    }

    public BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {

    }

    public BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {

    }

    public BigDecimal computeFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {

    }

    public BigDecimal computeMonthlyCompoundedFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {

    }

}
