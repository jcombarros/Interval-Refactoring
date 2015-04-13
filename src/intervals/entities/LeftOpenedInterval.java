package intervals.entities;

import intervals.utils.Point;

public class LeftOpenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum){
		return new LeftOpenedInterval(minimum, maximum);
	}
	
	protected LeftOpenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum);
	}

}
