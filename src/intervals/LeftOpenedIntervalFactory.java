package intervals;

public class LeftOpenedIntervalFactory extends IntervalFactory {
	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		return LeftOpenedInterval.create(minimum, maximum, opening);
	}
}
