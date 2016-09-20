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
            return computeFutureValueOfAnnuity(annuityAmount,annualInterestRateInPercent,15);
        }
       
        public BigDecimal computeFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {
           
             return computeFutureValueOfAnnuity(annuityAmount,annualInterestRateInPercent,30);
        }

        public BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn15Years(double annuityAmount, double annualInterestRateInPercent) {
            
             return computeMonthlyCompoundedFutureValueOfAnnuity(annuityAmount,annualInterestRateInPercent,15);
        }

        public BigDecimal computeMonthlyCompoundedFutureValueOfAnnuityIn30Years(double annuityAmount, double annualInterestRateInPercent) {
             return computeMonthlyCompoundedFutureValueOfAnnuity(annuityAmount,annualInterestRateInPercent,30);
        }

        public  BigDecimal computeFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {
            BigDecimal annuity_Amount = new BigDecimal (Double.valueOf(annuityAmount));
            //convert the annualInterestRateInPercent to double .
            BigDecimal annual_Interest_RateInPercent = new BigDecimal(Double.valueOf(annualInterestRateInPercent));
            BigDecimal annual_Interest= annual_Interest_RateInPercent.divide(new BigDecimal(Double.valueOf(100d)),DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
            BigDecimal one = new BigDecimal (Double.valueOf(1d));
            //FVa = P * [ (((1 + r)^t) - 1) / r ]
            BigDecimal result = annuity_Amount.multiply((((annual_Interest.add(one)).pow(years)).subtract(one)).divide(annual_Interest,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE));
            return result;
        }

        public BigDecimal computeMonthlyCompoundedFutureValueOfAnnuity(double annuityAmount, double annualInterestRateInPercent, int years) {
            BigDecimal annuity_Amount = new BigDecimal (Double.valueOf(annuityAmount));
            //convert the annualInterestRateInPercent to double .
            BigDecimal annual_Interest_RateInPercent = new BigDecimal(Double.valueOf(annualInterestRateInPercent));
            BigDecimal annual_Interest= annual_Interest_RateInPercent.divide(new BigDecimal(Double.valueOf(100d)),DEFAULT_SCALE,DEFAULT_ROUNDING_MODE);
            BigDecimal one = new BigDecimal (Double.valueOf(1d));
            //the m in the formula is 12.
            BigDecimal month = new BigDecimal (Double.valueOf(12d));
            //FVac = P * [ (((1 + (r / m))^(m * t)) - 1) / (r / m) ]
            BigDecimal result = annuity_Amount.multiply(((((annual_Interest.divide(month,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE)).add(one)).pow(years*12)).subtract(one)).divide((annual_Interest.divide(month,DEFAULT_SCALE,DEFAULT_ROUNDING_MODE)),DEFAULT_SCALE,DEFAULT_ROUNDING_MODE));
            return result;
        }

    }
