package com.dbatyuk.rps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RockPaperScissorsGame implements Serializable {

    private static final long serialVersionUID = -8071927031986336080L;

    private final UUID id = UUID.randomUUID();
    private final List<RockPaperScissorsRound> rounds = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public List<RockPaperScissorsRound> getRounds() {
        return rounds;
    }

    public void addRound(RockPaperScissorsRound round) {
        rounds.add(round);
    }
}
