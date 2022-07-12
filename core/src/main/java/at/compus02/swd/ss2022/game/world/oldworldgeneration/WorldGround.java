package at.compus02.swd.ss2022.game.world.oldworldgeneration;

import at.compus02.swd.ss2022.game.factorys.TileFactory;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class WorldGround {

    private Array<GameObject> worldObjects = new Array<>();

    public WorldGround() {
        this.worldObjects = new Array<>();
    }

    public void create() {

        for (int i = -Gdx.graphics.getWidth()/3; i < Gdx.graphics.getWidth()/3; i = i + 32) {
            worldObjects.add(new TileFactory().create("gras").setPosition(i,0));

            for (int p = -Gdx.graphics.getWidth()/2; p < Gdx.graphics.getWidth()/2; p = p + 32) {
                worldObjects.add(new TileFactory().create("gras").setPosition(p,i));
            }
        }

    }

    public Array<GameObject> getWorldObjects() {
        return worldObjects;
    }
}
