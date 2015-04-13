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

	public abstract boolean include(Point point);
	
	protected abstract boolean includeInversion(Point point);
	
	public abstract boolean include(FromPoint point);
	
	public abstract boolean include(UntilPoint point);
	
	public abstract boolean include(ExactPoint point);

}
