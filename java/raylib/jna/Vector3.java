package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentVector;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"x","y","z"})
public class Vector3 extends Structure{
    public static class ByReference extends Vector3 implements Structure.ByReference{
        public ByReference(float x, float y, float z){
            super(x,y,z);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentVector vec){
            super(vec);
        }

        public ByReference(APersistentMap map){
            super(map);
        }
    }

    public static class ByValue extends Vector3 implements Structure.ByValue{
        public ByValue(float x, float y, float z){
            super(x,y,z);
        }

        public ByValue(){
            super();
        }

        public ByValue(APersistentVector vec){
            super(vec);
        }

        public ByValue(APersistentMap map){
            super(map);
        }
    }

    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z){
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector3 v){
        super();
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public Vector3(APersistentVector vec) throws IllegalArgumentException{
       super();
       if(vec.count() != 3)
         throw new IllegalArgumentException("PersistentVector needs to be of size 3");
       this.x = ((Number)vec.nth(0)).floatValue();
       this.y = ((Number)vec.nth(1)).floatValue();
       this.z = ((Number)vec.nth(2)).floatValue();
    }

    public Vector3(APersistentMap map) throws IllegalArgumentException{
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
    }

    public Vector3(){
        super();
    }
}
