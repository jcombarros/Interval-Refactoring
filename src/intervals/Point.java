package intervals;

public class Point {
	
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
	
	public boolean greaterThan(Point point){
		return this.value > point.value;
	}
	
	public boolean lessThan(Point point){
		return this.value < point.value;
	}
	
	public boolean equalTo(Point point){
		return this.value == point.value;
	}

}
