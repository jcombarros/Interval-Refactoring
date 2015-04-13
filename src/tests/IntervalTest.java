package tests;

import static org.junit.Assert.*;
import intervals.entities.Interval;
import intervals.factories.IntervalFactory;
import intervals.utils.ExactPoint;
import intervals.utils.FromPoint;
import intervals.utils.UntilPoint;

import org.junit.Before;
import org.junit.Test;
 
public class IntervalTest {

	private IntervalFactory intervalFactory;

	@Before
	public void before(){
		intervalFactory = new IntervalFactory();
	}

	@Test
	public void midPointTest() {
		assertEquals(5, intervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(5, intervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).midPoint(), 0.0);
		assertEquals(5, intervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(5, intervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).midPoint(), 0.0);

		assertEquals(0, intervalFactory.getInterval(new FromPoint(-10), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(0, intervalFactory.getInterval(new FromPoint(-10), new ExactPoint(10)).midPoint(), 0.0);
		assertEquals(0, intervalFactory.getInterval(new ExactPoint(-10), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(0, intervalFactory.getInterval(new ExactPoint(-10), new ExactPoint(10)).midPoint(), 0.0);
		
		assertEquals(-10, intervalFactory.getInterval(new FromPoint(-15), new UntilPoint(-5)).midPoint(), 0.0);
		assertEquals(-10, intervalFactory.getInterval(new FromPoint(-15), new ExactPoint(-5)).midPoint(), 0.0);
		assertEquals(-10, intervalFactory.getInterval(new ExactPoint(-15), new UntilPoint(-5)).midPoint(), 0.0);
		assertEquals(-10, intervalFactory.getInterval(new ExactPoint(-15), new ExactPoint(-5)).midPoint(), 0.0);
	}

	@Test
	public void includeValueTest() {
		assertFalse(intervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(-3));
		assertFalse(intervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(-3));
		assertFalse(intervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(-3));
		assertFalse(intervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(-3));

		assertFalse(intervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(0));
		assertFalse(intervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(0));
		assertTrue(intervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(0));
		assertTrue(intervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(0));

		assertTrue(intervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(5));
		assertTrue(intervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(5));
		assertTrue(intervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(5));
		assertTrue(intervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(5));

		assertFalse(intervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(10));
		assertTrue(intervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(10));
		assertFalse(intervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(10));
		assertTrue(intervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(10));

		assertFalse(intervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(13));
		assertFalse(intervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(13));
		assertFalse(intervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(13));
		assertFalse(intervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(13));

	}

	@Test
	public void includeIntervalTest() {
		
		Interval bothOpenedPivot = intervalFactory.getInterval(new FromPoint(20), new UntilPoint(35));

		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(bothOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

		Interval leftOpenedPivot = intervalFactory.getInterval(new FromPoint(20), new ExactPoint(35));
		
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(leftOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

		Interval rightOpenedPivot = intervalFactory.getInterval(new ExactPoint(20), new UntilPoint(35));
	
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(rightOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

		Interval unopenedOpenedPivot = intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(35));
		
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

	}

	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = intervalFactory.getInterval(new FromPoint(20), new UntilPoint(40));
		
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

		Interval leftOpenedPivot = intervalFactory.getInterval(new FromPoint(20), new ExactPoint(40));
		
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertTrue(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

		Interval rightOpenedPivot = intervalFactory.getInterval(new ExactPoint(20), new UntilPoint(40));
		
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

		Interval unopenedPivot = intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(40));
		
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertTrue(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(intervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

	}

//	@Test
//	public void intersectionTest() {
//		
//		 Interval bothOpenedPivot = IntervalFactory.getInterval(20, 50);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 
//		 Interval unopenedPivot = IntervalFactory.getInterval(20, 50);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20)));
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 assertEquals(IntervalFactory.getInterval(50, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20)));
//		 assertEquals(IntervalFactory.getInterval(20, 25),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25)));
//		 assertEquals(IntervalFactory.getInterval(20, 30),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30)));
//		 assertEquals(IntervalFactory.getInterval(30, 40),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40)));
//		 assertEquals(IntervalFactory.getInterval(40, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50)));
//		 assertEquals(IntervalFactory.getInterval(45, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55)));
//		 assertEquals(IntervalFactory.getInterval(50, 50),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60)));
//		 
//	}

}
