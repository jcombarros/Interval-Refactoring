package intervals.entities;

import intervals.Opening;
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
