package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import clojure.lang.APersistentVector;

@FieldOrder({"position","direction"})
public class Ray extends Structure{
    public static class ByValue extends Ray implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }
        
        public ByValue(Vector3 position, Vector3 direction){
            super(position, direction);
        }
    }
    public Vector3 position;
    public Vector3 direction;

    public Ray(APersistentMap map){
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

        Object direction = map.get(Keyword.intern("direction"));
        if(direction == null)
            throw new IllegalArgumentException("Map needs key :direction");
        if(direction instanceof APersistentMap){
            this.direction = new Vector3((APersistentMap)direction);
        }
        else if(direction instanceof APersistentVector){
            this.direction = new Vector3((APersistentVector)direction);
        }
        else if(direction instanceof Vector3){
            this.direction = new Vector3((Vector3)direction);
        }
        else{
            throw new IllegalArgumentException(":direction is of unsupported type");
        }
    }

    public Ray(Vector3 position, Vector3 direction){
        super();
        this.position = position;
        this.direction = direction;
    }

    public Ray(Ray r){
        super();
        this.position = new Vector3(r.position);
        this.direction = new Vector3(r.direction);
    }

    public Ray(){
        super();
    }
}
