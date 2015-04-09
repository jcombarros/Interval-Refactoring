package intervals.factories;

import intervals.Opening;
import intervals.entities.Interval;
import intervals.entities.UnopenedInterval;
import intervals.utils.Point;

public class UnopenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(Point minimum, Point maximum, Opening opening) {
		return UnopenedInterval.create(minimum, maximum, opening);
	}
}
