package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"name","parent"})
public class BoneInfo extends Structure{
    public static class ByReference extends BoneInfo implements Structure.ByReference{
        public ByReference(byte[] name, int parent){
            super(name, parent);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByValue boneinfo){
            super(boneinfo);
        }
        public ByReference(ByReference boneinfo){
            super(boneinfo);
        }
        public ByReference(Object obj){
            super(obj);
        }
    }
    public static class ByValue extends BoneInfo implements Structure.ByValue{
        public ByValue(byte[] name, int parent){
            super(name, parent);
        }

        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(ByReference boneinfo){
            super(boneinfo);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }

    public byte[] name = new byte[32];
    public int parent;

    public BoneInfo(byte[] name, int parent){
        super();
        this.name = name;
        this.parent = parent;
    }

    public BoneInfo(BoneInfo boneinfo){
        super();
        System.arraycopy(boneinfo.name, 0, this.name, 0, boneinfo.name.length);
        this.parent = boneinfo.parent;
    }

    public BoneInfo(APersistentMap map){
        super();
        Object name = map.get(Keyword.intern("name"));
        if(name == null)
            throw new IllegalArgumentException("Map needs key :name");
        this.name = (byte[])name;
        Number parent = (Number)map.get(Keyword.intern("parent"));
        if(parent == null)
            throw new IllegalArgumentException("Map needs key :parent");
        this.parent = parent.intValue();
    }

    public BoneInfo(Object obj){
        super();
        if(obj instanceof BoneInfo){
            BoneInfo b = (BoneInfo)obj;
            System.arraycopy(b.name, 0, this.name, 0, b.name.length);
            this.parent = b.parent;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Object name = map.get(Keyword.intern("name"));
            if(name == null)
                throw new IllegalArgumentException("Map needs key :name");
            this.name = (byte[])name;
            Number parent = (Number)map.get(Keyword.intern("parent"));
            if(parent == null)
                throw new IllegalArgumentException("Map needs key :parent");
            this.parent = parent.intValue();
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }
    }

    public BoneInfo(){
        super();
    }
}
