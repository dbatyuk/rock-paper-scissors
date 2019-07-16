package com.dbatyuk.rps.rest;

import com.dbatyuk.rps.model.RockPaperScissors;
import com.dbatyuk.rps.model.RockPaperScissorsGame;
import com.dbatyuk.rps.model.RockPaperScissorsRound;
import com.dbatyuk.rps.service.RockPaperScissorsGameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/rpc/games")
public class RockPaperScissorsController {

    private final RockPaperScissorsGameService rockPaperScissorsGameService;

    public RockPaperScissorsController(RockPaperScissorsGameService rockPaperScissorsGameService) {
        this.rockPaperScissorsGameService = rockPaperScissorsGameService;
    }

    @GetMapping("/start")
    public RockPaperScissorsGame startGame() {
        return rockPaperScissorsGameService.start();
    }

    @GetMapping("/{gameId}/play/{move}")
    public RockPaperScissorsRound play(@PathVariable UUID gameId, @PathVariable RockPaperScissors move) {
        return rockPaperScissorsGameService.play(gameId, move);
    }

    @GetMapping("/{gameId}/end")
    public RockPaperScissorsGame endGame(@PathVariable UUID gameId) {
        return rockPaperScissorsGameService.end(gameId);
    }
}
