package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector2;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import clojure.lang.APersistentVector;

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

    public Camera2D(APersistentMap map){
        super();
        Object offset = map.get(Keyword.intern("offset"));
        if(offset == null)
            throw new IllegalArgumentException("Map needs key :offset");
        if(offset instanceof APersistentMap){
            this.offset = new Vector2((APersistentMap)offset);
        }
        else if(offset instanceof APersistentVector){
            this.offset = new Vector2((APersistentVector)offset);
        }
        else{
            throw new IllegalArgumentException(":offset is of unsupported type");
        }
        Object target = map.get(Keyword.intern("target"));
        if(target == null)
            throw new IllegalArgumentException("Map needs key :target");
        if(target instanceof APersistentMap){
            this.target = new Vector2((APersistentMap)target);
        }
        else if(target instanceof APersistentVector){
            this.target = new Vector2((APersistentVector)target);
        }
        else{
            throw new IllegalArgumentException(":target is of unsupported type");
        }
        Number rotation = (Number)map.get(Keyword.intern("rotation"));
        if(rotation == null)
            throw new IllegalArgumentException("Map needs key :rotation");
        this.rotation = rotation.floatValue();
        Number zoom = (Number)map.get(Keyword.intern("zoom"));
        if(zoom == null)
            throw new IllegalArgumentException("Map needs key :zoom");
        this.zoom = zoom.floatValue();
    }

    public Camera2D(){
        super();
    }
}
