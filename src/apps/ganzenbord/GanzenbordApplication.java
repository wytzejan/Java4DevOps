package apps.ganzenbord;

import model.ganzenbord.Player;

import java.util.*;

public class GanzenbordApplication {
    public static void main(String[] args) {

        System.out.println("Welkom bij het Ganzenbord!");
        System.out.println("--------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Met hoeveel personen wil je het spel spelen? (antwoordmogelijkheden: 1 en 2)");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("Je speelt het spel met " + numberOfPlayers + " speler(s).");

        Player[] players = new Player[numberOfPlayers];

        for (int i = 0; i < players.length; i++) {
            int playerNumber = i + 1;
            scanner = new Scanner(System.in);
            System.out.println("Naam speler " + playerNumber + "?");
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        System.out.println("--------------------------");
        System.out.println("De volgende speler(s) doe(n)(t) mee:");
        for (Player player : players) {
            System.out.println(player.getName());
        }
        System.out.println("--------------------------");

        /* start game */

        System.out.println("Het spel begint!");
        System.out.println("--------------------------");

        /* variables */
        boolean endGame = false;
        int brugNumber = 6;
        int herbergNumber = 19;
        int doolhofNumber = 42;
        int inJail = 52;
        int doodNumber = 58;
        int finish = 63;
        List<Integer> backToStart = Arrays.asList(25, 45);
        List<Integer> bonusPlaces = Arrays.asList(10, 20, 30, 40, 50, 60);

        do {
            for (Player player : players) {
                if (!player.isActivePlayer()) {
                    /* logic for skipTurn */
                    if (player.isSkipTurn() && player.getSkipNumberOfTurns() > 0) {
                        int tempSkipNumberOfTurns = player.getSkipNumberOfTurns();
                        player.setSkipNumberOfTurns(tempSkipNumberOfTurns - 1);
                        if (player.getSkipNumberOfTurns() == 0) {
                            player.setSkipTurn(false);
                        }
                    } else {

                        System.out.println(player.getName() + " is aan de beurt. Gooi je dobbelsteen (g).");
                        do {
                            scanner = new Scanner(System.in);
                            String text = scanner.nextLine();
                            if (text.equals("g")) {
                                int thrownNumber = throwDice();
                                int currentPlace = player.getCurrentPlace();
                                player.setCurrentPlace(currentPlace += thrownNumber);

                                /* special place: 10, 20, 30, 40, 50 en 60 houdt in dat je het geworpen aantal nog een keer loopt. */
                                if (bonusPlaces.contains(player.getCurrentPlace())) {
                                    System.out.println("Je hebt " + thrownNumber + " gegooid, je staat op plaats " + player.getCurrentPlace() + ".");
                                    int tempCurrentPlace = player.getCurrentPlace();
                                    player.setCurrentPlace(tempCurrentPlace += thrownNumber);
                                    System.out.println("Yeah! Dit is een bonusplaats! Je bent nog eens " + thrownNumber + " vooruit gegaan en staat nu op " + player.getCurrentPlace() + ".");
                                    endGame = currentPlaceAboveFinish(endGame, finish, player, thrownNumber);

                                }

                                /* special place: 25 en 45 is terug naar start. */
                                else if (backToStart.contains(player.getCurrentPlace())) {
                                    System.out.println("Helaas! Je staat op " + player.getCurrentPlace() + ". Je moet terug naar start.");
                                    player.setCurrentPlace(0);
                                }

                                /* special place: 52, gevangenis, drie beurten overslaan */
                                else if (player.getCurrentPlace() == inJail) {
                                    System.out.println("Helaas! Je moet 3 beurten overslaan.");
                                    player.setSkipTurn(true);
                                    player.setSkipNumberOfTurns(3);
                                } else if (player.getCurrentPlace() == brugNumber) {
                                    System.out.println("Yeah! De brug. Je gaat verder naar 12!");
                                    player.setCurrentPlace(12);
                                } else if (player.getCurrentPlace() == doolhofNumber) {
                                    System.out.println("Helaas! Je bent in het doolhof. Je moet terug naar 39.");
                                    player.setCurrentPlace(39);
                                } else if (player.getCurrentPlace() == doodNumber) {
                                    System.out.println("Helaas! Je bent dood. Je gaat terug naar start.");
                                    player.setCurrentPlace(0);
                                }
                                /* 19, herberg, Een beurt overslaan */
                                else if (player.getCurrentPlace() == herbergNumber) {
                                    System.out.println("Helaas! Je moet een beurt overslaan.");
                                    player.setSkipTurn(true);
                                    player.setSkipNumberOfTurns(1);
                                }

                                /* finish */
                                else if (player.getCurrentPlace() >= finish) {
                                    currentPlaceAboveFinish(endGame, finish, player, thrownNumber);
                                } else {
                                    System.out.println("Je hebt " + thrownNumber + " gegooid, je staat op plaats " + player.getCurrentPlace() + ", niks aan de hand.");
                                }
                            }
                            player.setActivePlayer(false);
                            System.out.println("--------------------------");
                            System.out.println("Actuele plaatsen:");
                            for (Player element : players) {
                                System.out.println(element.getName() + ": " + element.getCurrentPlace());
                            }
                            System.out.println("--------------------------");
                        } while (player.isActivePlayer() && !endGame);
                    }
                }
            }
        } while (!endGame);
    }

    private static boolean currentPlaceAboveFinish(boolean endGame, int finish, Player player, int thrownNumber) {
        if (player.getCurrentPlace() >= finish) {
            if (player.getCurrentPlace() == finish) {
                System.out.println("Yeah! " + player.getName() + " heeft gewonnen!");
                player.setWinner(true);
                endGame = true;
            } else {
                System.out.println("Je hebt " + thrownNumber + " gegooid.");
                int tooManyThrownEyes = player.getCurrentPlace() - finish;
                player.setCurrentPlace(finish - tooManyThrownEyes);
                System.out.println("Helaas! Dat is te ver. Je moet precies op " + finish + " eindigen om te winnen. Je staat nu weer op " + player.getCurrentPlace() + ".");
                System.out.println("Gooi je dobbelsteen (g).");
            }
        }
        return endGame;
    }

    private static int throwDice() {
        Random random = new Random();
        return random.nextInt(6 - 1) + 1;
    }
}
