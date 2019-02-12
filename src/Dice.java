public class Dice {
    public static void main(String[] args) {
        int totalSum = 0;
        for (int i = 1; i <= 3; i++) {
            totalSum += roll();
        }
        System.out.println("Total sum of the dices is: " + totalSum);
    }

    private static int roll() {
        int randomNumber = (int) ((Math.random() * 6) + 1);
        System.out.println(randomNumber);
        return randomNumber;
    }
}
