package intervals.factories;

import intervals.Opening;
import intervals.entities.Interval;
import intervals.entities.LeftOpenedInterval;

public class LeftOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(int minimum, int maximum, Opening opening) {
		return LeftOpenedInterval.create(minimum, maximum, opening);
	}
}
