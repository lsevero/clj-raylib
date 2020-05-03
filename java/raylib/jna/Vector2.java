package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"x","y"})
public class Vector2 extends Structure{
    public static class ByReference extends Vector2 implements Structure.ByReference{
        public ByReference(float x, float y){
            super(x,y);
        }

        public ByReference(){
            super();
        }
    }

    public float x;
    public float y;

    public Vector2(float x, float y){
        super();
        this.x = x;
        this.y = y;
    }

    public Vector2(){
        super();
    }
}
