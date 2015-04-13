package intervals.entities;

import intervals.utils.Point;

public class RightOpenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum){
		return new RightOpenedInterval(minimum, maximum);
	}
	
	protected RightOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum);
	}

}
