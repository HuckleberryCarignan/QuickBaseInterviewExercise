import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickBaseTwoLargestTest_Positive {


    // Nested class to serve as input object for
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
                    // Test Case: Quick Base test set 1
                    {new QuickBaseTestObject(new int[]{5,100,10,125,15,150,20,175,25,0},175, 150)},
                    // Test Case: Quick Base test set 2
                    {new QuickBaseTestObject(new int[]{25,93,97,18,71,114,52,48},114, 97)},
                    // Test Case: Array only has two elements of same value
                    {new QuickBaseTestObject(new int[]{5,5},5, 5)},
                    // Test Case: Array only has two elements - one positive, one zero
                    {new QuickBaseTestObject(new int[]{1000,0},1000, 0)},
                    // Test Case: Array only has two elements - one positive, one negative
                    {new QuickBaseTestObject(new int[]{1000,-1},1000, -1)},
                    // Test Case: Array only has two elements - both negative
                    {new QuickBaseTestObject(new int[]{-5,-1},-1, -5)},
                    // Test Case: Array only has two elements - one negative, one zero
                    {new QuickBaseTestObject(new int[]{0,-1},0, -1)}
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

    // TestNG - takes in dataProvider for input
    @Test(dataProvider = "twoLargestValuesTestInputData")
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