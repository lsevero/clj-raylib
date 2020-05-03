package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.Transform;
import raylib.jna.BoneInfo;

@FieldOrder({"boneCount","bones","frameCount","framePoses"})
public class ModelAnimation extends Structure{
    public int boneCount;
    public BoneInfo.ByReference bones;
    public int frameCount;
    public Transform.ByReference[] framePoses;

    public ModelAnimation(int boneCount, BoneInfo.ByReference bones, int frameCount, Transform.ByReference[] framePoses){
        super();
        this.boneCount = boneCount;
        this.bones = bones;
        this.frameCount = frameCount;
        this.framePoses = framePoses;
    }
}
