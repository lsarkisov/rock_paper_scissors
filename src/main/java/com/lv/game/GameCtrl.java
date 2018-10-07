package com.lv.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

import static com.lv.api.Constants.API_URL;
import static com.lv.api.Constants.API_ORIGIN;

@RestController
@RequestMapping(API_URL)
public class GameCtrl {

    @Autowired
    private final GameRepository gameRepository;

    public GameCtrl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @CrossOrigin(origins = API_ORIGIN)
    @PostMapping("/shape")
    public Game userSelection(@RequestBody Game selection) {
        RockPaperScissors random = RockPaperScissors.values()[randomNumber()];
        selection.setComputer(random);
        selection.setWin(random.equals(selection.getUser()));
        System.out.println("Comp selection: " +
                selection.getUser() + ", " + selection.getComputer()
                + ", " + selection.getWin()
        );

        return gameRepository.save(selection);
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(RockPaperScissors.values().length);
    }
}
