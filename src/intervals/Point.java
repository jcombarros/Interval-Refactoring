package intervals;

public class Point {
	
	private double value;
	
	public Point (double value){
		this.value = value;
	}
	
	public double getValue(){
		return this.value;
	}
	
	public void setValue(double value){
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
