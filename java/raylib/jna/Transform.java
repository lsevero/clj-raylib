package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;
import raylib.jna.Vector4;

@FieldOrder({"translation","rotation","scale"})
public class Transform extends Structure{
    public static class ByReference extends Transform implements Structure.ByReference{
        public ByReference(Vector3 translation, Vector4 rotation, Vector3 scale){
            super(translation, rotation, scale);
        }

        public ByReference(){
            super();
        }
    }

    public Vector3 translation;
    public Vector4 rotation;
    public Vector3 scale;

    public Transform(Vector3 translation, Vector4 rotation, Vector3 scale){
        super();
        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Transform(){
        super();
    }
}
