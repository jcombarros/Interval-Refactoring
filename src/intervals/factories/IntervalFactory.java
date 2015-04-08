package intervals.factories;

import intervals.Opening;
import intervals.entities.Interval;

public abstract class IntervalFactory {

	public abstract Interval getInterval(int minimum, int maximum, Opening opening) ;
}
