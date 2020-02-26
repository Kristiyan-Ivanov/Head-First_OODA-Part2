package com.gsf.enums;

public enum Terrain {
    GRASS;

    @Override
    public String toString() {
        switch (this) {
            case GRASS:
                return "Grass";
        default:
            return "No Terrain";
        }
    }
}
