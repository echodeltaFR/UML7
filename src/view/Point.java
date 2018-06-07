package view;

/**
 * Class that represents a cartesian point
 * @author Charly Courilleau
 *
 */
public class Point {

	/** x coordinate **/
	private int x;
	
	/** y coordinate **/
	private int y;
	
	/**
	 * Constructor 
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Method that returns the x coordinate
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Method that sets the x coordinate
	 * @param x the new x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Method that returns the y coordinate
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Method that sets the y coordinate
	 * @param y the new y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
