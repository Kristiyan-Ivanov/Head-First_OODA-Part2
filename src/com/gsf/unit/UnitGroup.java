package com.gsf.unit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UnitGroup {
    private Map<Integer, Unit> units;

    public UnitGroup(List<Unit> unitList) {
        this.units = new HashMap<>();
        for (Unit unit: unitList) {
            units.put(unit.getId(), unit);
        }
    }

    public UnitGroup() {
        this(new LinkedList<>());
    }

    public void addUnit(Unit unit) {
        units.put(unit.getId(), unit);
    }

    public void removeUnit(Integer id) {
        units.remove(id);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit.getId());
    }

    public Unit getUnit(Integer id) {
        return units.get(id);
    }

    public List<Unit> getUnits() {
        return new LinkedList<>(units.values());
    }
}
