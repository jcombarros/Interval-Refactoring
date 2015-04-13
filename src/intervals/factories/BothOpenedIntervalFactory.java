package intervals.factories;

import intervals.entities.BothOpenedInterval;
import intervals.entities.Interval;
import intervals.utils.Point;

public class BothOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(Point minimum, Point maximum) {
		return BothOpenedInterval.create(minimum, maximum);
	}
}
