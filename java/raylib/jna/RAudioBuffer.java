package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"unused"})
public class RAudioBuffer extends Structure{
    public static class ByReference extends RAudioBuffer implements Structure.ByReference{}
    public static class ByValue extends RAudioBuffer implements Structure.ByValue{}
    public int unused;
}
