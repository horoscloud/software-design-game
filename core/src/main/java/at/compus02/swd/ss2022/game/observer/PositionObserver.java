package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.interfaces.Observer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class PositionObserver implements Observer {


    public PositionObserver() {

    }

    public void output(float x,float y){
        System.out.println(x);
        System.out.println(y);
    }

}
