package intervals;

public class RightOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(double minimum, double maximum, Opening opening) {
		return RightOpenedInterval.create(minimum, maximum, opening);
	}
}
