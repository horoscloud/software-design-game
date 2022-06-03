package at.compus02.swd.ss2022.game.factorys;

import at.compus02.swd.ss2022.game.gameobjects.Tile;

public class TileFactory {

   Tile tile;

    public TileFactory() {

    }

    public Tile create(String tileName){
        switch (tileName){
            case "gras": return tile = new Tile("gras");
            case "gravel": return tile = new Tile("gravel");
            case "wall": return tile = new Tile("wall");
            case "water": return tile = new Tile("water");
            case "bush": return tile = new Tile("bush");
            case "sign": return tile = new Tile("sign");
            case "log": return tile = new Tile("log");
            case "stone": tile = new Tile("stone");
        }
        return null;
    }

}
