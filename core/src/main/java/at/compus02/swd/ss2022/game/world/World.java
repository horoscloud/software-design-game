package at.compus02.swd.ss2022.game.world;

import at.compus02.swd.ss2022.game.factorys.ObjectFactory;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factorys.TileFactory;
import com.badlogic.gdx.utils.Array;

public class World {

    private Array<GameObject> worldObjects = new Array<>();

    public World() {
        this.worldObjects = worldObjects;
    }

    public void create() {

        TileFactory tile;

        for (int i = -600; i < 600; i = i + 32) {
            tile = new TileFactory();
            tile.create("gras");
            tile.setPosition(0, i);
            worldObjects.add(tile);

            for (int p = -600; p < 600; p = p + 32) {
                tile = new TileFactory();
                tile.create("gras");
                tile.setPosition(p, i);
                worldObjects.add(tile);
            }
        }
    }

    public Array<GameObject> getWorldObjects() {
        return worldObjects;
    }
}
