package intervals.factories;

import intervals.Opening;
import intervals.entities.Interval;
import intervals.entities.UnopenedInterval;

public class UnopenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(int minimum, int maximum, Opening opening) {
		return UnopenedInterval.create(minimum, maximum, opening);
	}
}
