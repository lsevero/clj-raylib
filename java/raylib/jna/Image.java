package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Pointer;
import clojure.lang.Keyword;
import clojure.lang.APersistentMap;

@FieldOrder({"data","width","height","mipmaps","format"})
public class Image extends Structure{
    public static class ByReference extends Image implements Structure.ByReference{
        public ByReference(Pointer data, int width, int height, int mipmaps, int format){
            super(data, width, height, mipmaps, format);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByReference br){
            super((Image)br);
        }
    }

    public Pointer data;
    public int width;
    public int height;
    public int mipmaps;
    public int format;

    public Image(Pointer data, int width, int height, int mipmaps, int format){
        super();
        this.data = data;
        this.width = width;
        this.height = height;
        this.mipmaps = mipmaps;
        this.format = format;
    }

    public Image(Image img){
        super();
        this.data = img.data;
        this.width = img.width;
        this.height = img.height;
        this.mipmaps = img.mipmaps;
        this.format = img.format;
    }

    public Image(APersistentMap map){
        super();
        Pointer data = (Pointer)map.get(Keyword.intern("data"));
        if(data == null)
            throw new IllegalArgumentException("Map needs key :data");
        this.data = data;
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

    public Image(){
        super();
    }
}
