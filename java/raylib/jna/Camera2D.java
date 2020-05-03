package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector2;

@FieldOrder({"offset","target","rotation","zoom"})
public class Camera2D extends Structure{
    public Vector2 offset;
    public Vector2 target;
    public float rotation;
    public float zoom;

    public Camera2D(Vector2 offset, Vector2 target, float rotation, int zoom){
        super();
        this.offset = offset;
        this.target = target;
        this.rotation = rotation;
        this.zoom = zoom;
    }
}
