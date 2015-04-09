package intervals.entities;

import intervals.Opening;
import intervals.utils.Point;
 
public abstract class Interval {
  
	protected Point minimum;
	protected Point maximum;
	protected Opening opening;
	
	public static Interval create (Point minimum, Point maximum, Opening opening){
		throw new RuntimeException("Should not be here");
	}

	protected Interval(Point minimum, Point maximum, Opening opening) {
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
		return (maximum.getValue() + minimum.getValue()) / 2;
	}

	public abstract boolean includes(int value) ;

//	public boolean includes(Interval interval) {
//		boolean minimumIncluded = this.includes(interval.minimum);
//		boolean maximumIncluded = this.includes(interval.maximum);
//
//		return this.includesResult(interval, minimumIncluded, maximumIncluded);
//	}
//	
//	protected abstract boolean includesResult(Interval interval, boolean minimumIncluded, boolean maximumIncluded);
//
//	protected abstract boolean includesResult(LeftOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);
//
//	protected abstract boolean includesResult(RightOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);
//	
//	protected abstract boolean includesResult(BothOpenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);
//	
//	protected abstract boolean includesResult(UnopenedInterval interval, boolean minimumIncluded, boolean maximumIncluded);
//
//	public abstract boolean intersectsWith(Interval interval) ;

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
