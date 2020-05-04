package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import clojure.lang.APersistentVector;

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

    public Camera3D(APersistentMap map){
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
        Object target = map.get(Keyword.intern("target"));
        if(target == null)
            throw new IllegalArgumentException("Map needs key :target");
        if(target instanceof APersistentMap){
            this.target = new Vector3((APersistentMap)target);
        }
        else if(target instanceof APersistentVector){
            this.target = new Vector3((APersistentVector)target);
        }
        else if(target instanceof Vector3){
            this.target = new Vector3((Vector3)target);
        }
        else{
            throw new IllegalArgumentException(":target is of unsupported type");
        }
        Object up = map.get(Keyword.intern("up"));
        if(up == null)
            throw new IllegalArgumentException("Map needs key :up");
        if(up instanceof APersistentMap){
            this.up = new Vector3((APersistentMap)up);
        }
        else if(up instanceof APersistentVector){
            this.up = new Vector3((APersistentVector)up);
        }
        else if(up instanceof Vector3){
            this.up = new Vector3((Vector3)up);
        }
        else{
            throw new IllegalArgumentException(":up is of unsupported type");
        }
        Number fovy = (Number)map.get(Keyword.intern("fovy"));
        if(fovy == null)
            throw new IllegalArgumentException("Map needs key :fovy");
        this.fovy = fovy.floatValue();
        Number type = (Number)map.get(Keyword.intern("type"));
        if(type == null)
            throw new IllegalArgumentException("Map needs key :type");
        this.type = type.intValue();
    }

    public Camera3D(){
        super();
    }
}
