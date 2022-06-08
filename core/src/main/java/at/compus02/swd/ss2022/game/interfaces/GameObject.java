package at.compus02.swd.ss2022.game.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
    void act(float delta);
    GameObject setPosition(float x, float y);
    GameObject setRotation(float deg);
    void draw(SpriteBatch batch);
}
