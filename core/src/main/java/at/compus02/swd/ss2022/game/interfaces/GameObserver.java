package at.compus02.swd.ss2022.game.interfaces;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface GameObserver {
    void outputPosition(float x, float y);
    void outputRotation(float x, float y);
}
