package intervals.entities;

import intervals.Opening;
import intervals.utils.ExactPoint;
import intervals.utils.Point;

public class LeftOpenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum, Opening opening){
		return new LeftOpenedInterval(minimum, maximum);
	}
	
	protected LeftOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum, Opening.LEFT_OPENED);
	}

	public Opening getOpening() {
		return Opening.LEFT_OPENED;
	}
	
	public boolean includes(int value) {
		Point valuePoint = new ExactPoint(value);
		return minimum.lessThan(valuePoint) && (maximum.greaterThan(valuePoint) || maximum.equalTo(valuePoint));
	}
	
	protected boolean includesResult(Interval interval, boolean minimumIncluded, boolean maximumIncluded){
		return interval.includesResult(this, minimumIncluded, maximumIncluded);
	}

	protected boolean includesResult(LeftOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded || minimum == interval.minimum)
				&& (maximumIncluded || maximum == interval.maximum);
	}

	protected boolean includesResult(RightOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded || minimum == interval.minimum)
				&& (maximumIncluded);
	}
	
	protected boolean includesResult(BothOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded || minimum == interval.minimum)
				&& (maximumIncluded);
	}
	
	protected boolean includesResult(UnopenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded || minimum == interval.minimum)
				&& (maximumIncluded || maximum == interval.maximum);
	}
//	
//	public boolean intersectsWith(Interval interval) {
//		if (minimum == interval.maximum) {
//			return false;
//		}
//		if (maximum == interval.minimum) {
//			return interval.opening == Opening.RIGHT_OPENED || interval.opening == Opening.UNOPENED;
//		}
//		return this.includes(interval.minimum) || this.includes(interval.maximum);
//	}
}
