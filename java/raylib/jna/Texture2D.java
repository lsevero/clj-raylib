package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"id","width","height","mipmaps","format"})
public class Texture2D extends Structure{
    public static class ByValue extends Texture2D implements Structure.ByValue {
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int id, int width, int height, int mipmaps, int format){
            super(id, width, height, mipmaps, format);
        }
    }
    public int id;
    public int width;
    public int height;
    public int mipmaps;
    public int format;

    public Texture2D(int id, int width, int height, int mipmaps, int format){
        super();
        this.id = id;
        this.width = width;
        this.height = height;
        this.mipmaps = mipmaps;
        this.format = format;
    }

    public Texture2D(Texture2D t){
        super();
        this.id = t.id;
        this.width = t.width;
        this.height = t.height;
        this.mipmaps = t.mipmaps;
        this.format = t.format;
    }

    public Texture2D(APersistentMap map) throws IllegalArgumentException{
        super();
        Number id = (Number)map.get(Keyword.intern("id"));
        if(id == null)
            throw new IllegalArgumentException("Map needs key :id");
        this.id = id.intValue();
        Number width = (Number)map.get(Keyword.intern("width"));
        if(width == null)
            throw new IllegalArgumentException("Map needs key :width");
        this.width = width.intValue();
        Number height = (Number)map.get(Keyword.intern("height"));
        if(height == null)
            throw new IllegalArgumentException("Map needs key :height");
        this.height = height.intValue();
        Number mipmaps = (Number)map.get(Keyword.intern("mipmaps"));
        if(mipmaps == null)
            throw new IllegalArgumentException("Map needs key :mipmaps");
        this.mipmaps = mipmaps.intValue();
        Number format = (Number)map.get(Keyword.intern("format"));
        if(format == null)
            throw new IllegalArgumentException("Map needs key :format");
        this.format = format.intValue();
    }

    public Texture2D(){
        super();
    }
}
