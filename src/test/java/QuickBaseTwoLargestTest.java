import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class QuickBaseTwoLargestTest {


    private static class QuickBaseTestObject {
        int[] itemsToAdd;
        int highestValue;
        int secondHighestValue;

        public QuickBaseTestObject(int[] itemsToAdd, int highestValue, int secondHighestValue) {
            this.itemsToAdd = itemsToAdd;
            this.highestValue = highestValue;
            this.secondHighestValue = secondHighestValue;
        }

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



    @DataProvider(name="twoLargestValuesTestInputData")
    public Object[][] twoLargestValuesTestInputDataObject() {
            return new Object[][]{
                    {new QuickBaseTestObject(new int[]{5,100,10,125,15,150,20,175,25,0},175, 150)},
                    {new QuickBaseTestObject(new int[]{25,93,97,18,71,114,52,48},114, 97)},
                    {new QuickBaseTestObject(new int[]{5},5, 0)},
        };
    }


    public static List<Integer> createArrayList(int[] itemsToAdd){
        List<Integer> listToReturn = new ArrayList<>();
        for(int i: itemsToAdd){
            listToReturn.add(i);
        }
        return listToReturn;
    }

    @Test(dataProvider = "twoLargestValuesTestInputData")
    public void testTwoLargest(QuickBaseTestObject quickBaseTestObject ) {
        List<Integer> testList;

        testList=createArrayList(quickBaseTestObject.getItemsToAdd());

        QuickBaseTwoLargest twoLargestObject = new QuickBaseTwoLargest(testList);



        //twoLargestObject.findTwoLargest(testList);
        Assert.assertEquals((int)twoLargestObject.getLargestAndSecondLargestList().get(0),quickBaseTestObject.getHighestValue());
        Assert.assertEquals((int)twoLargestObject.getLargestAndSecondLargestList().get(1),quickBaseTestObject.getSecondHighestValue());
    }



}