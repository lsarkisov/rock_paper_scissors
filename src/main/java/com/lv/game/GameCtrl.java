package com.lv.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static com.lv.api.Constants.API_URL;

@RestController
@RequestMapping(API_URL)
public class GameCtrl {

    @Autowired
    private final GameRepository gameRepository;

    public GameCtrl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping("/selection")
    public Game userSelection(@RequestBody Game selection) {
        selection.setWin(
                selection.getRps().equals(
                        RockPaperScissors.values()[randomNumber()])
        );
        return gameRepository.save(selection);
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(3);
    }
}
