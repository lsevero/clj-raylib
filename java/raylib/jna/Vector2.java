package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentVector;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"x","y"})
public class Vector2 extends Structure{
    public static class ByReference extends Vector2 implements Structure.ByReference{
        public ByReference(float x, float y){
            super(x,y);
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

        public ByReference(Object obj){
            super(obj);
        }
    }

    public static class ByValue extends Vector2 implements Structure.ByValue{
        public ByValue(float x, float y){
            super(x,y);
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

        public ByValue(Object obj){
            super(obj);
        }
    }

    public float x;
    public float y;

    public Vector2(float x, float y){
        super();
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 v){
        super();
        this.x = v.x;
        this.y = v.y;
    }

    public Vector2(APersistentVector vec) throws IllegalArgumentException{
        super();
        if(vec.count() != 2)
            throw new IllegalArgumentException("Vector needs to be of size 2");
        this.x = ((Number)vec.get(0)).floatValue();
        this.y = ((Number)vec.get(1)).floatValue();
    }

    public Vector2(APersistentMap map) throws IllegalArgumentException{
        super();
        Number x = (Number)map.get(Keyword.intern("x"));
        if(x == null)
            throw new IllegalArgumentException("Map needs key :x");
        this.x = x.floatValue();
        Number y = (Number)map.get(Keyword.intern("y"));
        if(y == null)
            throw new IllegalArgumentException("Map needs key :y");
        this.y = y.floatValue();
    }

    public Vector2(Object obj) throws IllegalArgumentException{
        super();
        if(obj instanceof Vector2){
            Vector2 v = (Vector2)obj;
            this.x = v.x;
            this.y = v.y;
        }else if(obj instanceof APersistentVector){
            APersistentVector vec = (APersistentVector)obj;
            if(vec.count() != 2)
                throw new IllegalArgumentException("Vector needs to be of size 2");
            this.x = ((Number)vec.get(0)).floatValue();
            this.y = ((Number)vec.get(1)).floatValue();
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number x = (Number)map.get(Keyword.intern("x"));
            if(x == null)
                throw new IllegalArgumentException("Map needs key :x");
            this.x = x.floatValue();
            Number y = (Number)map.get(Keyword.intern("y"));
            if(y == null)
                throw new IllegalArgumentException("Map needs key :y");
            this.y = y.floatValue();
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }

    }

    public Vector2(){
        super();
    }
}
