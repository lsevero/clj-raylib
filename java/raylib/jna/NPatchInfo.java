package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Rectangle;

@FieldOrder({"sourceRec","left","top","right","bottom","type"})
public class NPatchInfo extends Structure{
    public Rectangle sourceRec;
    public int left;
    public int top;
    public int right;
    public int bottom;
    public int type;

    public NPatchInfo(Rectangle sourceRec, int left, int top, int right, int bottom, int type){
        super();
        this.sourceRec = sourceRec;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.type = type;
    }

    public NPatchInfo(){
        super();
    }
}
