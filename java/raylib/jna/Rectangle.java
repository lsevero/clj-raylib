package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"x","y","width","height"})
public class Rectangle extends Structure{
    public static class ByReference extends Rectangle implements Structure.ByReference {
        public ByReference(float x, float y, float width, float height){
            super(x,y,width,height);
        }
    }

    public float x;
    public float y;
    public float width;
    public float height;

    public Rectangle(float x, float y, float width, float height){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
