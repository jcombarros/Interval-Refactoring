package intervals.entities;

import intervals.Opening;
 
public abstract class Interval {
 
	protected double minimum;
	protected double maximum;
	protected Opening opening;
	
	public static Interval create (double minimum, double maximum, Opening opening){
		throw new RuntimeException("Should not be here");
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

	public boolean includes(Interval interval) {
		boolean minimumIncluded = this.includes(interval.minimum);
		boolean maximumIncluded = this.includes(interval.maximum);

		return this.includesResult(interval, minimumIncluded, maximumIncluded);
	}
	
	protected abstract boolean includesResult(Interval interval, boolean minimumIncluded, boolean maximumIncluded);

	protected abstract boolean includesResult(LeftOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);

	protected abstract boolean includesResult(RightOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);
	
	protected abstract boolean includesResult(BothOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);
	
	protected abstract boolean includesResult(UnopenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);

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
