package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"name","parent"})
public class BoneInfo extends Structure{
    public static class ByReference extends BoneInfo implements Structure.ByReference{
        public ByReference(byte[] name, int parent){
            super(name, parent);
        }
    }

    public byte[] name = new byte[32];
    public int parent;

    public BoneInfo(byte[] name, int parent){
        super();
        this.name = name;
        this.parent = parent;
    }
}
