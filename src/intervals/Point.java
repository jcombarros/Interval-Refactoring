package intervals;

public abstract class Point {
	
	private int value;
	
	public Point (int value){
		this.value = value;
	}
	
	public double getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
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

}
