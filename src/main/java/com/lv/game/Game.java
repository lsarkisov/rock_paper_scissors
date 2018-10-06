package com.lv.game;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private RockPaperScissors rps;

    private Boolean win;

    public RockPaperScissors getRps() {
        return rps;
    }

    public void setRps(RockPaperScissors rps) {
        this.rps = rps;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }
}
