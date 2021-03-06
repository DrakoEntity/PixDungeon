package Maps;

import Render.MapRender;
import States.Game;
import Tiles.BaseObject;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Map {
    private BaseObject[][] map;
    private String name;
    private int mapID;
    private Vector2f startPos = new Vector2f(0, 0);

    public Map initMap() {
        Game.player.changeMap(this);
        return this;
    }

    public Map renderMap(float mapX, float mapY, GameContainer gc) throws SlickException {
        int maxY = map[0].length;
        int maxX = map.length;
        if(Game.isChangingMap()) {
            initMap();
        }

        for(int y = 0; y < maxY; y++) {
            for(int x = 0; x < maxX; x++) {
                MapRender.drawTile(map[x][y], y, x, mapX, mapY, this, true, gc);
            }
        }
        return this;
    }

    public Vector2f getStartPos() {
        return startPos;
    }

    public Map(BaseObject[][] map) {
        this.map = map;
        name = "";
    }

    public Map(String name) {
        this.name = name;
    }

    public Map(int mapID) {
        this.mapID = mapID;
    }

    public Map(MapsList ml) {
        this.mapID = ml.ordinal();
    }

    public Map(BaseObject[][] map, String name) {
        this.map = map;
        this.name = name;
    }

    public Map(BaseObject[][] map, String name, int mapID) {
        this.map = map;
        this.name = name;
        this.mapID = mapID;
    }

    public Map(BaseObject[][] map, String name, MapsList ml) {
        this.map = map;
        this.name = name;
        this.mapID = ml.ordinal();
    }

    public Map(BaseObject[][] map, String name, MapsList ml, Vector2f sPos) {
        this.map = map;
        this.name = name;
        this.mapID = ml.ordinal();
        startPos = sPos;
    }

    public Map(BaseObject[][] map, String name, MapsList ml, int x, int y) {
        this.map = map;
        this.name = name;
        this.mapID = ml.ordinal();
        startPos = new Vector2f(x, y);
    }

    public Map setStartPos(int x, int y) {
        startPos = new Vector2f(x, y);
        return this;
    }

    public Map setStartPos(Vector2f pos) {
        startPos = pos;
        return this;
    }

    public Map setMap(BaseObject[][] map) {
        this.map = map;
        return this;
    }

    public Map setName(String name) {
        this.name = name;
        return this;
    }

    public Map setID(int mapID) {
        this.mapID = mapID;
        return this;
    }

    public BaseObject[][] getMap() {
        return map;
    }

    public Map setTile(int x, int y, BaseObject t) {
        map[x][y] = t;
        return this;
    }

    public BaseObject getTile(int x, int y) {
        if(y >= 0 && y < map.length) {
            if(x >= 0 && x < map[y].length) {
                return map[y][x];
            }else return null;
        }else return null;
    }

    public int getMapID() {
        return mapID;
    }

    public String getName() {
        return name;
    }

    public int getMaxX() {
        return map.length;
    }

    public int getMaxY() {
        return map[0].length;
    }
}