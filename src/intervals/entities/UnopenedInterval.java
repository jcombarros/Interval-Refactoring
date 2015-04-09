package intervals.entities;

import intervals.Opening;

public class UnopenedInterval extends Interval {
	
	public static Interval create (int minimum, int maximum, Opening opening){
		return new UnopenedInterval(minimum, maximum);
	}

	protected UnopenedInterval(int minimum, int maximum) {
		super(minimum, maximum, Opening.UNOPENED);
	}

	public Opening getOpening() {
		return Opening.UNOPENED;
	}
	
	public boolean includes(double value) {
		return minimum <= value && value <= maximum;
	}
	
//	protected boolean includesResult(Interval interval, boolean minimumIncluded, boolean maximumIncluded){
//		return interval.includesResult(this, minimumIncluded, maximumIncluded);
//	}
//
//	protected boolean includesResult(LeftOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
//		return (minimumIncluded)
//				&& (maximumIncluded || maximum == interval.maximum);
//	}
//
//	protected boolean includesResult(RightOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
//		return (minimumIncluded || minimum == interval.minimum)
//				&& (maximumIncluded);
//	}
//	
//	protected boolean includesResult(BothOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
//		return (minimumIncluded) && (maximumIncluded);
//	}
//	
//	protected boolean includesResult(UnopenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
//		return (minimumIncluded || minimum == interval.minimum)
//				&& (maximumIncluded || maximum == interval.maximum);
//	}
//	
//	public boolean intersectsWith(Interval interval) {
//		if (minimum == interval.maximum) {
//			return interval.opening == Opening.LEFT_OPENED || interval.opening == Opening.UNOPENED;
//
//		}
//		if (maximum == interval.minimum) {
//			return interval.opening == Opening.RIGHT_OPENED || interval.opening == Opening.UNOPENED;
//		}
//		return this.includes(interval.minimum) || this.includes(interval.maximum);
//	}
}
