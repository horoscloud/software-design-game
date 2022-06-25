package at.compus02.swd.ss2022.game.enemies;

import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Fireball implements GameObject {

    private Texture texture;
    private Sprite sprite;

  private int counter;
  private int direction;

    public Fireball() {
        texture = new Texture("enemy/fireball.png");
        sprite = new Sprite(this.texture);
        sprite.setSize(32,32);
        sprite.setCenter(16,48);
        direction = 1;
        counter = -600;
    }

    public float getX(){return sprite.getX();}
    public float getY(){return sprite.getY();}

    @Override
    public float getWidth() {
       return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    @Override
    public Sprite getSprite() {
        return this.sprite;
    }


    @Override
    public void act(float delta) {

        /*
        delta = (delta % 1200) - 600;


        if(delta > 600) {
            setPosition(delta, getY());
        }
        if(delta < 600) {
            setPosition(-delta, getY());
        }

*/

        System.out.println(delta);

        delta = (delta % 2400) - 600;

        if (delta>0&&delta<600)
            direction=1;

        if (delta>600&&delta<1200)
            direction= -1;

        if (direction ==1)
            setPosition(delta,getY());

        if (direction==-1)
            setPosition(-delta,getY());

        /*if(direction == 1) {
            setPosition(delta, getY());
            counter++;
            if(counter == 599){
                direction = -1;
            }
        }

        if(direction == -1) {
            setPosition(-delta, getY());
            counter--;
            if(counter == -599){
                direction = 1;
            }
        }

*/

        /*
        delta = (delta % 1200) - 600;
        if(direction == 1 || direction == 0){

           if(delta > 500){
               direction = -1;
           }
            setPosition(delta, getY());
        }else if(direction == -1){

            if(delta < -500){
                direction = 1;
            }
            setPosition(delta, getY());
        }
*/

    }

    @Override
    public GameObject setPosition(float x, float y) {
        sprite.setPosition(x,y);
        return this;
    }

    @Override
    public GameObject setRotation(float deg) {
        sprite.setRotation(deg);
        return this;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
