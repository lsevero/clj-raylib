package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;

@FieldOrder({"position","direction"})
public class Ray extends Structure{
    public Vector3 position;
    public Vector3 direction;

    public Ray(Vector3 position, Vector3 direction){
        super();
        this.position = position;
        this.direction = direction;
    }

    public Ray(){
        super();
    }
}
