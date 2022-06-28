package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameInput extends InputAdapter {

    public boolean hit;

    public GameInput() {
        hit = false;
    }

    public void input(Sprite sprite, float playerSpeed) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            hit = true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            sprite.translateX(-1f * playerSpeed);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            sprite.translateX(1f * playerSpeed);

        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            sprite.translateY(1f * playerSpeed);

        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            sprite.translateY(-1f * playerSpeed);

        }
    }


    public boolean isHit() {
        return hit;
    }
}
