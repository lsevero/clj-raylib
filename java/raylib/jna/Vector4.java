package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentVector;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"x","y","z","w"})
public class Vector4 extends Structure{
    public static class ByReference extends Vector4 implements Structure.ByReference{
        public ByReference(float x, float y, float z, float w){
            super(x,y,z,w);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentVector vec){
            super(vec);
        }
    }

    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4(float x, float y, float z, float w){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4(Vector4 v){
        super();
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        this.w = v.w;
    }

    public Vector4(APersistentVector vec) throws IllegalArgumentException{
       super();
       if(vec.count() != 4)
         throw new IllegalArgumentException("PersistentVector needs to be of size 4");
       this.x = ((Number)vec.nth(0)).floatValue();
       this.y = ((Number)vec.nth(1)).floatValue();
       this.z = ((Number)vec.nth(2)).floatValue();
       this.w = ((Number)vec.nth(3)).floatValue();
    }

    public Vector4(APersistentMap map) throws IllegalArgumentException{
        super();
        Number x = (Number)map.get(Keyword.intern("x"));
        if(x == null)
            throw new IllegalArgumentException("Map needs key :x");
        this.x = x.floatValue();
        Number y = (Number)map.get(Keyword.intern("y"));
        if(y == null)
            throw new IllegalArgumentException("Map needs key :y");
        this.y = y.floatValue();
        Number z = (Number)map.get(Keyword.intern("z"));
        if(z == null)
            throw new IllegalArgumentException("Map needs key :z");
        this.z = z.floatValue();
        Number w = (Number)map.get(Keyword.intern("w"));
        if(w == null)
            throw new IllegalArgumentException("Map needs key :w");
        this.w = w.floatValue();
    }

    public Vector4(){
        super();
    }
}
