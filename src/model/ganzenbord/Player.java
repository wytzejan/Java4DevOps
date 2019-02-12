package model.ganzenbord;

public class Player {
    private String name;
    private int currentPlace;
    private boolean activePlayer;
    private boolean skipTurn;
    private int skipNumberOfTurns;
    private boolean inPut;
    private boolean isWinner;

    public Player(String name) {
        this.name = name;
    }

    public int getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(int currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(boolean activePlayer) {
        this.activePlayer = activePlayer;
    }

    public boolean isSkipTurn() {
        return skipTurn;
    }

    public void setSkipTurn(boolean skipTurn) {
        this.skipTurn = skipTurn;
    }

    public int getSkipNumberOfTurns() {
        return skipNumberOfTurns;
    }

    public void setSkipNumberOfTurns(int skipNumberOfTurns) {
        this.skipNumberOfTurns = skipNumberOfTurns;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isInPut() {
        return inPut;
    }

    public void setInPut(boolean inPut) {
        this.inPut = inPut;
    }
}
