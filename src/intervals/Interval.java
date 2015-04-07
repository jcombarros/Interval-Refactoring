package intervals;

public abstract class Interval {
 
	protected double minimum;
	protected double maximum;
	protected Opening opening;
	
	public static Interval create (double minimum, double maximum, Opening opening){
		switch (opening) {
		case LEFT_OPENED:
			return new LeftOpenedInterval(minimum, maximum);
		case RIGHT_OPENED:
			return new RightOpenedInterval(minimum, maximum);
		case BOTH_OPENED:
			return new BothOpenedInterval(minimum, maximum);
		case UNOPENED:
			return new UnopenedInterval(minimum, maximum);
		default:
			throw new IllegalArgumentException("Incorrect type code value");
		}
	}

	protected Interval(double minimum, double maximum, Opening opening) {
		this.minimum = minimum;
		this.maximum = maximum;
		this.opening = opening;
	}

	public Opening getOpening() {
		return opening;
	}

	public void setOpening(Opening opening) {
		this.opening = opening;
	}

	public double midPoint() {
		return (maximum + minimum) / 2;
	}

	public abstract boolean includes(double value) ;

	public abstract boolean includes(Interval interval) ;

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
