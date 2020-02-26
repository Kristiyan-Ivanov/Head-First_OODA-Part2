package com.gsf.board;

import com.gsf.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int width, height;
    // 2d board consists composed of list of lists with com.gsf.board.Tile Objects
    private List<List<Tile>> tiles;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        initialize();
    }

    private void initialize() {
        tiles = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            tiles.add(i, new ArrayList<>(height));
            for (int j = 0; j < height; j++) {
                tiles.get(i).add(j, new Tile());
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles.get(x - 1).get(y - 1);
    }

    public void addUnit(Unit unit, int x, int y) {
        Tile tile = getTile(x, y);
        tile.addUnit(unit);
    }


    public void removeUnit(Unit unit, int x, int y) {
        Tile tile = getTile(x, y);
        tile.removeUnit(unit);
    }


    public List<Unit> getUnits(int x, int y) {
        return getTile(x, y).getUnits();
    }


    public void removeUnits(int x, int y) {
        Tile tile = getTile(x, y);
        tile.removeUnits();
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
