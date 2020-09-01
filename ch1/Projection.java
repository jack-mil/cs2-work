// Jackson Miller
// COSC 2103 Computer Science 2
// 2020-08-17
// 1.11 List the population projections for next 5 years


public class Projection {
    public static void main(String[] args) {

        final double currentPopulation = 312032486;
        final double secondsInYear = 365 * 24 * 60 * 60; //31,536,000 s

        // Rate constants
        final double deathRate = 1.0 / 13; //per second
        final double birthRate = 1.0 / 7; // per second
        final double immigRate = 1.0 / 45; // per second

        final double totalRate = birthRate + immigRate - deathRate;

        System.out.println("Population Rate increase per second " + totalRate);

        double year1 = currentPopulation + totalRate * secondsInYear;
        double year2 = currentPopulation + totalRate * 2 * secondsInYear;
        double year3 = currentPopulation + totalRate * 3 * secondsInYear;
        double year4 = currentPopulation + totalRate * 4 * secondsInYear;
        double year5 = currentPopulation + totalRate * 5 * secondsInYear;

        System.out.println("Current Population: " + currentPopulation);
        System.out.println();
        System.out.println("Next year Population: " + year1);
        System.out.println("Year 2 Population: " + year2);
        System.out.println("Year 3 Population: " + year3);
        System.out.println("Year 4 Population: " + year4);
        System.out.println("Year 5 Population: " + year5);
        
    }
}