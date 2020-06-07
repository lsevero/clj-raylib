package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.IntByReference;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"id","locs"})
public class Shader extends Structure{
    public static class ByValue extends Shader implements Structure.ByValue {
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int id, IntByReference locs){
            super(id, locs);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }

    public int id;
    public IntByReference locs;

    public Shader(APersistentMap map){
        Number id = (Number)map.get(Keyword.intern("id"));
        if(id == null)
            throw new IllegalArgumentException("Map needs key :id");
        this.id = id.intValue();

        Object locs = map.get(Keyword.intern("locs"));
        if(locs == null)
            throw new IllegalArgumentException("Map needs key :locs");
        this.locs = (IntByReference)locs;
    }

    public Shader(int id, IntByReference locs){
        super();
        this.id = id;
        this.locs = locs;
    }

    public Shader(Shader s){
        super();
        this.id = s.id;
        this.locs = s.locs;
    }

    public Shader(Object obj) throws IllegalArgumentException{
        super();
        if(obj instanceof Shader){
            Shader s = (Shader)obj;
            this.id = s.id;
            this.locs = s.locs;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number id = (Number)map.get(Keyword.intern("id"));
            if(id == null)
                throw new IllegalArgumentException("Map needs key :id");
            this.id = id.intValue();

            Object locs = map.get(Keyword.intern("locs"));
            if(locs == null)
                throw new IllegalArgumentException("Map needs key :locs");
            this.locs = (IntByReference)locs;
        }else{
            throw new IllegalArgumentException("obj of unsupported type "+obj);
        }
    }

    public Shader(){
        super();
    }
}
