package intervals.entities;

import intervals.utils.Point;

public class UnopenedInterval extends Interval {
	
	public static Interval create (Point minimum, Point maximum){
		return new UnopenedInterval(minimum, maximum);
	}

	protected UnopenedInterval(Point minimum, Point maximum) {
		super(minimum, maximum);
	}

}
