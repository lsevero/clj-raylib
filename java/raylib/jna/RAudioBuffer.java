package raylib.jna;

import com.sun.jna.Structure;

public class RAudioBuffer extends Structure{
    public static class ByReference extends RAudioBuffer implements Structure.ByReference{
        public ByReference(){}
    }
}
