package apps.kermisattractie;

import model.kermisattractie.Kermisattractie;

public class KermisattractieApp {

    Kermisattractie kermisattracties = new Kermisattractie();
    kermisattracties[0] = new Kermisattractie(10.00, "Achtbaan", 10);

    Kermisattractie achtbaan = new Kermisattractie(10.00, "Achtbaan", 10);
    Kermisattractie botsautos = new Kermisattractie(4.50, "Botsauto's", 20);
    Kermisattractie draaimolen = new Kermisattractie(3.00, "Draaimolen", 15);
    Kermisattractie glijbaan = new Kermisattractie(1.50, "Glijbaan", 40);
    Kermisattractie reuzenrad = new Kermisattractie(2.50, "Reuzenrad", 35);
    Kermisattractie schommelschip = new Kermisattractie(5.00, "Schommelschip", 20);
    Kermisattractie spookhuis = new Kermisattractie(5.50, "Spookhuis", 15);
    Kermisattractie springkussen = new Kermisattractie(1.00, "Botsauto's", 50);
    Kermisattractie wildwaterbaan = new Kermisattractie(6.50, "Wildwaterbaan", 5);
    Kermisattractie zweefmolen = new Kermisattractie(2.00, "Zweefmolen", 15);

    private static void perform() {
    }
}
