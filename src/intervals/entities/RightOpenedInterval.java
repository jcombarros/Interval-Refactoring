package intervals.entities;

import intervals.Opening;
import intervals.PointType;
import intervals.utils.ExactPoint;
import intervals.utils.Point;

public class RightOpenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum, Opening opening){
		return new RightOpenedInterval(minimum, maximum);
	}
	
	protected RightOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum, Opening.RIGHT_OPENED);
	}

	public Opening getOpening() {
		return Opening.RIGHT_OPENED;
	}
	
	public boolean includes(int value) {
		Point valuePoint = new ExactPoint(value);
		valuePoint.setType(PointType.EXACT);
		return minimum.include(valuePoint) && (maximum.include(valuePoint));
	}
	
	protected boolean includesResult(Interval interval, boolean minimumIncluded, boolean maximumIncluded){
		return interval.includesResult(this, minimumIncluded, maximumIncluded);
	}

	protected boolean includesResult(LeftOpenedInterval interval , boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded)
				&& (maximumIncluded || maximum.equalTo(interval.maximum));
	}

	protected boolean includesResult(RightOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded || minimum.equalTo(interval.minimum))
				&& (maximumIncluded || maximum.equalTo(interval.maximum));
	}
	
	protected boolean includesResult(BothOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded)
				&& (maximumIncluded || maximum.equalTo(interval.maximum));
	}
	
	protected boolean includesResult(UnopenedInterval interval, boolean minimumIncluded, boolean maximumIncluded){
		return (minimumIncluded || minimum.equalTo(interval.minimum))
				&& (maximumIncluded || maximum.equalTo(interval.maximum));
	}
	
	public boolean intersectsWith(Interval interval) {
		if (minimum.equalTo(interval.maximum)) {
			return interval.opening == Opening.LEFT_OPENED || interval.opening == Opening.UNOPENED;

		}
		if (maximum.equalTo(interval.minimum)) {
			return false;
		}
		return this.includes(interval.minimum.getValue()) || this.includes(interval.maximum.getValue());
	}
}
