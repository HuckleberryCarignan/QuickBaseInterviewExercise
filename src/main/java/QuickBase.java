import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickBase {



    List<Integer> boo = new ArrayList<>();

    public int twoLargest(List listToMine){
        int largest;
        int secondlargest;
        List<Integer> sortedArray = new ArrayList<>();
        Collections.sort(listToMine);
        secondlargest=(int)listToMine.get(1) ;
        return secondlargest;


    }

}
