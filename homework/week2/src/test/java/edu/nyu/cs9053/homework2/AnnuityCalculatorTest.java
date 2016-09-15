package edu.nyu.cs9053.homework2;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

/**
 * User: blangel
 * Date: 9/5/15
 * Time: 10:48 AM
 */
public class AnnuityCalculatorTest {

    @Test
    public void computeFutureValueOfAnnuityIn15Years() {
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();
        BigDecimal result = annuityCalculator.computeFutureValueOfAnnuityIn15Years(400000d, 3.5d);
        BigDecimal expected = new BigDecimal("7718272.3514400000");
        assertEquals(expected, result);
    }

    @Test
    public void computeFutureValueOfAnnuityIn30Years() {
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();
        BigDecimal result = annuityCalculator.computeFutureValueOfAnnuityIn30Years(400000d, 3.5d);
        BigDecimal expected = new BigDecimal("20649070.9108800000");
        assertEquals(expected, result);
    }

    @Test
    public void computeFutureValueOfAnnuity() {
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();
        BigDecimal result = annuityCalculator.computeFutureValueOfAnnuity(400000d, 3.5d, 20);
        BigDecimal expected = new BigDecimal("11311872.7253200000");
        assertEquals(expected, result);
    }

    @Test
    public void computeMonthlyCompoundedFutureValueOfAnnuityIn15Years() {
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();
        BigDecimal result = annuityCalculator.computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(400000d, 3.5d);
        BigDecimal expected = new BigDecimal("94514413.3829200000");
        assertEquals(expected, result);
    }

    @Test
    public void computeMonthlyCompoundedFutureValueOfAnnuityIn30Years() {
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();
        BigDecimal result = annuityCalculator.computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(400000d, 3.5d);
        BigDecimal expected = new BigDecimal("254165098.7184400000");
        assertEquals(expected, result);
    }

    @Test
    public void computeMonthlyCompoundedFutureValueOfAnnuity() {
        AnnuityCalculator annuityCalculator = new AnnuityCalculator();
        BigDecimal result = annuityCalculator.computeMonthlyCompoundedFutureValueOfAnnuity(400000d, 3.5d, 20);
        BigDecimal expected = new BigDecimal("138747708.2595600000");
        assertEquals(expected, result);
    }

}
