import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class NumberRangeSummarizerTest {

	NumberRangeSummarizerImplem numberRangeSummarizer= new NumberRangeSummarizerImplem();
	String output;
	String input;

	@Test
	void NumberSummarizedTest() {
		Collection<Integer> result = numberRangeSummarizer.collect("1,3,6,7,8,12,13,6,14,15,21,22,1,23,24,31");
		String output = "1,3,6-8,12-15,21-24,31";
        Assert.assertEquals(numberRangeSummarizer.summarizeCollection(result),output );
	}
	@Test
	void RemovesDuplicate() {
	    input ="1,3,6,1,7,8,12,13,14,15,21,30,22,23,24,30,32,33,34";
		List<Integer> list=Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,30,32,33,34);
		Assert.assertEquals(numberRangeSummarizer.collect(input),list) ;
		
	}
	@Test
	 void OrderCollection() {
        Collection<Integer> numbers = numberRangeSummarizer.collect("1,6,3,7,8,12,13,14,15,21,22,23,24,31");
         Assert.assertFalse(Boolean.parseBoolean(Arrays.stream(numbers.toArray()).unordered().toString()));
    }
	
	 @Test
	    void CollectionSize() {
		  input ="1,3,6,7,8,12,13,14,15,21,22,23,24,31";
	       Assert.assertEquals(numberRangeSummarizer.collect(input).size(), 14);
	    }
	 @Test
		void EmptyInput() {
			Collection<Integer> result = numberRangeSummarizer.collect("");	
			List<String> list = Collections.<String>emptyList();  
	        Assert.assertEquals(result,list);
	 }
	 
	 @Test
		void SummarizeEmptyInput() {
			Collection<Integer> result = numberRangeSummarizer.collect("");	
	        Assert.assertEquals(numberRangeSummarizer.summarizeCollection(result),"");
	 }
	 
	 @Test
	 void InvalidInput() {
			Collection<Integer> result = numberRangeSummarizer.collect("1,3,6,7,8,12,13,6,14,15,21,22,1,23,24,31,n,z");	
		    output = "1,3,6-8,12-15,21-24,31";
	        Assert.assertEquals(numberRangeSummarizer.summarizeCollection(result),output);
	 }

}
