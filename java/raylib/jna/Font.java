package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Texture2D;
import raylib.jna.Rectangle;
import raylib.jna.CharInfo;

@FieldOrder({"baseSize","charsCount","texture","recs","chars"})
public class Font extends Structure{
    public int baseSize;
    public int charsCount;
    public Texture2D texture;
    public Rectangle.ByReference recs;
    public CharInfo.ByReference chars;

    public Font(int baseSize, int charsCount, Texture2D texture, Rectangle.ByReference recs, CharInfo.ByReference chars){
        super();
        this.baseSize = baseSize;
        this.charsCount = charsCount;
        this.texture = texture;
        this.recs = recs;
        this.chars = chars;
    }

    public Font(){
        super();
    }
}
