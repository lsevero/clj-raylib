package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Transform;
import raylib.jna.BoneInfo;
import clojure.lang.Keyword;
import clojure.lang.APersistentMap;

@FieldOrder({"boneCount","bones","frameCount","framePoses"})
public class ModelAnimation extends Structure{
    public static class ByReference extends ModelAnimation implements Structure.ByReference{
        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByReference br){
            super((ModelAnimation)br);
        }

        public ByReference(ByValue br){
            super((ModelAnimation)br);
        }
        public ByReference(Object obj){
            super(obj);
        }
    }
    public static class ByValue extends ModelAnimation implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(ByReference br){
            super((ModelAnimation)br);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }


    public int boneCount;
    public BoneInfo.ByReference bones;
    public int frameCount;
    public Transform.ByReference framePoses;
    //public Transform.ByReference[] framePoses;

    public ModelAnimation(int boneCount, BoneInfo.ByReference bones, int frameCount, Transform.ByReference framePoses){
        //public ModelAnimation(int boneCount, BoneInfo.ByReference bones, int frameCount, Transform.ByReference[] framePoses){
        super();
        this.boneCount = boneCount;
        this.bones = bones;
        this.frameCount = frameCount;
        this.framePoses = framePoses;
        }

    public ModelAnimation(ModelAnimation m){
        super();
        this.boneCount = m.boneCount;
        this.bones = new BoneInfo.ByReference(m.bones);
        this.frameCount = m.frameCount;
        this.framePoses = new Transform.ByReference(m.framePoses);
    }

    public ModelAnimation(APersistentMap map){
        super();
        Number boneCount = (Number)map.get(Keyword.intern("boneCount"));
        if(boneCount == null)
            throw new IllegalArgumentException("Map needs key :boneCount");
        this.boneCount = boneCount.intValue();

        Object bones = map.get(Keyword.intern("bones"));
        if(bones == null)
            throw new IllegalArgumentException("Map needs key :bones");
        if(bones instanceof APersistentMap){
            this.bones = new BoneInfo.ByReference((APersistentMap)bones);
        }
        else if(bones instanceof BoneInfo.ByReference){
            this.bones = new BoneInfo.ByReference((BoneInfo.ByReference)bones);
        }
        else{
            throw new IllegalArgumentException(":bones is of unsupported type");
        }

        Number frameCount = (Number)map.get(Keyword.intern("frameCount"));
        if(frameCount == null)
            throw new IllegalArgumentException("Map needs key :frameCount");
        this.frameCount = frameCount.intValue();

        Object framePoses = map.get(Keyword.intern("framePoses"));
        if(framePoses == null)
            throw new IllegalArgumentException("Map needs key :framePoses");
        this.framePoses = (Transform.ByReference)framePoses;
        //this.framePoses = (Transform.ByReference[])framePoses;
    }

    public ModelAnimation(Object obj){
        super();
        if(obj instanceof ModelAnimation){
            ModelAnimation m = (ModelAnimation)obj;
            this.boneCount = m.boneCount;
            this.bones = new BoneInfo.ByReference(m.bones);
            this.frameCount = m.frameCount;
            this.framePoses = new Transform.ByReference(m.framePoses);
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number boneCount = (Number)map.get(Keyword.intern("boneCount"));
            if(boneCount == null)
                throw new IllegalArgumentException("Map needs key :boneCount");
            this.boneCount = boneCount.intValue();

            Object bones = map.get(Keyword.intern("bones"));
            if(bones == null)
                throw new IllegalArgumentException("Map needs key :bones");
            if(bones instanceof APersistentMap){
                this.bones = new BoneInfo.ByReference((APersistentMap)bones);
            }
            else if(bones instanceof BoneInfo.ByReference){
                this.bones = new BoneInfo.ByReference((BoneInfo.ByReference)bones);
            }
            else{
                throw new IllegalArgumentException(":bones is of unsupported type");
            }

            Number frameCount = (Number)map.get(Keyword.intern("frameCount"));
            if(frameCount == null)
                throw new IllegalArgumentException("Map needs key :frameCount");
            this.frameCount = frameCount.intValue();

            Object framePoses = map.get(Keyword.intern("framePoses"));
            if(framePoses == null)
                throw new IllegalArgumentException("Map needs key :framePoses");
            this.framePoses = (Transform.ByReference)framePoses;
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }
    }

    public ModelAnimation(){
        super();
    }
    }
