package intervals.utils;

public class UntilPoint extends Point {

	public UntilPoint(int value) {
		super(value);
	}

	@Override
	public boolean include(Point point) {
		return point.includeInversion(this);
	}
	
	@Override
	protected boolean includeInversion(Point point) {
		return point.include(this);
	}

	@Override
	public boolean include(FromPoint point) {
		if(point.getValue() < this.getValue()){
			return true;
		}
		return false;	
	}

	@Override
	public boolean include(UntilPoint point) {
		if(point.getValue() <= this.getValue()){
			return true;
		}
		return false;
	}

	@Override
	public boolean include(ExactPoint point) {
		if(point.getValue() < this.getValue()){
			return true;
		}
		return false;
	}

}
