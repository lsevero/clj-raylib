package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.IntByReference;
import raylib.jna.Matrix;
import raylib.jna.Mesh;
import raylib.jna.Material;
import raylib.jna.BoneInfo;
import clojure.lang.APersistentMap;
import clojure.lang.APersistentVector;
import clojure.lang.Keyword;

@FieldOrder({"transform","meshCount","meshes","materialCount","materials","meshMaterial","boneCount","bones","bindPose"})
public class Model extends Structure{
    public static class ByReference extends Model implements Structure.ByReference{
        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByReference br){
            super((Model)br);
        }
    }

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

    public Model(APersistentMap map){
        super();
        Object transform = map.get(Keyword.intern("transform"));
        if(transform == null)
            throw new IllegalArgumentException("Map needs key :transform");
        if(transform instanceof APersistentMap){
            this.transform = new Matrix((APersistentMap)transform);
        }
        else if(transform instanceof APersistentVector){
            this.transform = new Matrix((APersistentVector)transform);
        }
        else if(transform instanceof Matrix){
            this.transform = new Matrix((Matrix)transform);
        }
        else{
            throw new IllegalArgumentException(":transform is of unsupported type");
        }

        Number meshCount = (Number)map.get(Keyword.intern("meshCount"));
        if(meshCount == null)
            throw new IllegalArgumentException("Map needs key :meshCount");
        this.meshCount = meshCount.intValue();

        Object meshes = map.get(Keyword.intern("meshes"));
        if(meshes == null)
            throw new IllegalArgumentException("Map needs key :meshes");
        if(meshes instanceof APersistentMap){
            this.meshes = new Mesh.ByReference((APersistentMap)meshes);
        }
        else if(meshes instanceof Mesh.ByReference){
            this.meshes = new Mesh.ByReference((Mesh.ByReference)meshes);
        }
        else{
            throw new IllegalArgumentException(":meshes is of unsupported type");
        }

        Number materialCount = (Number)map.get(Keyword.intern("materialCount"));
        if(materialCount == null)
            throw new IllegalArgumentException("Map needs key :materialCount");
        this.materialCount = materialCount.intValue();

        Object materials = map.get(Keyword.intern("materials"));
        if(materials == null)
            throw new IllegalArgumentException("Map needs key :materials");
        if(materials instanceof APersistentMap){
            this.materials = new Material.ByReference((APersistentMap)materials);
        }
        else if(materials instanceof Material.ByReference){
            this.materials = new Material.ByReference((Material.ByReference)materials);
        }
        else{
            throw new IllegalArgumentException(":materials is of unsupported type");
        }

        Object meshMaterial = map.get(Keyword.intern("meshMaterial"));
        if(meshMaterial == null)
            throw new IllegalArgumentException("Map needs key :meshMaterial");
        this.meshMaterial = (IntByReference)meshMaterial;

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

        Object bindPose = map.get(Keyword.intern("bindPose"));
        if(bindPose == null)
            throw new IllegalArgumentException("Map needs key :bindPose");
        if(bindPose instanceof APersistentMap){
            this.bindPose = new Transform.ByReference((APersistentMap)bindPose);
        }
        else if(bindPose instanceof Transform.ByReference){
            this.bindPose = new Transform.ByReference((Transform.ByReference)bindPose);
        }
        else{
            throw new IllegalArgumentException(":bindPose is of unsupported type");
        }
    }

    public Model(Model m){
        super();
        this.transform = new Matrix(transform);
        this.meshCount = meshCount;
        this.meshes = new Mesh.ByReference(meshes);
        this.materialCount = materialCount;
        this.materials = new Material.ByReference(materials);
        this.meshMaterial = meshMaterial;
        this.boneCount = boneCount;
        this.bones = new BoneInfo.ByReference(bones);
        this.bindPose = new Transform.ByReference(bindPose);
    }

    public Model(){
        super();
    }
}
