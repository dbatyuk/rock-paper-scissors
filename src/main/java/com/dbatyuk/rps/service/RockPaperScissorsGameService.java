package com.dbatyuk.rps.service;

import com.dbatyuk.rps.model.RockPaperScissors;
import com.dbatyuk.rps.model.RockPaperScissorsGame;
import com.dbatyuk.rps.model.RockPaperScissorsRound;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.dbatyuk.rps.model.RockPaperScissors.*;

@Service
public class RockPaperScissorsGameService {

    private final Map<UUID, RockPaperScissorsGame> games = new HashMap<>();
    private static final Map<RockPaperScissors, RockPaperScissors> POWER = Map.of(
            rock, paper,
            paper, scissors,
            scissors, rock
    );

    public RockPaperScissorsGame start() {
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        games.put(game.getId(), game);
        return game;
    }

    public RockPaperScissorsRound play(UUID gameId, RockPaperScissors userMove) {
        RockPaperScissorsGame game = getGame(gameId);

        RockPaperScissors computerMove = makeComputerMove(game);
        boolean draw = isDraw(userMove, computerMove);
        boolean computerWinner = isComputerWinner(userMove, computerMove);
        RockPaperScissorsRound round = new RockPaperScissorsRound(userMove, computerMove, computerWinner, draw);

        game.addRound(round);
        games.put(gameId, game);

        return round;
    }

    public RockPaperScissorsGame end(UUID gameId) {
        RockPaperScissorsGame game = getGame(gameId);

        // TODO store statistics
        games.remove(gameId);

        return game;
    }

    private RockPaperScissorsGame getGame(UUID gameId) {
        return Optional.ofNullable(games.get(gameId))
                .orElseThrow(() -> new IllegalArgumentException("game " + gameId + " not found"));
    }

    private RockPaperScissors makeComputerMove(RockPaperScissorsGame game) {
        return getLastRound(game)
                .map(round -> {
                    if (!round.isComputerWinner()) {
                        return getMorePowerfulMove(round.getUserMove());
                    }

                    return round.getUserMove();
                }).orElse(getRandom());
    }

    private RockPaperScissors getRandom() {
        return RockPaperScissors.fromInt(new Random().nextInt(3));
    }

    private Optional<RockPaperScissorsRound> getLastRound(RockPaperScissorsGame game) {
        if (game.getRounds().isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(game.getRounds().get(game.getRounds().size() - 1));
    }

    private boolean isDraw(RockPaperScissors userMove, RockPaperScissors computerMove){
        return userMove.equals(computerMove);
    }

    private boolean isComputerWinner(RockPaperScissors userMove, RockPaperScissors computerMove) {
        return !userMove.equals(computerMove) && !isMorePowerful(userMove, computerMove);
    }

    private boolean isMorePowerful(RockPaperScissors move1, RockPaperScissors move2) {
        return !POWER.get(move1).equals(move2);
    }

    private RockPaperScissors getMorePowerfulMove(RockPaperScissors move) {
        // TODO refactor
        return POWER.get(move);
    }
}
