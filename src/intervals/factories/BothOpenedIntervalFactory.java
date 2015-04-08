package intervals.factories;

import intervals.Opening;
import intervals.entities.BothOpenedInterval;
import intervals.entities.Interval;

public class BothOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(double minimum, double maximum, Opening opening) {
		return BothOpenedInterval.create(minimum, maximum, opening);
	}
}
