package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Texture2D;

@FieldOrder({"id","texture","depth","depthTexture"})
public class RenderTexture2D extends Structure{
    public int id;
    public Texture2D texture;
    public Texture2D depth;
    public boolean depthTexture;

    public RenderTexture2D(int id, Texture2D texture, Texture2D depth, boolean depthTexture){
        super();
        this.id = id;
        this.texture = texture;
        this.depth = depth;
        this.depthTexture = depthTexture;
    }

    public RenderTexture2D(){
        super();
    }
}
