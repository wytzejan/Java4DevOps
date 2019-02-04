package apps.kermisattractie;

import model.kermisattractie.Kermisattractie;

import java.text.DecimalFormat;

public class KermisattractieApp {
    static Kermisattractie[] kermisattracties = {
            new Kermisattractie(8.00, "Achtbaan", 2),
            new Kermisattractie(4.50, "Botsauto's", 20),
            new Kermisattractie(3.00, "Draaimolen", 15),
            new Kermisattractie(1.50, "Glijbaan", 40),
            new Kermisattractie(2.50, "Reuzenrad", 35),
            new Kermisattractie(5.00, "Schommelschip", 20),
            new Kermisattractie(5.50, "Spookhuis", 15),
            new Kermisattractie(1.00, "Botsauto's", 50),
            new Kermisattractie(6.50, "Wildwaterbaan", 5),
            new Kermisattractie(2.00, "Zweefmolen", 15)
    };

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.00");
        Double omzet = 0.00;
        Double totaleOmzet = 0.00;
        for (Kermisattractie kermisattractie : kermisattracties) {
            System.out.println(kermisattractie.getName() + " is running...!");
            totaleOmzet += perform(kermisattractie, omzet);
            System.out.println(" ");
        }
        System.out.println("De totale omzet is €" + df.format(totaleOmzet));
        Double totalTax = totaleOmzet * 0.21;
        System.out.println("Total tax is €" + df.format(totalTax));
    }

    private static double perform(Kermisattractie kermisattractie, Double omzet) {
        for (int i = 1; i <= 3; i++) {
            kermisattractie.setRounds(i);
            omzet += kermisattractie.getPrice();
            System.out.println("Round " + i);
            if (kermisattractie.getRounds().equals(kermisattractie.getRoundsBeforeInspection())) {
                System.out.println("WARNING! "+ kermisattractie.getName() + " must be inspected! No further rounds can be made.");
                break;
            }
        }
        System.out.println("Totale omzet: " + omzet);
        return omzet;
    }
}
