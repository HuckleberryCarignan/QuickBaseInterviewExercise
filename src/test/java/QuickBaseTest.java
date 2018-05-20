import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class QuickBaseTest {


    @DataProvider(name="twoLargestValuesTestInputData")
    public Object[][] twoLargestValuesTestInputDataObject() {
            return new Object[][]{
                    {new QuickBaseTestObject(new int[]{4,3,2},4)}
        };
    }


    private static class QuickBaseTestObject {
        int[] itemsToAdd;
        int excpectedValue;

        public QuickBaseTestObject(int[] itemsToAdd, int excpectedValue) {
            this.itemsToAdd = itemsToAdd;
            this.excpectedValue = excpectedValue;
        }

        public int[] getItemsToAdd() {
            return itemsToAdd;
        }

        public int getExcpectedValue() {
            return excpectedValue;
        }
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

        List<Integer> testList = new ArrayList<>();
        testList=createArrayList(quickBaseTestObject.getItemsToAdd());

        QuickBase twoLargestObject = new QuickBase();


   //     Collections.addAll(quickBaseTestObject.getItemsToAdd());
        twoLargestObject.twoLargest(testList);
        Assert.assertEquals(twoLargestObject.twoLargest(testList),quickBaseTestObject.getExcpectedValue());
    }



}