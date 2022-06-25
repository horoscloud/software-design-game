package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.enemies.Fireball;
import at.compus02.swd.ss2022.game.enemies.Zombie;
import at.compus02.swd.ss2022.game.interfaces.GameObject;

public class EnemyFactory {


    public EnemyFactory() {
    }

    public GameObject create(String name) {
        switch (name) {
            case "zombie":
                return new Zombie();
            case "fireball":
                return new Fireball();
        }
        return null;
    }
}
