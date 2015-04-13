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


}
