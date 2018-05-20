import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickBaseTwoLargest {
    // Define local variables
    private List<Integer> inputList = new ArrayList<>();
    private List<Integer> largestAndSecondLargestList = new ArrayList<>();

    // Constructor
    public QuickBaseTwoLargest(List<Integer> inputList) {
        // Verify that the List is large enough to have 2 element subset for results
        if (inputList.size()>1) {
            this.inputList = inputList;
            this.largestAndSecondLargestList = findTwoLargest(inputList);
        } else {
            throw new IllegalArgumentException("List param cannot be < 1.");
        }

    }
    // Getters
    public List<Integer> inputList() {
        return inputList;
    }

    public List<Integer> getLargestAndSecondLargestList() {
        return largestAndSecondLargestList;
    }

    // Setters
    public void inputList(List<Integer> boo) {
        this.inputList = boo;
    }

    // Method that returns the second and
    private List<Integer> findTwoLargest(List listToMined){
        List<Integer> largestAndSecondLargestToBeReturned = new ArrayList<>();

        //Collections.sort(listToMined);
        Collections.sort(listToMined, Collections.reverseOrder());

        largestAndSecondLargestToBeReturned.add((int)listToMined.get(0));
        largestAndSecondLargestToBeReturned.add((int)listToMined.get(1));



        return largestAndSecondLargestToBeReturned;




    }

}
