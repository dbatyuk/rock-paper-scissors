package com.dbatyuk.rps.model;

import java.io.Serializable;

public class RockPaperScissorsRound implements Serializable {

    private static final long serialVersionUID = 3543235341962866176L;

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
