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

}
