public class Mortgage {

    private static final int MONTH_IN_YEAR = 12;

    public static void main(String[] args) {
//        float mortgage = 1_000_000;
//        float precent = 19;
//        float precentPerMonth = precent / MONTH_IN_YEAR;
//        float realPrecentPerMonth = precentPerMonth / 100 + 1;
//        int mortgageMonths = 30 * MONTH_IN_YEAR;
//        float payment = mortgage * (realPrecentPerMonth + (realPrecentPerMonth / (realPrecentPerMonth / 1) * (mortgageMonths - 1)));
        System.out.println(annuetetKoef(15d/12d/100d, 5*12));
        System.out.println(annuetetPayment(2_000_000, 15d/12d/100d, 5*12));
    }

    /*
        param m - месячная процентная ставка(годовая/12)
        param s - число месяцев
     */
    private static double annuetetKoef(double m, int s) {
        return (m*Math.pow(1+m, s)) / (Math.pow(1+m, s) - 1);
    }

    private static double annuetetPayment(int sum, double m, int s) {
        return sum * annuetetKoef(m, s);
    }

    private static double 
}
