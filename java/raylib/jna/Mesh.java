package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.ShortByReference;
import com.sun.jna.ptr.IntByReference;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"vertexCount","triangleCount","vertices","texcoords","texcoords2","normals","tangents","colors","indices",
             "animVertices","animNormals","boneIds","boneWeights","vaoId","vboId"})
public class Mesh extends Structure{
    public static class ByReference extends Mesh implements Structure.ByReference{
        public ByReference(int vertexCount, int triangleCount, FloatByReference vertices, FloatByReference texcoords, FloatByReference texcoords2,
                FloatByReference normals, FloatByReference tangents, ByteByReference colors, ShortByReference indices,
                FloatByReference animVertices, FloatByReference animNormals, IntByReference boneIds, FloatByReference boneWeights,
                int vaoId, IntByReference vboId){
            super(vertexCount,triangleCount,vertices,texcoords,texcoords2,normals,tangents,colors,indices,
                  animVertices,animNormals,boneIds,boneWeights,vaoId,vboId);
        }

        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByReference br){
            super((Mesh)br);
        }
    }

    public int vertexCount;
    public int triangleCount;
    public FloatByReference vertices;
    public FloatByReference texcoords;
    public FloatByReference texcoords2;
    public FloatByReference normals;
    public FloatByReference tangents;
    public ByteByReference colors;
    public ShortByReference indices;
    public FloatByReference animVertices;
    public FloatByReference animNormals;
    public IntByReference boneIds;
    public FloatByReference boneWeights;
    public int vaoId;
    public IntByReference vboId;

    public Mesh(int vertexCount, int triangleCount, FloatByReference vertices, FloatByReference texcoords, FloatByReference texcoords2,
                FloatByReference normals, FloatByReference tangents, ByteByReference colors, ShortByReference indices,
                FloatByReference animVertices, FloatByReference animNormals, IntByReference boneIds, FloatByReference boneWeights,
                int vaoId, IntByReference vboId){
        super();
        this.vertexCount = vertexCount;
        this.triangleCount = triangleCount;
        this.vertices = vertices;
        this.texcoords = texcoords;
        this.texcoords2 = texcoords2;
        this.normals = normals;
        this.tangents = tangents;
        this.colors = colors;
        this.indices = indices;
        this.animVertices = animVertices;
        this.animNormals = animNormals;
        this.boneIds = boneIds;
        this.boneWeights = boneWeights;
        this.vaoId = vaoId;
        this.vboId = vboId;
    }

    public Mesh(APersistentMap map){
        super();
        Number vertexCount = (Number)map.get(Keyword.intern("vertexCount"));
        if(vertexCount == null)
            throw new IllegalArgumentException("Map needs key :vertexCount");
        this.vertexCount = vertexCount.intValue();
        Number triangleCount = (Number)map.get(Keyword.intern("triangleCount"));
        if(triangleCount == null)
            throw new IllegalArgumentException("Map needs key :triangleCount");
        this.triangleCount = triangleCount.intValue();
        Object vertices = map.get(Keyword.intern("vertices"));
        if(vertices == null)
            throw new IllegalArgumentException("Map needs key :vertices");
        this.vertices = (FloatByReference)vertices;
        Object texcoords = map.get(Keyword.intern("texcoords"));
        if(texcoords == null)
            throw new IllegalArgumentException("Map needs key :texcoords");
        this.texcoords = (FloatByReference)texcoords;
        Object texcoords2 = map.get(Keyword.intern("texcoords2"));
        if(texcoords2 == null)
            throw new IllegalArgumentException("Map needs key :texcoords2");
        this.texcoords2 = (FloatByReference)texcoords2;
        Object normals = map.get(Keyword.intern("normals"));
        if(normals == null)
            throw new IllegalArgumentException("Map needs key :normals");
        this.normals = (FloatByReference)normals;
        Object tangents = map.get(Keyword.intern("tangents"));
        if(tangents == null)
            throw new IllegalArgumentException("Map needs key :tangents");
        this.tangents = (FloatByReference)tangents;
        Object colors = map.get(Keyword.intern("colors"));
        if(colors == null)
            throw new IllegalArgumentException("Map needs key :colors");
        this.colors = (ByteByReference)colors;
        Object indices = map.get(Keyword.intern("indices"));
        if(indices == null)
            throw new IllegalArgumentException("Map needs key :indices");
        this.indices = (ShortByReference)indices;
        Object animVertices = map.get(Keyword.intern("animVertices"));
        if(animVertices == null)
            throw new IllegalArgumentException("Map needs key :animVertices");
        this.animVertices = (FloatByReference)animVertices;
        Object animNormals = map.get(Keyword.intern("animNormals"));
        if(animNormals == null)
            throw new IllegalArgumentException("Map needs key :animNormals");
        this.animNormals = (FloatByReference)animNormals;
        Object boneIds = map.get(Keyword.intern("boneIds"));
        if(boneIds == null)
            throw new IllegalArgumentException("Map needs key :boneIds");
        this.boneIds = (IntByReference)boneIds;
        Object boneWeights = map.get(Keyword.intern("boneWeights"));
        if(boneWeights == null)
            throw new IllegalArgumentException("Map needs key :boneWeights");
        this.boneWeights = (FloatByReference)boneWeights;
        Number vaoId = (Number)map.get(Keyword.intern("vaoId"));
        if(vaoId == null)
            throw new IllegalArgumentException("Map needs key :vaoId");
        this.vaoId = vaoId.intValue();
        Object vboId = map.get(Keyword.intern("vboId"));
        if(vboId == null)
            throw new IllegalArgumentException("Map needs key :vboId");
        this.vboId = (IntByReference)vboId;
    }

    public Mesh(Mesh m){
        super();
        this.vertexCount = m.vertexCount;
        this.triangleCount = m.triangleCount;
        this.vertices = m.vertices;
        this.texcoords = m.texcoords;
        this.texcoords2 = m.texcoords2;
        this.normals = m.normals;
        this.tangents = m.tangents;
        this.colors = m.colors;
        this.indices = m.indices;
        this.animVertices = m.animVertices;
        this.animNormals = m.animNormals;
        this.boneIds = m.boneIds;
        this.boneWeights = m.boneWeights;
        this.vaoId = m.vaoId;
        this.vboId = m.vboId;
    }

    public Mesh(){
        super();
    }
}
