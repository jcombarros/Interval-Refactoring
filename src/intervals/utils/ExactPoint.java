package intervals.utils;

import intervals.PointType;

public class ExactPoint extends Point {

	public ExactPoint(int value) {
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
		// TODO Auto-generated method stub
		return this.getValue() <= point.getValue();
	}

	@Override
	public boolean equalTo(FromPoint point) {
		return this.getValue() == point.getValue();
	}

	@Override
	public boolean greaterThan(UntilPoint point) {
		return this.getValue() >= point.getValue();
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
		return this.getValue() < point.getValue();
	}

	@Override
	public boolean equalTo(ExactPoint point) {
		return this.getValue() == point.getValue();
	}
	
	
	@Override
	public boolean include(Point point) {
		return point.include(this);
	}

	@Override
	public boolean include(FromPoint point) {
		if(this.getType() == PointType.EXACT && point.getType() != PointType.EXACT){
			return point.include(this);
		}
		if((this.getType() == PointType.MIN && point.getValue() >= this.getValue()) ||
				(this.getType() == PointType.MAX && point.getValue() < this.getValue())){
			return true;
		}
		return false;
	}

	@Override
	public boolean include(UntilPoint point) {
		if(this.getType() == PointType.EXACT && point.getType() != PointType.EXACT){
			return point.include(this);
		}
		if((this.getType() == PointType.MIN && point.getValue() > this.getValue()) ||
				(this.getType() == PointType.MAX && point.getValue() <= this.getValue())){
			return true;
		}
		return false;
	}

	@Override
	public boolean include(ExactPoint point) {
		if(this.getType() == PointType.EXACT && point.getType() != PointType.EXACT){
			return point.include(this);
		}
		if((this.getType() == PointType.MIN && point.getValue() >= this.getValue()) ||
				(this.getType() == PointType.MAX && point.getValue() <= this.getValue())){
			return true;
		}
		return false;
	}

}
