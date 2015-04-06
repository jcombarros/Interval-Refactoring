package intervals;

public class BothOpenedInterval extends Interval {

	protected BothOpenedInterval(double minimum, double maximum) {
		super(minimum, maximum, Opening.BOTH_OPENED);
	}

	public Opening getOpening() {
		return Opening.BOTH_OPENED;
	}
}
