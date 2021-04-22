package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape {
	
	int bottom = 3;
	int base;
	int[] x = {75, 150, 225};
	int[] y = {125, 50, 125};

	public Triangle(Point tip, Color color, int base) {
		super(tip, color);
        boundingBox = new BoundingBox(tip.y+base, tip.y-base, tip.x-base/2, tip.x+base/2);
        this.base = base;
	}

	@Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        //g.drawPolygon(x, y, bottom);
        g.fillPolygon(x, y, bottom);
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
		this.bottom = (int)(d*this.bottom);	
	}

}
