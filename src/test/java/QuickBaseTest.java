import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickBaseTest {

    //@DataProvider(name="twoLargestValuesTestInputData")

//    public Object[][] twoLargestValuesTestInputDataObject() {
//            return new Object[][]{
//                [2,2];
//        }
//    }


    
    @Test
    public void testTwoLargest() {
        QuickBase twoLargestObject = new QuickBase();
        List<Integer> testList = new ArrayList<>();
//        testList.add(10);
        Collections.addAll(testList,3,1,5,2,0);
        twoLargestObject.twoLargest(testList);
        Assert.assertEquals(twoLargestObject.twoLargest(testList),1);
        System.out.println("Running Test -> testTwoLargest");
    }
}