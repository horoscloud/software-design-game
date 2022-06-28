package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.interfaces.PositionObserver;

public class EnemyPositionObserver implements PositionObserver {
    @Override
    public void update(float x, float y) {
        System.out.println("Enemy-X:" + x + " Enemy-Y:" + y);
    }
}
