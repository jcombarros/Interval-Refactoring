package intervals;

public class UnopenedInterval extends Interval {

	protected UnopenedInterval(double minimum, double maximum) {
		super(minimum, maximum, Opening.UNOPENED);
	}

	public Opening getOpening() {
		return Opening.UNOPENED;
	}
}
