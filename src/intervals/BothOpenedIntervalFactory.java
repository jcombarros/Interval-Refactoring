package intervals;

public class BothOpenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(double minimum, double maximum, Opening opening) {
		return BothOpenedInterval.create(minimum, maximum, opening);
	}
}
