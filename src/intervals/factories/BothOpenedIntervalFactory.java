package intervals.factories;

import intervals.Opening;
import intervals.entities.BothOpenedInterval;
import intervals.entities.Interval;
import intervals.utils.Point;

public class BothOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(Point minimum, Point maximum, Opening opening) {
		return BothOpenedInterval.create(minimum, maximum, opening);
	}
}
