package gsf.unit;

import java.util.*;

public class Unit {
    private String type;
    private Map<String, Object> properties;
    private Integer id;
    private String name;
    private List<Weapon> weapons;

    public Unit(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getPropertie(String propertie) {
        if (properties == null) {
            throw new RuntimeException("No properties for this unit.");
        }

        Object value = properties.getOrDefault(propertie, null);
        if (value == null) {
            throw new RuntimeException("Request for non-existent property.");
        } else {
            return value;
        }
    }

    public void setPropertie(String propertie, Object value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(propertie, value);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void addWeapon(Weapon weapon) {
        if (this.weapons == null) {
            weapons = new LinkedList<>();
        }
        this.weapons.add(weapon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(type, unit.type) &&
                Objects.equals(properties, unit.properties) &&
                id.equals(unit.id) &&
                Objects.equals(name, unit.name) &&
                Objects.equals(weapons, unit.weapons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, properties, id, name, weapons);
    }
}
