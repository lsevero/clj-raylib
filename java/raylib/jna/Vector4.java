package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"x","y","z","w"})
public class Vector4 extends Structure{
    public static class ByReference extends Vector4 implements Structure.ByReference{
        public ByReference(float x, float y, float z, float w){
            super(x,y,z,w);
        }

        public ByReference(){
            super();
        }
    }

    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4(float x, float y, float z, float w){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(){
        super();
    }
}
