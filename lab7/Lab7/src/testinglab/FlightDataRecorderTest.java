/**
 * 
 */
package testinglab;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ray
 *
 */
public class FlightDataRecorderTest {
	FlightDataRecorder test = new FlightDataRecorder();
	FlightDataRecorder test2 = new FlightDataRecorder();
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test.record(3.0);
		test2.record(3.15);
		test2.record(3.15);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * add less than cap,
	 */
	public void testRecordedData01() {
		Double [] arr = test2.getRecordedData().toArray(new Double[test2.getRecordedData().size()]);
		assertArrayEquals("Problem in the getRecordedData()",
                new Double[] {3.15,3.15}, arr);  
	}
	@Test
	/**
	 * test average (size == capacity)
	 */
	public void testaverage02(){
		
		assertEquals("Problem in the average()",
               new Double(3.0), test.average(), 0.00); 
	}
	@Test
	/**
	 * add equal cap
	 */
	public void testRecordedData02() {
		Double [] arr = test.getRecordedData().toArray(new Double[test.getRecordedData().size()]);
		assertArrayEquals("Problem in the getRecordedData()",
                new Double[] {3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0}, arr);  
	}
	@Test
	/**
	 * add more than cap, should just show the first 10
	 */
	public void testRecordedData03() {
		test.record(3.15);
		Double [] arr = test.getRecordedData().toArray(new Double[test.getRecordedData().size()]);
		assertArrayEquals("Problem in the getRecordedData()",
                new Double[] {3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0,3.0}, arr);  
	}
	@Test
	/**
	 * test length < size
	 */
	public void testgetLastDataPoints01() {
		Double [] arr = test2.getLastDataPoints(1).toArray(
				new Double[test2.getLastDataPoints(1).size()]);
		
		assertArrayEquals("Problem in the getLastDataPoints(length < size)",
                new Double[] {3.15}, arr); 
		
	}
	/**
	 * test length == size
	 */
	@Test 
	public void testgetLastDataPoints02() {
		Double [] arr = test2.getLastDataPoints(2).toArray(
				new Double[test2.getLastDataPoints(2).size()]);
		
		assertArrayEquals("Problem in the getLastDataPoints(length == size)",
                new Double[] {3.15}, arr); 
		
	}
	
	@Test
	/**
	 *  test average (size < capacity)
	 */
	public void testaverage01(){
		
		assertEquals("Problem in the average()",
                3.15, test2.average(), 0); 
	}
	
	
}
