package intervals.entities;

import intervals.Opening;
import intervals.utils.Point;

public class UnopenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum, Opening opening){
		return new UnopenedInterval(minimum, maximum);
	}

	protected UnopenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum, Opening.UNOPENED);
	}

	public Opening getOpening() {
		return Opening.UNOPENED;
	}

	public boolean intersectsWith(Interval interval) {
		if (minimum.equalTo(interval.maximum)) {
			return interval.opening == Opening.LEFT_OPENED || interval.opening == Opening.UNOPENED;

		}
		if (maximum.equalTo(interval.minimum)) {
			return interval.opening == Opening.RIGHT_OPENED || interval.opening == Opening.UNOPENED;
		}
		return this.includes(interval.minimum.getValue()) || this.includes(interval.maximum.getValue());
	}
}
