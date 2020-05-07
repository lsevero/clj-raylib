package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Texture2D;
import raylib.jna.Rectangle;
import raylib.jna.CharInfo;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"baseSize","charsCount","texture","recs","chars"})
public class Font extends Structure{
    public static class ByValue extends Font implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int baseSize, int charsCount, Texture2D texture, Rectangle.ByReference recs, CharInfo.ByReference chars){
            super(baseSize, charsCount, texture, recs, chars);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }


    public int baseSize;
    public int charsCount;
    public Texture2D texture;
    public Rectangle.ByReference recs;
    public CharInfo.ByReference chars;

    public Font(APersistentMap map){
        super();
        Number baseSize = (Number)map.get(Keyword.intern("baseSize"));
        if(baseSize == null)
            throw new IllegalArgumentException("Map needs key :baseSize");
        this.baseSize = baseSize.intValue();
        Number charsCount = (Number)map.get(Keyword.intern("charsCount"));
        if(charsCount == null)
            throw new IllegalArgumentException("Map needs key :charsCount");
        this.charsCount = charsCount.intValue();
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
            throw new IllegalArgumentException(":min is of unsupported type");
        }
        Object recs = map.get(Keyword.intern("recs"));
        if(recs == null)
            throw new IllegalArgumentException("Map needs key :recs");
        if(recs instanceof APersistentMap){
            this.recs = new Rectangle.ByReference((APersistentMap)recs);
        }
        else if(recs instanceof Rectangle.ByReference){
            this.recs = new Rectangle.ByReference((Rectangle.ByReference)recs);
        }
        else{
            throw new IllegalArgumentException(":recs is of unsupported type");
        }
    }

    public Font(Font f){
        super();
        this.baseSize = f.baseSize;
        this.charsCount = f.charsCount;
        this.texture = new Texture2D(f.texture);
        this.recs = new Rectangle.ByReference(recs);
        this.chars = new CharInfo.ByReference(chars);
    }


    public Font(Object obj){
        super();
        if(obj instanceof Font){
            Font f = (Font)obj;
            this.baseSize = f.baseSize;
            this.charsCount = f.charsCount;
            this.texture = new Texture2D(f.texture);
            this.recs = new Rectangle.ByReference(recs);
            this.chars = new CharInfo.ByReference(chars);
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number baseSize = (Number)map.get(Keyword.intern("baseSize"));
            if(baseSize == null)
                throw new IllegalArgumentException("Map needs key :baseSize");
            this.baseSize = baseSize.intValue();
            Number charsCount = (Number)map.get(Keyword.intern("charsCount"));
            if(charsCount == null)
                throw new IllegalArgumentException("Map needs key :charsCount");
            this.charsCount = charsCount.intValue();
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
                throw new IllegalArgumentException(":min is of unsupported type");
            }
            Object recs = map.get(Keyword.intern("recs"));
            if(recs == null)
                throw new IllegalArgumentException("Map needs key :recs");
            if(recs instanceof APersistentMap){
                this.recs = new Rectangle.ByReference((APersistentMap)recs);
            }
            else if(recs instanceof Rectangle.ByReference){
                this.recs = new Rectangle.ByReference((Rectangle.ByReference)recs);
            }
            else{
                throw new IllegalArgumentException(":recs is of unsupported type");
            }
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }
    }

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
