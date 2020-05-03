package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import clojure.lang.APersistentVector;

@FieldOrder({"min","max"})
public class BoundingBox extends Structure{
    public Vector3 min;
    public Vector3 max;

    public BoundingBox(Vector3 min, Vector3 max){
        super();
        this.min = min;
        this.max = max;
    }

    public BoundingBox(APersistentMap map){
        super();
        Object min = map.get(Keyword.intern("min"));
        if(min == null)
            throw new IllegalArgumentException("Map needs key :min");
        if(min instanceof APersistentMap){
            this.min = new Vector3((APersistentMap)min);
        }
        else if(min instanceof APersistentVector){
            this.min = new Vector3((APersistentVector)min);
        }
        else{
            throw new IllegalArgumentException(":min is of unsupported type");
        }
        Object max = map.get(Keyword.intern("max"));
        if(max == null)
            throw new IllegalArgumentException("Map needs key :max");
        if(max instanceof APersistentMap){
            this.max = new Vector3((APersistentMap)max);
        }
        else if(max instanceof APersistentVector){
            this.max = new Vector3((APersistentVector)max);
        }
        else{
            throw new IllegalArgumentException(":max is of unsupported type");
        }
    }


    public BoundingBox(){
        super();
    }
}
