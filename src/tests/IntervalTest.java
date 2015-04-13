package tests;

import static org.junit.Assert.*;
import intervals.entities.Interval;
import intervals.factories.BothOpenedIntervalFactory;
import intervals.factories.IntervalFactory;
import intervals.factories.LeftOpenedIntervalFactory;
import intervals.factories.RightOpenedIntervalFactory;
import intervals.factories.UnopenedIntervalFactory;
import intervals.utils.ExactPoint;
import intervals.utils.FromPoint;
import intervals.utils.UntilPoint;

import org.junit.Before;
import org.junit.Test;
 
public class IntervalTest {

	private IntervalFactory leftOpenedIntervalFactory;
	private IntervalFactory rightOpenedIntervalFactory;
	private IntervalFactory bothOpenedIntervalFactory;
	private IntervalFactory unopenedIntervalFactory;
	
	@Before
	public void before(){
		leftOpenedIntervalFactory = new LeftOpenedIntervalFactory();
		rightOpenedIntervalFactory = new RightOpenedIntervalFactory();
		bothOpenedIntervalFactory = new BothOpenedIntervalFactory();
		unopenedIntervalFactory = new UnopenedIntervalFactory();
	}

	@Test
	public void midPointTest() {
		assertEquals(5, bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(5, leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).midPoint(), 0.0);
		assertEquals(5, rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(5, unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).midPoint(), 0.0);

		assertEquals(0, bothOpenedIntervalFactory.getInterval(new FromPoint(-10), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(0, leftOpenedIntervalFactory.getInterval(new FromPoint(-10), new ExactPoint(10)).midPoint(), 0.0);
		assertEquals(0, rightOpenedIntervalFactory.getInterval(new ExactPoint(-10), new UntilPoint(10)).midPoint(), 0.0);
		assertEquals(0, unopenedIntervalFactory.getInterval(new ExactPoint(-10), new ExactPoint(10)).midPoint(), 0.0);
		
		assertEquals(-10, bothOpenedIntervalFactory.getInterval(new FromPoint(-15), new UntilPoint(-5)).midPoint(), 0.0);
		assertEquals(-10, leftOpenedIntervalFactory.getInterval(new FromPoint(-15), new ExactPoint(-5)).midPoint(), 0.0);
		assertEquals(-10, rightOpenedIntervalFactory.getInterval(new ExactPoint(-15), new UntilPoint(-5)).midPoint(), 0.0);
		assertEquals(-10, unopenedIntervalFactory.getInterval(new ExactPoint(-15), new ExactPoint(-5)).midPoint(), 0.0);
	}

	@Test
	public void includeValueTest() {
		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(-3));
		assertFalse(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(-3));
		assertFalse(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(-3));
		assertFalse(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(-3));

		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(0));
		assertFalse(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(0));
		assertTrue(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(0));
		assertTrue(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(0));

		assertTrue(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(5));
		assertTrue(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(5));
		assertTrue(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(5));
		assertTrue(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(5));

		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(10));
		assertTrue(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(10));
		assertFalse(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(10));
		assertTrue(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(10));

		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10)).includes(13));
		assertFalse(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10)).includes(13));
		assertFalse(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10)).includes(13));
		assertFalse(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10)).includes(13));

	}

	@Test
	public void includeIntervalTest() {
		
		Interval bothOpenedPivot = bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(35));

		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

		Interval leftOpenedPivot = leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(35));
		
		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

		Interval rightOpenedPivot = rightOpenedIntervalFactory.getInterval(new ExactPoint(20), new UntilPoint(35));
	
		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

		Interval unopenedOpenedPivot = unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(35));
		
		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(25))));
		assertTrue(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(45))));

		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(25))));
		assertTrue(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(45))));

		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(20),new UntilPoint( 25))));
		assertTrue(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(45))));

		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(15))));
		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(20))));
		assertTrue(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(25))));
		assertTrue(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(30))));
		assertTrue(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(35))));
		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(40))));
		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(45))));

	}

	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(40));
		
		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

		Interval leftOpenedPivot = leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(40));
		
		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertFalse(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

		Interval rightOpenedPivot = rightOpenedIntervalFactory.getInterval(new ExactPoint(20), new UntilPoint(40));
		
		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertFalse(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

		Interval unopenedPivot = unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(40));
		
		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(5), new UntilPoint(15))));
		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(10), new UntilPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(15), new UntilPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(20), new UntilPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(25), new UntilPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(30), new UntilPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(35), new UntilPoint(45))));
		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(40), new UntilPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(new FromPoint(45), new UntilPoint(55))));

		assertFalse(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(5), new ExactPoint(15))));
		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(10), new ExactPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(15), new ExactPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(20), new ExactPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(25), new ExactPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(30), new ExactPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(35), new ExactPoint(45))));
		assertFalse(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(40), new ExactPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(new FromPoint(45), new ExactPoint(55))));

		assertFalse(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(5), new UntilPoint(15))));
		assertFalse(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(10), new UntilPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(15), new UntilPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(20), new UntilPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(25), new UntilPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(30), new UntilPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(35), new UntilPoint(45))));
		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(40), new UntilPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(new ExactPoint(45), new UntilPoint(55))));

		assertFalse(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(5), new ExactPoint(15))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(10), new ExactPoint(20))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(15), new ExactPoint(25))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(20), new ExactPoint(30))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(25), new ExactPoint(35))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(30), new ExactPoint(40))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(35), new ExactPoint(45))));
		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(40), new ExactPoint(50))));
		assertFalse(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(new ExactPoint(45), new ExactPoint(55))));

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
