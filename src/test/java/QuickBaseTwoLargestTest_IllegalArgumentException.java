import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Collection of negative Test cases to make IllegalArgumentException
public class QuickBaseTwoLargestTest_IllegalArgumentException {

    // Nested class to serve as input object for DataProvider
    private static class QuickBaseTestObject {
        int[] itemsToAdd;
        int highestValue;
        int secondHighestValue;

        // Constructor
        public QuickBaseTestObject(int[] itemsToAdd, int highestValue, int secondHighestValue) {
            this.itemsToAdd = itemsToAdd;
            this.highestValue = highestValue;
            this.secondHighestValue = secondHighestValue;
        }

        // Getters
        public int[] getItemsToAdd() {
            return itemsToAdd;
        }

        public int getHighestValue() {
            return highestValue;
        }

        public int getSecondHighestValue() {
            return secondHighestValue;
        }
    }

    // DataProvider used so that additional data driven tests can be easily added
    @DataProvider(name="twoLargestValuesTestInputData")
    public Object[][] twoLargestValuesTestInputDataObject() {
            return new Object[][]{
                    // Test Case: Array of one element
                    {new QuickBaseTestObject(new int[]{5},5, 0)},
                    // Test Case: Empty Array
                    {new QuickBaseTestObject(new int[]{},0, -1)},
        };
    }

    // Method for converting int[] to List<Integer>
    private static List<Integer> createArrayList(int[] itemsToAdd){
        List<Integer> listToReturn = new ArrayList<>();
        for(int i: itemsToAdd){
            listToReturn.add(i);
        }
        return listToReturn;
    }

    // TestNG - takes in dataProvider for input and expects "IllegalArgumentException" as results
    @Test(dataProvider = "twoLargestValuesTestInputData",expectedExceptions = { IllegalArgumentException.class })
    public void testTwoLargest(QuickBaseTestObject quickBaseTestObject ) {
        List<Integer> testList;
        testList=createArrayList(quickBaseTestObject.getItemsToAdd());

        System.out.println("Testing: ");
        System.out.println("  - Input Array: " + Arrays.toString(testList.toArray()));
        System.out.println("  - Expected Highest: " + quickBaseTestObject.getHighestValue());
        System.out.println("  - Expected Second Highest: " + quickBaseTestObject.getSecondHighestValue() + "\n");

        QuickBaseTwoLargest twoLargestObject = new QuickBaseTwoLargest(testList);

        try {
            Assert.assertEquals((int)twoLargestObject.getLargestAndSecondLargestList().get(0),quickBaseTestObject.getHighestValue());
            Assert.assertEquals((int)twoLargestObject.getLargestAndSecondLargestList().get(1),quickBaseTestObject.getSecondHighestValue());
        } catch (Exception E){
            throw E;
        }



    }



}