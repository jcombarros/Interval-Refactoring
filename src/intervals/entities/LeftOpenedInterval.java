package intervals.entities;

import intervals.Opening;
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

	public boolean intersectsWith(Interval interval) {
		if (minimum.equalTo(interval.maximum)) {
			return false;
		}
		if (maximum.equalTo(interval.minimum)) {
			return interval.opening == Opening.RIGHT_OPENED || interval.opening == Opening.UNOPENED;
		}
		return this.includes(interval.minimum.getValue()) || this.includes(interval.maximum.getValue());
	}
}
