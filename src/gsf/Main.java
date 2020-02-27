package gsf;

import gsf.unit.Unit;
import gsf.unit.UnitGroup;
import gsf.unit.Weapon;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UnitTester tester = new UnitTester();
        Unit unit = new Unit(1000);

        tester.testType(unit, "infantry", "infantry");

        tester.testUnitSpecificProperty(unit, "hitPoints", 25, 25);

        tester.testChangeProperty(unit, "hitPoints", 15, 15);

        tester.testNonExistentProperty(unit, "strength");

        tester.testID(unit, 1000);

        tester.testName(unit, "Josh", "Josh");

        Weapon axe = new Weapon();
        axe.setType("Axe");
        tester.testWeapons(unit, axe, axe);

        Unit unit1 = new Unit(1001);
        List<Unit> units = new LinkedList<>();
        units.add(unit);
        units.add(unit1);
        tester.testCreatingGroup(units, units);

        tester.testAddingUnit(new Unit(100), new Unit(100), new UnitGroup());
    }
}
