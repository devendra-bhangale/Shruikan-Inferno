package shruikan.framework;



public class Collision {

	public final int OUT_LEFT		= 1;
	public final int OUT_TOP		= 2;
	public final int OUT_RIGHT		= 4;
	public final int OUT_BOTTOM		= 8;

	
	
	public boolean line_rectangle(float lx0, float ly0, float lx1, float ly1, float rx0, float ry0, float rWidth, float rHeight) {
		
		int out1, out2;
		
		if ((out2 = outcode(lx1, ly1, rx0, ry0, rWidth, rHeight)) == 0) {
			return true;
		}
		
		while ((out1 = outcode(lx0, ly0, rx0, ry0, rWidth, rHeight)) != 0) {
			
			if ((out1 & out2) != 0) {
				return false;
			}
			
			if ((out1 & (OUT_LEFT | OUT_RIGHT)) != 0) {
				
				float x = rx0;
				
				if ((out1 & OUT_RIGHT) != 0) {
					x += rWidth;
				}
				
				ly0 = ly0 + (x - lx0) * (ly1 - ly0) / (lx1 - lx0);
				lx0 = x;
			} 
			else {
			
				float y = ry0;
				
				if ((out1 & OUT_BOTTOM) != 0) {
					y += rHeight;
				}
				
				lx0 = lx0 + (y - ly0) * (lx1 - lx0) / (ly1 - ly0);
				ly0 = y;
			}
		}
		
		return true;
	}


	
	private int outcode(float pX, float pY, float rectX, float rectY, float rectWidth, float rectHeight) {
		
		int out = 0;
		
		if (rectWidth <= 0) {
			out |= OUT_LEFT | OUT_RIGHT;
		}
		else if (pX < rectX) {
			out |= OUT_LEFT;
		} 
		else if (pX > rectX + rectWidth) {
			out |= OUT_RIGHT;
		}
		
		if (rectHeight <= 0) {
			out |= OUT_TOP | OUT_BOTTOM;
		} 
		else if (pY < rectY) {
			out |= OUT_TOP;
		} 
		else if (pY > rectY + rectHeight) {
			out |= OUT_BOTTOM;
		}
		
		return out;
	}
	
	
	
	public boolean line_triangle(float p0x, float p0y, float p1x, float p1y, float t0x, float t0y, float t1x, float t1y, float t2x, float t2y)			//(vec2 p0, vec2 p1, vec2 t0, vec2 t1, vec2 t2)
	{
		vec2 p0 = new vec2(p0x, p0y);				
		vec2 p1 = new vec2(p1x, p1y);				
		
		vec2 t0 = new vec2(t0x, t0y);								
		vec2 t1 = new vec2(t1x, t1y);				
		vec2 t2 = new vec2(t2x, t2y);
		
		
	    /* Check whether segment is outside one of the three half-planes
	     * delimited by the triangle. */
	    float f1 = Side(p0, t2, t0, t1), f2 = Side(p1, t2, t0, t1);
	    float f3 = Side(p0, t0, t1, t2), f4 = Side(p1, t0, t1, t2);
	    float f5 = Side(p0, t1, t2, t0), f6 = Side(p1, t1, t2, t0);
	    /* Check whether triangle is totally inside one of the two half-planes
	     * delimited by the segment. */
	    float f7 = Side(t0, t1, p0, p1);
	    float f8 = Side(t1, t2, p0, p1);

	    /* If segment is strictly outside triangle, or triangle is strictly
	     * apart from the line, we're not intersecting */
	    if ((f1 < 0 && f2 < 0) || (f3 < 0 && f4 < 0) || (f5 < 0 && f6 < 0)
	          || (f7 > 0 && f8 > 0))
	        return false;		//NOT_INTERSECTING;

	    /* If segment is aligned with one of the edges, we're overlapping */
	    if ((f1 == 0 && f2 == 0) || (f3 == 0 && f4 == 0) || (f5 == 0 && f6 == 0))
	        return true;		//OVERLAPPING;

	    /* If segment is outside but not strictly, or triangle is apart but
	     * not strictly, we're touching */
	    if ((f1 <= 0 && f2 <= 0) || (f3 <= 0 && f4 <= 0) || (f5 <= 0 && f6 <= 0)
	          || (f7 >= 0 && f8 >= 0))
	        return true;		//TOUCHING;

	    /* If both segment points are strictly inside the triangle, we
	     * are not intersecting either */
	    if (f1 > 0 && f2 > 0 && f3 > 0 && f4 > 0 && f5 > 0 && f6 > 0)
	        return false;		//NOT_INTERSECTING;

	    /* Otherwise we're intersecting with at least one edge */
	    return true;			//INTERSECTING;
	}
	
	
	
	/* Check whether P and Q lie on the same side of line AB */
	public float Side(vec2 p, vec2 q, vec2 a, vec2 b)
	{
	    float z1 = (b.x - a.x) * (p.y - a.y) - (p.x - a.x) * (b.y - a.y);
	    float z2 = (b.x - a.x) * (q.y - a.y) - (q.x - a.x) * (b.y - a.y);
	    return z1 * z2;
	}
	
	
	
	//**********NESTED CLASS********** 
	private class vec2 {

		float x;
		float y;
		
		public vec2(float x, float y){
			
			this.x = x;
			this.y = y;
		}
	}

}
