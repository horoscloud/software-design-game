package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.interfaces.PositionObserver;

public class PlayerPositionObserver implements PositionObserver {

    @Override
    public void update(float x, float y) {
        System.out.println("Player-X:" + x + " Player-Y:" + y);
    }
}
