package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"id","width","height","mipmaps","format"})
public class Texture2D extends Structure{
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
}
