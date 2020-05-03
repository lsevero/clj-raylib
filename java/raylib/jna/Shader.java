package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.IntByReference;

@FieldOrder({"id","locs"})
public class Shader extends Structure{
    public int id;
    public IntByReference locs;

    public Shader(int id, IntByReference locs){
        super();
        this.id = id;
        this.locs = locs;
    }
}
