package at.compus02.swd.ss2022.game.world.oldworldgeneration;

import at.compus02.swd.ss2022.game.factorys.TileFactory;
import at.compus02.swd.ss2022.game.interfaces.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class WorldTerrain {

    private Array<GameObject> terrainObjects = new Array<>();

    public WorldTerrain() {
        this.terrainObjects = new Array<>();
    }

    public void create() {

    }

    public Array<GameObject> getTerrainObjects() {
        return terrainObjects;
    }
}
