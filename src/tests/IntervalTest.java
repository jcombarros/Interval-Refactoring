package tests;

import static org.junit.Assert.*;
import intervals.Opening;
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
		assertEquals(5, bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10), Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(5, leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10), Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(5, rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10), Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(5, unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10), Opening.UNOPENED).midPoint(), 0.0);

		assertEquals(0, bothOpenedIntervalFactory.getInterval(new FromPoint(-10), new UntilPoint(10), Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(0, leftOpenedIntervalFactory.getInterval(new FromPoint(-10), new ExactPoint(10), Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(0, rightOpenedIntervalFactory.getInterval(new ExactPoint(-10), new UntilPoint(10), Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(0, unopenedIntervalFactory.getInterval(new ExactPoint(-10), new ExactPoint(10), Opening.UNOPENED).midPoint(), 0.0);
		
		assertEquals(-10, bothOpenedIntervalFactory.getInterval(new FromPoint(-15), new UntilPoint(-5), Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(-10, leftOpenedIntervalFactory.getInterval(new FromPoint(-15), new ExactPoint(-5), Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(-10, rightOpenedIntervalFactory.getInterval(new ExactPoint(-15), new UntilPoint(-5), Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(-10, unopenedIntervalFactory.getInterval(new ExactPoint(-15), new ExactPoint(-5), Opening.UNOPENED).midPoint(), 0.0);
	}

	@Test
	public void includeValueTest() {
		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10), Opening.BOTH_OPENED).includes(-3));
		assertFalse(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10), Opening.LEFT_OPENED).includes(-3));
		assertFalse(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10), Opening.RIGHT_OPENED).includes(-3));
		assertFalse(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10), Opening.UNOPENED).includes(-3));

		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10), Opening.BOTH_OPENED).includes(0));
		assertFalse(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10), Opening.LEFT_OPENED).includes(0));
		assertTrue(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10), Opening.RIGHT_OPENED).includes(0));
		assertTrue(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10), Opening.UNOPENED).includes(0));

		assertTrue(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10), Opening.BOTH_OPENED).includes(5));
		assertTrue(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10), Opening.LEFT_OPENED).includes(5));
		assertTrue(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10), Opening.RIGHT_OPENED).includes(5));
		assertTrue(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10), Opening.UNOPENED).includes(5));

		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10), Opening.BOTH_OPENED).includes(10));
		assertTrue(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10), Opening.LEFT_OPENED).includes(10));
		assertFalse(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10), Opening.RIGHT_OPENED).includes(10));
		assertTrue(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10), Opening.UNOPENED).includes(10));

		assertFalse(bothOpenedIntervalFactory.getInterval(new FromPoint(0), new UntilPoint(10), Opening.BOTH_OPENED).includes(13));
		assertFalse(leftOpenedIntervalFactory.getInterval(new FromPoint(0), new ExactPoint(10), Opening.LEFT_OPENED).includes(13));
		assertFalse(rightOpenedIntervalFactory.getInterval(new ExactPoint(0), new UntilPoint(10), Opening.RIGHT_OPENED).includes(13));
		assertFalse(unopenedIntervalFactory.getInterval(new ExactPoint(0), new ExactPoint(10), Opening.UNOPENED).includes(13));

	}

