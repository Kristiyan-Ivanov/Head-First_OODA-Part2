package com.gsf.board;

import com.gsf.enums.Terrain;
import com.gsf.unit.Unit;

import java.util.LinkedList;
import java.util.List;

public class Tile {
    private List<Unit> units;
    private Terrain terrainType;

    public Tile() {
        this.units = new LinkedList<>();
        this.terrainType = Terrain.GRASS;
    }

    public Tile(Terrain terrainType) {
        this.terrainType = terrainType;
    }

    protected void addUnit(Unit unit) {
        units.add(unit);
    }

    protected void removeUnit(Unit unit) {
        units.remove(unit);
    }

    protected void removeUnits() {
        units = new LinkedList<>();
    }

    protected List<Unit> getUnits() {
        return units;
    }

}
