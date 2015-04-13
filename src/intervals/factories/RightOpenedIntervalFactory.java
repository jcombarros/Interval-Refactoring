package intervals.factories;

import intervals.entities.Interval;
import intervals.entities.RightOpenedInterval;
import intervals.utils.Point;

public class RightOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(Point minimum, Point maximum) {
		return RightOpenedInterval.create(minimum, maximum);
	}
}
