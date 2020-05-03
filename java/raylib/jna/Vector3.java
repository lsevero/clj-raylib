package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"x","y","z"})
public class Vector3 extends Structure{
    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
