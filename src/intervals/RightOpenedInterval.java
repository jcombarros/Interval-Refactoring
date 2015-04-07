package intervals;

public class RightOpenedInterval extends Interval {
	
	protected RightOpenedInterval(double minimum, double maximum) {
		super(minimum, maximum, Opening.RIGHT_OPENED);
	}

	public Opening getOpening() {
		return Opening.RIGHT_OPENED;
	}
	
	public boolean includes(double value) {
		return minimum <= value && value < maximum;
	}
}
