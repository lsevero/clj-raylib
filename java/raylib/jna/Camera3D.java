package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;

@FieldOrder({"position","target","up","fovy","type"})
public class Camera3D extends Structure{
    public static class ByReference extends Camera3D implements Structure.ByReference{
        public ByReference(Vector3 position, Vector3 target, Vector3 up, float fovy, int type){
            super(position, target, up, fovy, type);
        }

        public ByReference(){
            super();
        }
    }

    public Vector3 position;
    public Vector3 target;
    public Vector3 up;
    public float fovy;
    public int type;

    public Camera3D(Vector3 position, Vector3 target, Vector3 up, float fovy, int type){
        super();
        this.position = position;
        this.target = target;
        this.up = up;
        this.fovy = fovy;
        this.type = type;
    }

    public Camera3D(){
        super();
    }
}
