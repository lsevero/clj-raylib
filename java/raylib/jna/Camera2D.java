package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector2;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import clojure.lang.APersistentVector;

@FieldOrder({"offset","target","rotation","zoom"})
public class Camera2D extends Structure{
    public static class ByValue extends Camera2D implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(Vector2 offset, Vector2 target, float rotation, float zoom){
            super(offset, target, rotation, zoom);
        }

        public ByValue(Object obj){
            super(obj);
        }
    }

    public Vector2 offset;
    public Vector2 target;
    public float rotation;
    public float zoom;

    public Camera2D(Vector2 offset, Vector2 target, float rotation, float zoom){
        super();
        this.offset = offset;
        this.target = target;
        this.rotation = rotation;
        this.zoom = zoom;
    }

    public Camera2D(Camera2D c2d){
        super();
        this.offset = new Vector2(c2d.offset);
        this.target = new Vector2(c2d.target);
        this.rotation = c2d.rotation;
        this.zoom = c2d.zoom;
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
        else if(offset instanceof Vector2){
            this.offset = new Vector2((Vector2)offset);
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
        else if(target instanceof Vector2){
            this.target = new Vector2((Vector2)target);
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

    public Camera2D(Object obj){
        super();
        if(obj instanceof Camera2D){
            Camera2D c2d = (Camera2D)obj;
            this.offset = new Vector2(c2d.offset);
            this.target = new Vector2(c2d.target);
            this.rotation = c2d.rotation;
            this.zoom = c2d.zoom;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Object offset = map.get(Keyword.intern("offset"));
            if(offset == null)
                throw new IllegalArgumentException("Map needs key :offset");
            if(offset instanceof APersistentMap){
                this.offset = new Vector2((APersistentMap)offset);
            }
            else if(offset instanceof APersistentVector){
                this.offset = new Vector2((APersistentVector)offset);
            }
            else if(offset instanceof Vector2){
                this.offset = new Vector2((Vector2)offset);
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
            else if(target instanceof Vector2){
                this.target = new Vector2((Vector2)target);
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
        }else{
            throw new IllegalArgumentException("obj of unsupported type "+obj);
        }
    }

    public Camera2D(){
        super();
    }
}
