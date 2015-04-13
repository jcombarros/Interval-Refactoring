package intervals.factories;

import intervals.entities.Interval;
import intervals.utils.Point;

public class IntervalFactory {

	public Interval getInterval(Point minimum, Point maximum){
		return Interval.create(minimum, maximum);
	}
}
