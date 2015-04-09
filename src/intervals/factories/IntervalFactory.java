package intervals.factories;

import intervals.Opening;
import intervals.entities.Interval;
import intervals.utils.Point;

public abstract class IntervalFactory {

	public abstract Interval getInterval(Point minimum, Point maximum, Opening opening) ;
}
