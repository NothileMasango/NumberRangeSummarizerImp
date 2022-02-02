import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImplem implements NumberRangeSummarizer {
	private boolean isSequential= false;
	private int currentValue = 0;
	private int nextValue = 0;

	@Override
	public Collection<Integer> collect(String input) {	
		// TODO Auto-generated method stub
		
		if (input.isEmpty()) {
			return Collections.emptyList();
		}
		
		else {
		Set<Integer> set = Arrays.stream(input.split("[,]")).filter(val -> val.matches("^[0-9]*$")).map(Integer::parseInt)
				.collect(Collectors.toSet());
		
		//Sort list
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(set);
		Collections.sort(numbers);
		return numbers;
		}
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>(input);
		
		return summarize(list); 
	}
	
	
	private String summarize(ArrayList<Integer> list) {
		if (list.isEmpty()) {
			return "";
		}
		
		else {
		String initialNumber=list.get(0).toString();
		
		for (int i=0; i<= list.size()-2; i++) {
			currentValue = list.get(i);
			nextValue = list.get(i + 1);
		
		 if ((nextValue - currentValue) == 1) {
			isSequential = true;
			
		}
		
		else if (isSequential) {
			initialNumber += "-" + list.get(i);
			
			initialNumber += "," + list.get(i+1);
			isSequential = false;
			
		}
		
		else {
			initialNumber += "," + list.get(i+1);
			isSequential = false;
			
		}
		
	}
		return initialNumber;
		}
		
		
		
	}
}
