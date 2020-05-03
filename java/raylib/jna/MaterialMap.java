package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Texture2D;
import raylib.jna.Color;

@FieldOrder({"texture","color","value"})
public class MaterialMap extends Structure{
    public static class ByReference extends MaterialMap implements Structure.ByReference {
        public ByReference(Texture2D texture, Color color, float value){
            super(texture, color, value);
        }
    }

    public Texture2D texture;
    public Color color;
    public float value;

    public MaterialMap(Texture2D texture, Color color, float value){
        super();
        this.texture = texture;
        this.color = color;
        this.value = value;
    }
}
