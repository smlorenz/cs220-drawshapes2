package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape {
	
	int bottom = 3;
	int base;
//	int[] x = {75, 150, 225};
//	int[] y = {125, 50, 125};

	public Triangle(Color color, int base, Point p) {
		super(p, color);
        boundingBox = new BoundingBox(p.x, p.x+base, p.y-base, p.y); //
        this.base = base;
	}

	@Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        int[] x = {getAnchorPoint().x, getAnchorPoint().x+base/2,  getAnchorPoint().x+base}; //change order
    	int[] y = {getAnchorPoint().y, getAnchorPoint().y-base, getAnchorPoint().y};
        //g.drawPolygon(x, y, bottom);
        g.fillPolygon(x, y, 3);
        System.out.println(getAnchorPoint().x);
        System.out.println(getAnchorPoint().y);
    }
	 public String toString() {
	        return String.format("TRIANGLE %d %d %d %s %s", 
	                this.getAnchorPoint().x, 
	                this.getAnchorPoint().y,
	                this.bottom,
	                Util.colorToString(this.getColor()),
	                this.isSelected());
	    }

	@Override
	public void scale(double d) {
		this.base = (int)(d*this.base);	
	}

}
