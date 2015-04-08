package intervals.factories;

import intervals.Opening;
import intervals.entities.Interval;
import intervals.entities.RightOpenedInterval;

public class RightOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(double minimum, double maximum, Opening opening) {
		return RightOpenedInterval.create(minimum, maximum, opening);
	}
}
