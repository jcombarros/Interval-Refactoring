package intervals.entities;

import intervals.Opening;
import intervals.PointType;
import intervals.utils.ExactPoint;
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
		this.minimum.setType(PointType.MIN);
		this.maximum = maximum;
		this.maximum.setType(PointType.MAX);
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

	public boolean includes(int value) {
		Point valuePoint = new ExactPoint(value);
		valuePoint.setType(PointType.EXACT);
		return minimum.include(valuePoint) && (maximum.include(valuePoint));
	}

	public boolean includes(Interval interval) {
		return minimum.include(interval.minimum) && maximum.include(interval.minimum) &&
				minimum.include(interval.maximum) && maximum.include(interval.maximum);
	}

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
