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

}
