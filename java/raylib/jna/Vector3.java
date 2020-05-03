package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"x","y","z"})
public class Vector3 extends Structure{
    public static class ByReference extends Vector3 implements Structure.ByReference{
        public ByReference(float x, float y, float z){
            super(x,y,z);
        }

        public ByReference(){
            super();
        }
    }

    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(){
        super();
    }
}
