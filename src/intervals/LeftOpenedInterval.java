package intervals;

public class LeftOpenedInterval extends Interval {
	
	protected LeftOpenedInterval(double minimum, double maximum) {
		super(minimum, maximum, Opening.LEFT_OPENED);
	}

	public Opening getOpening() {
		return Opening.LEFT_OPENED;
	}
}
