package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Texture2D;
import raylib.jna.Color;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"texture","color","value"})
public class MaterialMap extends Structure{
    public static class ByReference extends MaterialMap implements Structure.ByReference {
        public ByReference(Texture2D texture, Color color, float value){
            super(texture, color, value);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByReference br){
            super((MaterialMap)br);
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

    public MaterialMap(MaterialMap mm){
        super();
        this.texture = new Texture2D(mm.texture);
        this.color = new Color(mm.color);
        this.value = value;
    }


    public MaterialMap(APersistentMap map){
        super();
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
        Object color = map.get(Keyword.intern("color"));
        if(color == null)
            throw new IllegalArgumentException("Map needs key :color");
        if(color instanceof APersistentMap){
            this.color = new Color((APersistentMap)color);
        }
        else if(color instanceof Color){
            this.color = new Color((Color)color);
        }
        else{
            throw new IllegalArgumentException(":color is of unsupported type");
        }
        Number value = (Number)map.get(Keyword.intern("value"));
        if(value == null)
            throw new IllegalArgumentException("Map needs key :value");
        this.value = value.floatValue();
    }

    public MaterialMap(){
        super();
    }
}
