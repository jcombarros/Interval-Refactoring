package intervals;

public class UnopenedIntervalFactory extends IntervalFactory {
	public Interval getInterval(double minimum, double maximum, Opening opening) {
		return UnopenedInterval.create(minimum, maximum, opening);
	}
}
