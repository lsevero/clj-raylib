package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.Keyword;
import clojure.lang.APersistentMap;

@FieldOrder({"r","g","b","a"})
public class Color extends Structure{
    public static class ByReference extends Color implements Structure.ByReference{
        public ByReference(){
            super();
        }

        public ByReference(byte r, byte g, byte b, byte a){
            super();
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByValue br){
            super(br);
        }
    }

    public static class ByValue extends Color implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(byte r, byte g, byte b, byte a){
            super();
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(ByReference br){
            super(br);
        }
    }

    public byte r;
    public byte g;
    public byte b;
    public byte a;

    public Color(byte r, byte g, byte b, byte a){
        super();
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(Color c){
        super();
        this.r = c.r;
        this.g = c.g;
        this.b = c.b;
        this.a = c.a;
    }

    public Color(APersistentMap map){
        super();
        Number r = (Number)map.get(Keyword.intern("r"));
        if(r == null)
            throw new IllegalArgumentException("Map needs key :r");
        this.r = r.byteValue();
        Number g = (Number)map.get(Keyword.intern("g"));
        if(g == null)
            throw new IllegalArgumentException("Map needs key :g");
        this.g = g.byteValue();
        Number b = (Number)map.get(Keyword.intern("b"));
        if(b == null)
            throw new IllegalArgumentException("Map needs key :b");
        this.b = b.byteValue();
        Number a = (Number)map.get(Keyword.intern("a"));
        if(a == null)
            throw new IllegalArgumentException("Map needs key :a");
        this.a = a.byteValue();
    }

    public Color(){
        super();
    }
}
