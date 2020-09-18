// Jackson Miller
// COSC2103 Computer Science 2
// 2020-09-17
// Chapter 6 Assignemnt: Tax Table Ex. 6.15
// This assignment prints a tax-table for various tax brakets using a method
// $50,000 - $70,000 interval $100
// NOTE: Using 2009 rates from the texbook

package taxtable;

public class TaxTable {

    public static void main(String[] args) {

        System.out.print("Taxable\t\tSingle\t\tMarried\t\tMarried\t\tHead of\n" +
                        "Income\t\t\t\tJointly\t\tSeparate\thousehold\n");

        // Print a row for income from $50,000 to $70,000 by $100 steps
        for (int income = 50000; income <= 70000; income += 100) {
            System.out.printf("$%,d", income);

            // Loop through all filing statuses and print amount due
            for (int status = 0; status <= 3; status++) {
                long amount = Math.round(computeTax(status, income));
                System.out.printf("\t\t$%,d", amount);
            }
            System.out.println();
        }
    }

    public static double computeTax(int status, double taxableIncome) {
        /**
         * Calculate taxable income for any status in range $50,000 to $70,000 returns
         * the tax amount at that income level
         * 
         * Status reference:
         * 0    single filer
         * 1    married jointly or widow
         * 2    married separately
         * 3    head of household
         */

        double tax = 0;

        // Sanity check, exit on fail
        if(taxableIncome > 70000 || taxableIncome < 50000) { return tax;}

        // Use tax calulations only on the possible relavant ranges
        switch (status) {
            case 0:
                tax = 8350 * 0.10 +
                    (33950 - 8350) * 0.15 +
                    (taxableIncome - 33950) * 0.25;
                break;
            case 1:
                if(taxableIncome <= 67900) {
                    tax = 16700 * 0.10 +
                        (taxableIncome - 16700) * 0.15;
                }
                else {
                    tax = 16700 * 0.10 +
                        (67900 - 16700) * 0.15 +
                        (taxableIncome - 67900) * 0.25;
                }
                break;
            case 2:
                if(taxableIncome <= 68525) {
                    tax = 8350 * 0.10 +
                        (33950 - 8350) * 0.15 +
                        (taxableIncome - 33950) * 0.25;
                }
                else {
                    tax = 8350 * 0.10 +
                        (33950 - 8350) * 0.15 +
                        (68525 - 33950) * 0.25 +
                        (taxableIncome - 68525) * 0.28;
                }
                break;
            case 3:
                tax = 11950 * 0.10 +
                    (45500-11950) * 0.15 +
                    (taxableIncome - 45500) * 0.25;
                break;
            default:
                System.out.println("Error: invalid status");
                break;
        }

        return tax;
    }

}
