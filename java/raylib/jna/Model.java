package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.IntByReference;
import raylib.jna.Matrix;
import raylib.jna.Mesh;
import raylib.jna.Material;
import raylib.jna.BoneInfo;

@FieldOrder({"transform","meshCount","meshes","materialCount","materials","meshMaterial","boneCount","bones","bindPose"})
public class Model extends Structure{
    public Matrix transform;
    public int meshCount;
    public Mesh.ByReference meshes;
    public int materialCount;
    public Material.ByReference materials;
    public IntByReference meshMaterial;
    public int boneCount;
    public BoneInfo.ByReference bones;
    public Transform.ByReference bindPose;

    public Model(Matrix transform, int meshCount, Mesh.ByReference meshes, int materialCount, Material.ByReference materials,
                 IntByReference meshMaterial, int boneCount, BoneInfo.ByReference bones, Transform.ByReference bindPose){
        super();
        this.transform = transform;
        this.meshCount = meshCount;
        this.meshes = meshes;
        this.materialCount = materialCount;
        this.materials = materials;
        this.meshMaterial = meshMaterial;
        this.boneCount = boneCount;
        this.bones = bones;
        this.bindPose = bindPose;
    }

    public Model(){
        super();
    }
}
