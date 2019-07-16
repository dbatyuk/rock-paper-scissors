package com.dbatyuk.rps.model;

public class RockPaperScissorsRound {

    private final RockPaperScissors userMove;
    private final RockPaperScissors computerMove;
    private final boolean computerWinner;

    public RockPaperScissorsRound(RockPaperScissors userMove, RockPaperScissors computerMove, boolean computerWinner) {
        this.userMove = userMove;
        this.computerMove = computerMove;
        this.computerWinner = computerWinner;
    }

    public RockPaperScissors getUserMove() {
        return userMove;
    }

    public RockPaperScissors getComputerMove() {
        return computerMove;
    }

    public boolean isComputerWinner() {
        return computerWinner;
    }
}
