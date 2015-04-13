package intervals.utils;

import intervals.PointType;

public class ExactPoint extends Point {

	public ExactPoint(int value) {
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
