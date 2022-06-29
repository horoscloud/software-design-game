package at.compus02.swd.ss2022.game.interfaces;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {
    void act(float delta);
    void act(float delta, float x, float y);
    GameObject setPosition(float x, float y);
    GameObject setRotation(float deg);
    void draw(SpriteBatch batch);
    float getX();
    float getY();
    float getWidth();
    float getHeight();
    Sprite getSprite();
    int getHealth();
    void setHealth(int health);
}
