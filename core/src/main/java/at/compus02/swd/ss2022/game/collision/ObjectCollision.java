package at.compus02.swd.ss2022.game.collision;

import at.compus02.swd.ss2022.game.interfaces.Collision;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ObjectCollision implements Collision<Sprite> {

    private static int hitOffset = 20;
    private static int detectionOffset = 15;


    public ObjectCollision() {
    }

    public boolean getCollisionDetection(Sprite sp1, Sprite sp2){

        if(
                   sp1.getX() < sp2.getX() + sp2.getWidth() - detectionOffset
                && sp1.getX() + sp1.getWidth() - detectionOffset> sp2.getX()
                && sp1.getY() < sp2.getY() + sp2.getHeight() - detectionOffset
                && sp1.getY() + sp1.getHeight() - detectionOffset > sp2.getY()

        ) {
            return true;
        }else
            return false;

    }

    public boolean getHitCollisionDetection(Sprite sp1, Sprite sp2){

        if(
                           sp1.getX() < sp2.getX() + sp2.getWidth() + hitOffset
                        && sp1.getX() + sp1.getWidth() + hitOffset > sp2.getX()
                        && sp1.getY() < sp2.getY() + sp2.getHeight() + hitOffset
                        && sp1.getY() + sp1.getHeight() + hitOffset > sp2.getY()

        ) {
            return true;
        }else
            return false;

    }

}
