package intervals.utils;

import intervals.PointType;

public abstract class Point {
	
	private int value;
	
	private PointType type;
	
	public Point (int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public PointType getType(){
		return this.type;
	}
	
	public void setType(PointType type){
		this.type = type;
	}
	
	public abstract boolean greaterThan(Point point);
	
	public abstract boolean lessThan(Point point);
	
	public abstract boolean equalTo(Point point);
	
	public abstract boolean greaterThan(FromPoint point);
	
	public abstract boolean lessThan(FromPoint point);
	
	public abstract boolean equalTo(FromPoint point);
	
	public abstract boolean greaterThan(UntilPoint point);
	
	public abstract boolean lessThan(UntilPoint point);
	
	public abstract boolean equalTo(UntilPoint point);
	
	public abstract boolean greaterThan(ExactPoint point);
	
	public abstract boolean lessThan(ExactPoint point);
	
	public abstract boolean equalTo(ExactPoint point);
	
	
	public abstract boolean include(Point point);
	
	public abstract boolean include(FromPoint point);
	
	public abstract boolean include(UntilPoint point);
	
	public abstract boolean include(ExactPoint point);

}
