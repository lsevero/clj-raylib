package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.FloatByReference;
import raylib.jna.MaterialMap;
import raylib.jna.Shader;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"shader","maps","value"})
public class Material extends Structure{
    public static class ByReference extends Material implements Structure.ByReference{
        public ByReference(Texture2D shader, MaterialMap.ByReference maps, FloatByReference value){
            super(shader, maps, value);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByValue br){
            super((Material)br);
        }

        public ByReference(ByReference br){
            super((Material)br);
        }
    }

    public static class ByValue extends Material implements Structure.ByValue{
        public ByValue(Texture2D shader, MaterialMap.ByReference maps, FloatByReference value){
            super(shader, maps, value);
        }

        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(ByReference br){
            super((Material)br);
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

    public Material(Material m){
        super();
        this.shader = new Texture2D(shader);
        this.maps = new MaterialMap.ByReference(maps);
        this.value = value;
    }

    public Material(APersistentMap map){
        super();
        Object shader = map.get(Keyword.intern("shader"));
        if(shader == null)
            throw new IllegalArgumentException("Map needs key :shader");
        if(shader instanceof APersistentMap){
            this.shader = new Texture2D((APersistentMap)shader);
        }
        else if(shader instanceof Texture2D){
            this.shader = new Texture2D((Texture2D)shader);
        }
        else{
            throw new IllegalArgumentException(":shader is of unsupported type");
        }
        Object maps = map.get(Keyword.intern("maps"));
        if(maps == null)
            throw new IllegalArgumentException("Map needs key :maps");
        if(maps instanceof APersistentMap){
            this.maps = new MaterialMap.ByReference((APersistentMap)maps);
        }
        else if(maps instanceof MaterialMap.ByReference){
            this.maps = new MaterialMap.ByReference((MaterialMap.ByReference)maps);
        }
        else{
            throw new IllegalArgumentException(":maps is of unsupported type");
        }
    }

    public Material(){
        super();
    }
}
