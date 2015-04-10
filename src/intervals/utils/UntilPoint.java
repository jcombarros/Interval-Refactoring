package intervals.utils;

public class UntilPoint extends Point {

	public UntilPoint(int value) {
		super(value);
	}

	@Override
	public boolean greaterThan(Point point) {
		return point.lessThan(this);
	}

	@Override
	public boolean lessThan(Point point) {
		return point.greaterThan(this);
	}

	@Override
	public boolean equalTo(Point point) {
		return point.equalTo(this);
	}

	@Override
	public boolean greaterThan(FromPoint point) {
		return this.getValue() > point.getValue();
	}

	@Override
	public boolean lessThan(FromPoint point) {
		return this.getValue() <= point.getValue();
	}

	@Override
	public boolean equalTo(FromPoint point) {
		return this.getValue() == point.getValue();
	}

	@Override
	public boolean greaterThan(UntilPoint point) {
		return this.getValue() > point.getValue();
	}

	@Override
	public boolean lessThan(UntilPoint point) {
		return this.getValue() < point.getValue();
	}

	@Override
	public boolean equalTo(UntilPoint point) {
		return this.getValue() == point.getValue();
	}

	@Override
	public boolean greaterThan(ExactPoint point) {
		return this.getValue() > point.getValue();
	}

	@Override
	public boolean lessThan(ExactPoint point) {
		return this.getValue() <= point.getValue();
	}

	@Override
	public boolean equalTo(ExactPoint point) {
		return this.getValue() == point.getValue();
	}
	
	
	@Override
	public boolean include(Point point) {
		return !point.include(this);
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
