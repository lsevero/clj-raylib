package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"r","g","b","a"})
public class Color extends Structure{
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
}
