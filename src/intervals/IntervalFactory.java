package intervals;


public class IntervalFactory {

	public static Interval getInterval(double minimum, double maximum, Opening opening) {
		return new Interval(minimum, maximum, opening);
	}
}
