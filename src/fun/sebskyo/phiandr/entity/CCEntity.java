package fun.sebskyo.phiandr.entity;

abstract class CCEntity extends Entity {
	protected float xCenter, yCenter, length, angle;
	protected int diameter;

	public CCEntity(float x, float y, int diameter, float xCenter, float yCenter, float length, float angle) {
		super(x, y, diameter, diameter);
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.length = length;
		this.angle = angle;
		this.diameter = diameter;
	}

	public float getxCenter() {
		return xCenter;
	}

	public float getyCenter() {
		return yCenter;
	}

	public float getLength() {
		return length;
	}

	public float getAngle() {
		return angle;
	}
}
