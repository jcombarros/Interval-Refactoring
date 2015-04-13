package intervals.entities;

import intervals.utils.Point;

public class BothOpenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum){
		return new BothOpenedInterval(minimum, maximum);
	}

	protected BothOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum);
	}
}
