package intervals;

public class LeftOpenedInterval extends Interval {
	
	protected LeftOpenedInterval(double minimum, double maximum) {
		super(minimum, maximum, Opening.LEFT_OPENED);
	}

	public Opening getOpening() {
		return Opening.LEFT_OPENED;
	}
	
	public boolean includes(double value) {
		return minimum < value && value <= maximum;
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
				return (minimumIncluded)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded)
						&& (maximumIncluded || maximum == interval.maximum);
			default:
				assert false;
				return false;
		}	
	}
}
