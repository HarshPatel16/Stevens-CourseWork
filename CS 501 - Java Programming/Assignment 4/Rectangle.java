

public class Rectangle {
	double width;	// Width of rectangle
	double height;	// Height of rectangle

	/* A no-arg constructor that creates a default rectangle */
	Rectangle() {
		width = 1;
		height = 1;
	} 
	boolean isValid(double width, double height) {
		if(width<=0 || height<=0)
			return false;
		else
			return true;
	}
	 
	/* A constructor that creates a rectangle 
	    with the specified width and height    */
	Rectangle(double newWidth, double newHeight) throws Exception{
		if(isValid(newWidth,newHeight)){
		width = newWidth;
		height = newHeight;
		}
		else {
			
			Exception e = new Exception("Not Valid Parameters");
			throw e;
		}
	}
	/* Return the area of this rectangle */
	double getArea() {
		return width * height; 
	}

	/* Return the perimeter of this rectangle */
	double getPerimeter() {
		return 2 * (width + height);
	}
}
