package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;

@FieldOrder({"min","max"})
public class BoundingBox extends Structure{
    public Vector3 min;
    public Vector3 max;

    public BoundingBox(Vector3 min, Vector3 max){
        super();
        this.min = min;
        this.max = max;
    }
}
