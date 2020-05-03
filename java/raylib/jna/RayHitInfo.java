package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;

@FieldOrder({"hit","distance","position","normal"})
public class RayHitInfo extends Structure{
    public boolean hit;
    public float distance;
    public Vector3 position;
    public Vector3 normal;

    public RayHitInfo(boolean hit, float distance, Vector3 position, Vector3 normal){
        super();
        this.hit = hit;
        this.distance = distance;
        this.position = position;
        this.normal = normal;
    }

    public RayHitInfo(){
        super();
    }
}
