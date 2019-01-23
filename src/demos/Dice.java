package demos;

public class Dice {
    public static void main(String[] args) {
        int totalSum = 0;
        for (int i = 1; i <= 3; i++) {
            totalSum += roll();
        }
        System.out.println("Total sum of the dices is: " + totalSum);
    }

    private static int roll() {
        int range = (6 - 1) + 1; // (max - min) + min
        int randomNumber = (int) ((Math.random() * range) + 1);
        System.out.println(randomNumber);
        return randomNumber;
    }
}
