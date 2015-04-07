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

	public abstract boolean intersectsWith(Interval interval) ;

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
