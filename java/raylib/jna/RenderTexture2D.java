package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;
import raylib.jna.Texture2D;

@FieldOrder({"id","texture","depth","depthTexture"})
public class RenderTexture2D extends Structure{
    public static class ByValue extends RenderTexture2D implements Structure.ByValue {
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int id, Texture2D texture, Texture2D depth, boolean depthTexture){
            super(id, texture, depth, depthTexture);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }

    public int id;
    public Texture2D texture;
    public Texture2D depth;
    public boolean depthTexture;

    public RenderTexture2D(APersistentMap map){
        Number id = (Number)map.get(Keyword.intern("id"));
        if(id == null)
            throw new IllegalArgumentException("Map needs key :id");
        this.id = id.intValue();

        Object texture = map.get(Keyword.intern("texture"));
        if(texture == null)
            throw new IllegalArgumentException("Map needs key :texture");
        if(texture instanceof APersistentMap){
            this.texture = new Texture2D((APersistentMap)texture);
        }
        else if(texture instanceof Texture2D){
            this.texture = new Texture2D((Texture2D)texture);
        }
        else{
            throw new IllegalArgumentException(":texture is of unsupported type");
        }

        Boolean depthTexture = (Boolean)map.get(Keyword.intern("depthTexture"));
        if(depthTexture == null)
            throw new IllegalArgumentException("Map needs key :depthTexture");
        this.depthTexture = depthTexture.booleanValue();
    }

    public RenderTexture2D(int id, Texture2D texture, Texture2D depth, boolean depthTexture){
        super();
        this.id = id;
        this.texture = texture;
        this.depth = depth;
        this.depthTexture = depthTexture;
    }

    public RenderTexture2D(RenderTexture2D r){
        super();
        this.id = r.id;
        this.texture = new Texture2D(r.texture);
        this.depth = new Texture2D(r.depth);
        this.depthTexture = r.depthTexture;
    }

    public RenderTexture2D(Object obj) throws IllegalArgumentException{
        super();
        if(obj instanceof RenderTexture2D){
            RenderTexture2D r = (RenderTexture2D)obj;
            this.id = r.id;
            this.texture = new Texture2D(r.texture);
            this.depth = new Texture2D(r.depth);
            this.depthTexture = r.depthTexture;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number id = (Number)map.get(Keyword.intern("id"));
            if(id == null)
                throw new IllegalArgumentException("Map needs key :id");
            this.id = id.intValue();

            Object texture = map.get(Keyword.intern("texture"));
            if(texture == null)
                throw new IllegalArgumentException("Map needs key :texture");
            if(texture instanceof APersistentMap){
                this.texture = new Texture2D((APersistentMap)texture);
            }
            else if(texture instanceof Texture2D){
                this.texture = new Texture2D((Texture2D)texture);
            }
            else{
                throw new IllegalArgumentException(":texture is of unsupported type");
            }

            Boolean depthTexture = (Boolean)map.get(Keyword.intern("depthTexture"));
            if(depthTexture == null)
                throw new IllegalArgumentException("Map needs key :depthTexture");
            this.depthTexture = depthTexture.booleanValue();
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }
    }

    public RenderTexture2D(){
        super();
    }
}
