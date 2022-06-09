package at.compus02.swd.ss2022.game.interfaces;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface GameObserver<T> {
    void getPosition(T object);
    void getRotation(T object);
}
