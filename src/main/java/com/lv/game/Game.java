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
    private RockPaperScissors user;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private RockPaperScissors computer;

    private Boolean win;

    public RockPaperScissors getUser() {
        return user;
    }

    public void setUser(RockPaperScissors user) {
        this.user = user;
    }

    public RockPaperScissors getComputer() {
        return computer;
    }

    public void setComputer(RockPaperScissors computer) {
        this.computer = computer;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }
}
