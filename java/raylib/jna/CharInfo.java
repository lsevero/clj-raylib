package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Image;

@FieldOrder({"value","offsetX","offsetY","advanceX","image"})
public class CharInfo extends Structure{
    public static class ByReference extends CharInfo implements Structure.ByReference {
        public ByReference(int value, int offsetX, int offsetY, int advanceX, Image image){
            super(value, offsetX, offsetY, advanceX, image);
        }

        public ByReference(){
            super();
        }
    }
    public int value;
    public int offsetX;
    public int offsetY;
    public int advanceX;
    public Image image;

    public CharInfo(int value, int offsetX, int offsetY, int advanceX, Image image){
        super();
        this.value = value;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.advanceX = advanceX;
        this.image = image;
    }

    public CharInfo(){
        super();
    }
}
