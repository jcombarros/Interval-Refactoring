package intervals.factories;

import intervals.entities.Interval;
import intervals.entities.UnopenedInterval;
import intervals.utils.Point;

public class UnopenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(Point minimum, Point maximum) {
		return UnopenedInterval.create(minimum, maximum);
	}
}
