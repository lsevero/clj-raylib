package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Pointer;
import raylib.jna.AudioStream;

@FieldOrder({"ctxType","ctxData","sampleCount","loopCount","stream"})
public class Music extends Structure{
    public int ctxType;
    public Pointer ctxData;
    public int sampleCount;
    public int loopCount;
    public AudioStream stream;

    public Music(int ctxType, Pointer ctxData, int sampleCount, int loopCount, AudioStream stream){
        super();
        this.ctxType = ctxType;
        this.ctxData = ctxData;
        this.sampleCount = sampleCount;
        this.loopCount = loopCount;
        this.stream = stream;
    }
}
