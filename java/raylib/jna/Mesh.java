package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.ShortByReference;
import com.sun.jna.ptr.IntByReference;

@FieldOrder({"vertexCount","triangleCount","vertices","texcoords","texcoords2","normals","tangents","colors","indices",
             "animVertices","animNormals","boneIds","boneWeights","vaoId","vboId"})
public class Mesh extends Structure{
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
}
