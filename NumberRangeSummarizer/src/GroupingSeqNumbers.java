import java.util.Arrays;
import java.util.Collection;

public class GroupingSeqNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NumberRangeSummarizer test = new NumberRangeSummarizerImplem();

		Collection<Integer> result = test.collect("");
		
		System.out.println(Arrays.toString(result.toArray()));
		
		System.out.println(test.summarizeCollection(result));

	}

}
