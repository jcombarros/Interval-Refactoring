package intervals;

public class RightOpenedIntervalFactory extends IntervalFactory {
	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		return RightOpenedInterval.create(minimum, maximum, opening);
	}
}
