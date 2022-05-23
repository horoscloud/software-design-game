package at.compus02.swd.ss2022.game.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
    void act(float delta);
    void setPosition(float x, float y);
    void setRotation(float deg);
    void draw(SpriteBatch batch);
}
