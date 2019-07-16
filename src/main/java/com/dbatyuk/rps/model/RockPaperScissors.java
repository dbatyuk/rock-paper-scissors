package com.dbatyuk.rps.model;

public enum RockPaperScissors {
    rock, paper, scissors;

    public static RockPaperScissors fromInt(int i){
        return values()[i];
    }
}
