package at.compus02.swd.ss2022.game.world;

import at.compus02.swd.ss2022.game.gameobjects.Tile;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factorys.TileFactory;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class World {

    private Array<GameObject> worldObjects = new Array<>();

    public World() {
        this.worldObjects = new Array<>();
    }

    public void create() {

        for (int i = -600; i < 600; i = i + 32) {
            worldObjects.add(new TileFactory().create("gras").setPosition(i,0));

            for (int p = -600; p < 600; p = p + 32) {
                worldObjects.add(new TileFactory().create("gras").setPosition(p,i));
            }
        }

    }

    public Array<GameObject> getWorldObjects() {
        return worldObjects;
    }
}
