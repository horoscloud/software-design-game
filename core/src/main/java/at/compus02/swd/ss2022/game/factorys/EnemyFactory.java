package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.gameobjects.Enemy;

public class EnemyFactory {

    Enemy enemy;

    public EnemyFactory() {
    }

    public Enemy create(String name, float posX, float posY){
        switch (name){
            case "zombie":
                enemy = new Enemy("zombie");
                enemy.setPosition(posX,posY);
                return enemy;
            case "fireball":
                enemy = new Enemy("fireball");
                enemy.setPosition(posX,posY);
                return enemy;
        }
        return null;
    }
}
