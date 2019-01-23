package model.kermisattractie;

public class Kermisattractie {
    private Double price;
    private String name;
    private Integer rounds;
    private Integer roundsBeforeInspection;

    public Kermisattractie(Double price, String name, Integer roundsBeforeInspection) {
        this.price = price;
        this.name = name;
        this.roundsBeforeInspection = roundsBeforeInspection;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public Integer getRoundsBeforeInspection() {
        return roundsBeforeInspection;
    }

    public void setRoundsBeforeInspection(Integer roundsBeforeInspection) {
        this.roundsBeforeInspection = roundsBeforeInspection;
    }
}
