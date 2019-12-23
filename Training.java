package kNearestNeighbors;

public class Training {
	double sepLen, sepWidth, petalLen, petalWidth;
	String type;

	public Training(double newX, double newY, double newZ, double newW, String newType) {
		sepLen = newX;
		sepWidth = newY;
		petalLen = newZ;
		petalWidth = newW;
		type = newType;
	}

	/**
	 * @return the x
	 */
	public double getSepLen() {
		return sepLen;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setSepLen(double len) {
		this.sepLen = len;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return sepWidth;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setSepWidth(double w) {
		this.sepWidth = w;
	}

	/**
	 * @return the z
	 */
	public double getPetalLen() {
		return petalLen;
	}

	/**
	 * @param z
	 *            the z to set
	 */
	public void setPetalLen(double len) {
		this.petalLen = len;
	}

	/**
	 * @return the w
	 */
	public double getPetalWidth() {
		return petalWidth;
	}

	/**
	 * @param w
	 *            the w to set
	 */
	public void setPetalWidth(double w) {
		this.petalWidth = w;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "Sepal length: " + sepLen + " Sepal width: " + sepWidth + " Petal length: " + petalLen + " Petal width: "
				+ petalWidth + " Type: " + type;
	}

}

