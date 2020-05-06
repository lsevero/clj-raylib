package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import clojure.lang.APersistentVector;

@FieldOrder({"hit","distance","position","normal"})
public class RayHitInfo extends Structure{
    public boolean hit;
    public float distance;
    public Vector3 position;
    public Vector3 normal;

    public RayHitInfo(APersistentMap map){
        super();
        Object position = map.get(Keyword.intern("position"));
        if(position == null)
            throw new IllegalArgumentException("Map needs key :position");
        if(position instanceof APersistentMap){
            this.position = new Vector3((APersistentMap)position);
        }
        else if(position instanceof APersistentVector){
            this.position = new Vector3((APersistentVector)position);
        }
        else if(position instanceof Vector3){
            this.position = new Vector3((Vector3)position);
        }
        else{
            throw new IllegalArgumentException(":position is of unsupported type");
        }

        Object normal = map.get(Keyword.intern("normal"));
        if(normal == null)
            throw new IllegalArgumentException("Map needs key :normal");
        if(normal instanceof APersistentMap){
            this.normal = new Vector3((APersistentMap)normal);
        }
        else if(normal instanceof APersistentVector){
            this.normal = new Vector3((APersistentVector)normal);
        }
        else if(normal instanceof Vector3){
            this.normal = new Vector3((Vector3)normal);
        }
        else{
            throw new IllegalArgumentException(":normal is of unsupported type");
        }
    }

    public RayHitInfo(boolean hit, float distance, Vector3 position, Vector3 normal){
        super();
        this.hit = hit;
        this.distance = distance;
        this.position = position;
        this.normal = normal;
    }

    public RayHitInfo(RayHitInfo r){
        super();
        this.hit = r.hit;
        this.distance = r.distance;
        this.position = new Vector3(r.position);
        this.normal = new Vector3(r.normal);
    }

    public RayHitInfo(){
        super();
    }
}
