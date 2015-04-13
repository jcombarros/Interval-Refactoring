package intervals.factories;

import intervals.entities.Interval;
import intervals.entities.LeftOpenedInterval;
import intervals.utils.Point;

public class LeftOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(Point minimum, Point maximum) {
		return LeftOpenedInterval.create(minimum, maximum);
	}
}
