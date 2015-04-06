package intervals;

public class Interval {

	private double minimum;
	private double maximum;
	private Opening opening;

	public Interval(double minimum, double maximum, Opening opening) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.opening = opening;
	}

	public double midPoint() {
		return (maximum + minimum) / 2;
	}

	public boolean includes(double value) {
		switch (opening) {
		case BOTH_OPENED:
			return minimum < value && value < maximum;
		case LEFT_OPENED:
			return minimum < value && value <= maximum;
		case RIGHT_OPENED:
			return minimum <= value && value < maximum;
		case UNOPENED:
			return minimum <= value && value <= maximum;
		default:
			assert false;
			return false;
		}
	}

	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);
		switch (opening) {
		case BOTH_OPENED:
			switch (interval.opening) {
			case BOTH_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded || maximum == interval.maximum);
			case LEFT_OPENED:
				return (minimumIncluded || minimum == interval.minimum)
						&& (maximumIncluded);
			case RIGHT_OPENED:
				return (minimumIncluded)
						&& (maximumIncluded || maximum == interval.maximum);
			case UNOPENED:
				return (minimumIncluded) && (maximumIncluded);
			default:
				assert false;
				return false;
			}
		case LEFT_OPENED:
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
		case RIGHT_OPENED:
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
		case UNOPENED:
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
		default:
			assert false;
			return false;
		}
	}

	public boolean intersectsWith(Interval interval) {
		if (minimum == interval.maximum) {
			switch (opening) {
			case BOTH_OPENED:
			case LEFT_OPENED:
				return false;
			case RIGHT_OPENED:
			case UNOPENED:
				return interval.opening == Opening.LEFT_OPENED ||
						interval.opening == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		if (maximum == interval.minimum) {
			switch (opening) {
			case BOTH_OPENED:
			case RIGHT_OPENED:
				return false;
			case LEFT_OPENED:
			case UNOPENED:
				return interval.opening == Opening.RIGHT_OPENED ||
						interval.opening == Opening.UNOPENED;
			default:
				assert false;
				return false;
			}
		}
		return this.includes(interval.minimum)
				|| this.includes(interval.maximum);
	}

	@Override
	public String toString() {
		// TODO
		return null;
	}

	@Override
	public boolean equals(Object object) {
		// TODO
		return false;
	}

}
