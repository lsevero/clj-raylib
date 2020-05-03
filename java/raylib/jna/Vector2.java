package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"x","y"})
public class Vector2 extends Structure{
    public float x;
    public float y;

    public Vector2(float x, float y){
        super();
        this.x = x;
        this.y = y;
    }
}
