package gsf;

import gsf.unit.Unit;
import gsf.unit.UnitGroup;
import gsf.unit.Weapon;

import java.util.HashSet;
import java.util.List;

class UnitTester {

    public void testType(Unit unit, String type, String expectedOutputType) {
        System.out.println("\nTesting setting/getting the type properly.");
        unit.setType(type);
        String outputType = unit.getType();
        if (expectedOutputType.equals(outputType)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputType + "didn't match " + expectedOutputType);
        }
    }

    public void testUnitSpecificProperty(Unit unit, String propertyName, Object inputValue, Object expectedOutput) {
        System.out.println("\nTesting setting/getting a unit-specific property.");
        unit.setPropertie(propertyName, inputValue);
        Object outputValue = unit.getPropertie(propertyName);
        if (expectedOutput.equals(outputValue)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputValue + "didn't match " + expectedOutput);
        }
    }

    public void testChangeProperty(Unit unit, String propertyName, Object inputValue, Object expectedOutput) {
        System.out.println("\nTesting changing an existing property's value.");
        unit.setPropertie(propertyName, inputValue);
        Object outputValue = unit.getPropertie(propertyName);
        if (expectedOutput.equals(outputValue)) {
            System.out.println("Test passed");
        } else
            System.out.println("Test failed: " + outputValue + "didn't match" + expectedOutput);
    }

    public void testNonExistentProperty(Unit unit, String propertyName) {
        System.out.println("\nTesting getting a non-existent property's value.");
        try {
            Object outputValue = unit.getPropertie(propertyName);
        } catch (RuntimeException e) {
            System.out.println("Test passed");
            return;
        }

        System.out.println("Test failed.");
    }

    public void testID(Unit unit, Integer expectedID) {
        System.out.println("\nTesting getting the ID property");
        Integer outputID = unit.getId();
        if (expectedID.equals(outputID)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputID + " didn't match " + expectedID);
        }
    }

    public void testName(Unit unit, String inputValue, String expectedValue) {
        System.out.println("\nTesting getting/setting the name property");
        unit.setName(inputValue);
        String outputName = unit.getName();
        if (expectedValue.equals(outputName)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + outputName + " didn't match " + expectedValue);
        }
    }

    public void testWeapons(Unit unit, Weapon inputValue, Weapon expectedValue) {
        System.out.println("\nTesting getting/adding weapon to weapons property");
        unit.addWeapon(inputValue);
        List<Weapon> outputWeapons = unit.getWeapons();
        if (outputWeapons.contains(expectedValue)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + expectedValue + " is not in object's weapons");
        }
    }

    public void testCreatingGroup(List<Unit> inputUnits, List<Unit> expectedOutput) {
        System.out.println("\nTesting creating new group of units with predefined list");
        UnitGroup units = new UnitGroup(inputUnits);

        if (listEqualsIgnoreOrder(expectedOutput, units.getUnits())) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed, expected output didn't match the input list");
        }
    }

    private static <Unit> boolean listEqualsIgnoreOrder(List<Unit> list1, List<Unit> list2) {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }

    public void testAddingUnit(Unit inputUnit, Unit expectedUnit, UnitGroup group) {
        System.out.println("\nTesting adding/getting unit to group");
        group.addUnit(inputUnit);

        List outputUnit = group.getUnits();
        if (outputUnit.contains(expectedUnit)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: " + expectedUnit.getId() + " is not in the unit group");
        }

    }
}
