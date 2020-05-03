package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Pointer;

@FieldOrder({"data","width","height","mipmaps","format"})
public class Image extends Structure{
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
}
