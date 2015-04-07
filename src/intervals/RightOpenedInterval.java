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
	
	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);

		switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded);
			default:
				assert false;
				return false;
		}
	}
	
	public boolean intersectsWith(Interval interval) {
		if (maximum == interval.minimum) {
			return false;
		}
		return this.includes(interval.minimum) || this.includes(interval.maximum);
	}
}
