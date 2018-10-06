package com.lv.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("User selected: " + selection.getRps());
        return gameRepository.save(selection);
    }
}
