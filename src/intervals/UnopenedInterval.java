package intervals;

public class UnopenedInterval extends Interval {

	protected UnopenedInterval(double minimum, double maximum) {
		super(minimum, maximum, Opening.UNOPENED);
	}

	public Opening getOpening() {
		return Opening.UNOPENED;
	}
	
	public boolean includes(double value) {
		return minimum <= value && value <= maximum;
	}
	
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		
		switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case RIGHT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			default:
				assert false;
				return false;
		}
	}
}
