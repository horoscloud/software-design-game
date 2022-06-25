package at.compus02.swd.ss2022.game.collision;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Collision {


    public Collision() {
    }

    public boolean getCollisionDetection(Sprite sp1, Sprite sp2){

        if(sp1.getX() < sp2.getX() + sp2.getWidth()
                && sp1.getX() + sp1.getWidth() > sp2.getX()
                && sp1.getY() < sp2.getY() + sp2.getHeight()
                && sp1.getY() + sp1.getHeight() > sp2.getHeight()) {

            return true;
        }else
            return false;

    }

}
