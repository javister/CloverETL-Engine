package org.jetel.util;

import junit.framework.TestCase;

public class NumberIteratorTest extends TestCase {
	
	NumberIterator numbers;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
    	numbers = new NumberIterator("*--9,-7--5,-3,-1,1-3,5,7,9-*",-10,10);
	}
	
	
    public void test_1(){
    	while (numbers.hasNext()){
    		System.out.print(numbers.next() + ",");
    	}
     }

    public void test_2(){
    	for (int i=0;i<14;i++){
    		System.out.print(numbers.next() + ",");
    	}
     }

    @Override
    protected void tearDown() throws Exception {
    	super.tearDown();
    	System.out.println();
    }
}