//	@Test
//	public void includeIntervalTest() {
//		
//		Interval bothOpenedPivot = bothOpenedIntervalFactory.getInterval(20, 35, Opening.BOTH_OPENED);
//
//		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
//
//		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
//
//		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
//
//		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
//		assertTrue(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.includes(unopenedIntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
//
//		Interval leftOpenedPivot = leftOpenedIntervalFactory.getInterval(20, 35, Opening.LEFT_OPENED);
//		
//		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
//
//		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
//
//		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
//
//		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
//		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
//		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
//		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
//		assertFalse(leftOpenedPivot.includes(unopenedIntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
//
//		Interval rightOpenedPivot = rightOpenedIntervalFactory.getInterval(20, 35, Opening.RIGHT_OPENED);
//		
//		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
//
//		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
//
//		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
//
//		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
//		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
//		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
//		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
//		assertFalse(rightOpenedPivot.includes(unopenedIntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
//
//		Interval unopenedOpenedPivot = unopenedIntervalFactory.getInterval(20, 35, Opening.UNOPENED);
//		
//		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(10, 15, Opening.BOTH_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(15, 20, Opening.BOTH_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(25, 30, Opening.BOTH_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(30, 35, Opening.BOTH_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(35, 40, Opening.BOTH_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(bothOpenedIntervalFactory.getInterval(40, 45, Opening.BOTH_OPENED)));
//
//		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(10, 15, Opening.LEFT_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(15, 20, Opening.LEFT_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(25, 30, Opening.LEFT_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(30, 35, Opening.LEFT_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(35, 40, Opening.LEFT_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(leftOpenedIntervalFactory.getInterval(40, 45, Opening.LEFT_OPENED)));
//
//		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(10, 15, Opening.RIGHT_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(15, 20, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(25, 30, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(30, 35, Opening.RIGHT_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(35, 40, Opening.RIGHT_OPENED)));
//		assertFalse(unopenedOpenedPivot.includes(rightOpenedIntervalFactory.getInterval(40, 45, Opening.RIGHT_OPENED)));
//
//		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(10, 15, Opening.UNOPENED)));
//		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(15, 20, Opening.UNOPENED)));
//		assertTrue(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(20, 25, Opening.UNOPENED)));
//		assertTrue(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(25, 30, Opening.UNOPENED)));
//		assertTrue(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(30, 35, Opening.UNOPENED)));
//		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(35, 40, Opening.UNOPENED)));
//		assertFalse(unopenedOpenedPivot.includes(unopenedIntervalFactory.getInterval(40, 45, Opening.UNOPENED)));
//
//	}
//
//	@Test
//	public void hasIntersectionTest() {
//
//		Interval bothOpenedPivot = bothOpenedIntervalFactory.getInterval(20, 40, Opening.BOTH_OPENED);
//		
//		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//
//		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//
//		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//
//		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		assertTrue(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		assertFalse(bothOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//
//		Interval leftOpenedPivot = leftOpenedIntervalFactory.getInterval(20, 40, Opening.LEFT_OPENED);
//		
//		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//
//		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//
//		assertFalse(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//
//		assertFalse(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
//		assertTrue(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		assertFalse(leftOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//
//		Interval rightOpenedPivot = rightOpenedIntervalFactory.getInterval(20, 40, Opening.RIGHT_OPENED);
//		
//		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//
//		assertFalse(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//
//		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//
//		assertFalse(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		assertTrue(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		assertFalse(rightOpenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//
//		Interval unopenedPivot = unopenedIntervalFactory.getInterval(20, 40, Opening.UNOPENED);
//		
//		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(5, 15, Opening.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(10, 20, Opening.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(25, 35, Opening.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(35, 45, Opening.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(bothOpenedIntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//
//		assertFalse(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(5, 15, Opening.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(25, 35, Opening.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(35, 45, Opening.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(leftOpenedIntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//
//		assertFalse(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(5, 15, Opening.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(10, 20, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(25, 35, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(35, 45, Opening.RIGHT_OPENED)));
//		assertTrue(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		assertFalse(unopenedPivot.intersectsWith(rightOpenedIntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//
//		assertFalse(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(5, 15, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(25, 35, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(35, 45, Opening.UNOPENED)));
//		assertTrue(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		assertFalse(unopenedPivot.intersectsWith(unopenedIntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//
//	}

//	@Test
//	public void intersectionTest() {
//		
//		 Interval bothOpenedPivot = IntervalFactory.getInterval(20, 50, Opening.BOTH_OPENED);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.UNOPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//		 
//		 Interval unopenedPivot = IntervalFactory.getInterval(20, 50, Opening.UNOPENED);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(50, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60, Opening.RIGHT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(50, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60, Opening.UNOPENED)));
//		 
//	}

}
