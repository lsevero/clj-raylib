package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.FloatByReference;
import raylib.jna.MaterialMap;
import raylib.jna.Shader;

@FieldOrder({"shader","maps","value"})
public class Material extends Structure{
    public static class ByReference extends Material implements Structure.ByReference{
        public ByReference(Texture2D shader, MaterialMap.ByReference maps, FloatByReference value){
            super(shader, maps, value);
        }
    }

    public Texture2D shader;
    public MaterialMap.ByReference maps;
    public FloatByReference value;

    public Material(Texture2D shader, MaterialMap.ByReference maps, FloatByReference value){
        super();
        this.shader = shader;
        this.maps = maps;
        this.value = value;
    }
}
