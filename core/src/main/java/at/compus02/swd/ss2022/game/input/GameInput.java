package at.compus02.swd.ss2022.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameInput extends InputAdapter {

    private float xDir;
    private float yDir;

    public GameInput() {

    }

    public void input(Sprite player, float playerSpeed) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(-1f * playerSpeed);
            xDir = -1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(1f * playerSpeed);
            xDir = 1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.translateY(1f*playerSpeed);
            yDir = 1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.translateY(-1f*playerSpeed);
            yDir = -1;
        }
    }

    public float getxDir() {
        return xDir;
    }

    public float getyDir() {
        return yDir;
    }
}
