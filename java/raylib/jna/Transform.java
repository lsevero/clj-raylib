package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Vector3;
import raylib.jna.Vector4;
import clojure.lang.APersistentMap;
import clojure.lang.APersistentVector;
import clojure.lang.Keyword;

@FieldOrder({"translation","rotation","scale"})
public class Transform extends Structure{
    public static class ByReference extends Transform implements Structure.ByReference{
        public ByReference(Vector3 translation, Vector4 rotation, Vector3 scale){
            super(translation, rotation, scale);
        }

        public ByReference(){
            super();
        }

        public ByReference(ByReference br){
            super((Transform)br);
        }
        public ByReference(ByValue br){
            super((Transform)br);
        }

        public ByReference(APersistentMap map){
            super(map);
        }
        public ByReference(Object obj){
            super(obj);
        }
    }
    public static class ByValue extends Transform implements Structure.ByValue{
        public ByValue(Vector3 translation, Vector4 rotation, Vector3 scale){
            super(translation, rotation, scale);
        }

        public ByValue(){
            super();
        }

        public ByValue(ByReference br){
            super((Transform)br);
        }

        public ByValue(APersistentMap map){
            super(map);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }


    public Vector3 translation;
    public Vector4 rotation;
    public Vector3 scale;

    public Transform(Vector3 translation, Vector4 rotation, Vector3 scale){
        super();
        this.translation = translation;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Transform(APersistentMap map){
        super();
        Object translation = map.get(Keyword.intern("translation"));
        if(translation == null)
            throw new IllegalArgumentException("Map needs key :translation");
        if(translation instanceof APersistentMap){
            this.translation = new Vector3((APersistentMap)translation);
        }
        else if(translation instanceof APersistentVector){
            this.translation = new Vector3((APersistentVector)translation);
        }
        else if(translation instanceof Vector3){
            this.translation = new Vector3((Vector3)translation);
        }
        else{
            throw new IllegalArgumentException(":translation is of unsupported type");
        }

        Object rotation = map.get(Keyword.intern("rotation"));
        if(rotation == null)
            throw new IllegalArgumentException("Map needs key :rotation");
        if(rotation instanceof APersistentMap){
            this.rotation = new Vector4((APersistentMap)rotation);
        }
        else if(rotation instanceof APersistentVector){
            this.rotation = new Vector4((APersistentVector)rotation);
        }
        else if(rotation instanceof Vector4){
            this.rotation = new Vector4((Vector4)rotation);
        }
        else{
            throw new IllegalArgumentException(":rotation is of unsupported type");
        }

        Object scale = map.get(Keyword.intern("scale"));
        if(scale == null)
            throw new IllegalArgumentException("Map needs key :scale");
        if(scale instanceof APersistentMap){
            this.scale = new Vector3((APersistentMap)scale);
        }
        else if(scale instanceof APersistentVector){
            this.scale = new Vector3((APersistentVector)scale);
        }
        else if(scale instanceof Vector3){
            this.scale = new Vector3((Vector3)scale);
        }
        else{
            throw new IllegalArgumentException(":scale is of unsupported type");
        }

    }

    public Transform(Transform t){
        super();
        this.translation = new Vector3(t.translation);
        this.rotation = new Vector4(t.rotation);
        this.scale = new Vector3(t.scale);
    }

    public Transform(Object obj) throws IllegalArgumentException{
        super();
        if(obj instanceof Transform){
            Transform t = (Transform)obj;
            this.translation = new Vector3(t.translation);
            this.rotation = new Vector4(t.rotation);
            this.scale = new Vector3(t.scale);
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Object translation = map.get(Keyword.intern("translation"));
            if(translation == null)
                throw new IllegalArgumentException("Map needs key :translation");
            if(translation instanceof APersistentMap){
                this.translation = new Vector3((APersistentMap)translation);
            }
            else if(translation instanceof APersistentVector){
                this.translation = new Vector3((APersistentVector)translation);
            }
            else if(translation instanceof Vector3){
                this.translation = new Vector3((Vector3)translation);
            }
            else{
                throw new IllegalArgumentException(":translation is of unsupported type");
            }

            Object rotation = map.get(Keyword.intern("rotation"));
            if(rotation == null)
                throw new IllegalArgumentException("Map needs key :rotation");
            if(rotation instanceof APersistentMap){
                this.rotation = new Vector4((APersistentMap)rotation);
            }
            else if(rotation instanceof APersistentVector){
                this.rotation = new Vector4((APersistentVector)rotation);
            }
            else if(rotation instanceof Vector4){
                this.rotation = new Vector4((Vector4)rotation);
            }
            else{
                throw new IllegalArgumentException(":rotation is of unsupported type");
            }

            Object scale = map.get(Keyword.intern("scale"));
            if(scale == null)
                throw new IllegalArgumentException("Map needs key :scale");
            if(scale instanceof APersistentMap){
                this.scale = new Vector3((APersistentMap)scale);
            }
            else if(scale instanceof APersistentVector){
                this.scale = new Vector3((APersistentVector)scale);
            }
            else if(scale instanceof Vector3){
                this.scale = new Vector3((Vector3)scale);
            }
            else{
                throw new IllegalArgumentException(":scale is of unsupported type");
            }
        }else{
            throw new IllegalArgumentException("obj of unsupported type "+obj);
        }
    }

    public Transform(){
        super();
    }
}
