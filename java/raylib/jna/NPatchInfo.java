package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Rectangle;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"sourceRec","left","top","right","bottom","type"})
public class NPatchInfo extends Structure{
    public static class ByValue extends NPatchInfo implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }
        
        public ByValue(Rectangle sourceRec, int left, int top, int right, int bottom, int type){
            super(sourceRec, left, top, right, bottom, type);
        }
    }

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

    public NPatchInfo(APersistentMap map){
        Object sourceRec = map.get(Keyword.intern("sourceRec"));
        if(sourceRec == null)
            throw new IllegalArgumentException("Map needs key :sourceRec");
        if(sourceRec instanceof APersistentMap){
            this.sourceRec = new Rectangle((APersistentMap)sourceRec);
        }
        else if(sourceRec instanceof Rectangle){
            this.sourceRec = new Rectangle((Rectangle)sourceRec);
        }
        else{
            throw new IllegalArgumentException(":sourceRec is of unsupported type");
        }

        Number left = (Number)map.get(Keyword.intern("left"));
        if(left == null)
            throw new IllegalArgumentException("Map needs key :left");
        this.left = left.intValue();

        Number top = (Number)map.get(Keyword.intern("top"));
        if(top == null)
            throw new IllegalArgumentException("Map needs key :top");
        this.top = top.intValue();

        Number right = (Number)map.get(Keyword.intern("right"));
        if(right == null)
            throw new IllegalArgumentException("Map needs key :right");
        this.right = right.intValue();

        Number bottom = (Number)map.get(Keyword.intern("bottom"));
        if(bottom == null)
            throw new IllegalArgumentException("Map needs key :bottom");
        this.bottom = bottom.intValue();

        Number type = (Number)map.get(Keyword.intern("type"));
        if(type == null)
            throw new IllegalArgumentException("Map needs key :type");
        this.type = type.intValue();
    }

    public NPatchInfo(NPatchInfo n){
        super();
        this.sourceRec = new Rectangle(sourceRec);
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
