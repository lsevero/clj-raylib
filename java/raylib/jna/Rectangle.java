package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"x","y","width","height"})
public class Rectangle extends Structure{
    public static class ByReference extends Rectangle implements Structure.ByReference {
        public ByReference(float x, float y, float width, float height){
            super(x,y,width,height);
        }

        public ByReference(){
            super();
        }

        public ByReference(ByReference r){
            super((Rectangle)r);
        }

        public ByReference(ByValue r){
            super((Rectangle)r);
        }

        public ByReference(APersistentMap map){
            super(map);
        }
    }
    public static class ByValue extends Rectangle implements Structure.ByValue {
        public ByValue(float x, float y, float width, float height){
            super(x,y,width,height);
        }

        public ByValue(){
            super();
        }

        public ByValue(ByReference r){
            super((Rectangle)r);
        }

        public ByValue(APersistentMap map){
            super(map);
        }
    }


    public float x;
    public float y;
    public float width;
    public float height;

    public Rectangle(float x, float y, float width, float height){
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle r){
        super();
        this.x = r.x;
        this.y = r.y;
        this.width = r.width;
        this.height = r.height;
    }

    public Rectangle(APersistentMap map) throws IllegalArgumentException{
        super();
        Number x = (Number)map.get(Keyword.intern("x"));
        if(x == null)
            throw new IllegalArgumentException("Map needs key :x");
        this.x = x.floatValue();
        Number y = (Number)map.get(Keyword.intern("y"));
        if(y == null)
            throw new IllegalArgumentException("Map needs key :y");
        this.y = y.floatValue();
        Number width = (Number)map.get(Keyword.intern("width"));
        if(width == null)
            throw new IllegalArgumentException("Map needs key :width");
        this.width = width.floatValue();
        Number height = (Number)map.get(Keyword.intern("height"));
        if(height == null)
            throw new IllegalArgumentException("Map needs key :height");
        this.height = height.floatValue();
    }

    public Rectangle(){
        super();
    }
}
