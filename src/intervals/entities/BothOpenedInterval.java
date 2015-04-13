package intervals.entities;

import intervals.Opening;
import intervals.utils.Point;

public class BothOpenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum, Opening opening){
		return new BothOpenedInterval(minimum, maximum);
	}

	protected BothOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum, Opening.BOTH_OPENED);
	}

	public Opening getOpening() {
		return Opening.BOTH_OPENED;
	}

	public boolean intersectsWith(Interval interval) {
		if (minimum.equalTo(interval.maximum)) {
			return false;
		}
		if (maximum.equalTo(interval.minimum)) {
			return false;
		}
		return this.includes(interval.minimum.getValue()) || this.includes(interval.maximum.getValue());
	}
}
