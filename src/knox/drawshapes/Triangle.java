package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape {
	
	int base;
	//int center;

	public Triangle(Point tip, int base, Color color) {
		super(tip, color);
        boundingBox = new BoundingBox(tip.x - base/2, tip.x + base/2, tip.y - base/2, tip.y + base/2);
        this.base = base;
	}

	@Override
    public void draw(Graphics g) {
        if (isSelected()){
            g.setColor(getColor().darker());
        } else {
            g.setColor(getColor());
        }
        g.fillRect((int)getAnchorPoint().getX() - base/2,
                (int)getAnchorPoint().getY() - base/2,
                base,
                base);
    }
	 public String toString() {
	        return String.format("TRIANGLE %d %d %d %s %s", 
	                this.getAnchorPoint().x, 
	                this.getAnchorPoint().y,
	                this.base,
	                Util.colorToString(this.getColor()),
	                this.isSelected());
	    }

	@Override
	public void scale(double d) {
		this.base = (int)(d*this.base);	
	}

}
