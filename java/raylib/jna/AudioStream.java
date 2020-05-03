package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.RAudioBuffer;

@FieldOrder({"sampleRate","sampleSize","channels","buffer"})
public class AudioStream extends Structure{
    public int sampleRate;
    public int sampleSize;
    public int channels;
    public RAudioBuffer.ByReference buffer;

    public AudioStream(int sampleRate, int sampleSize, int channels, RAudioBuffer.ByReference buffer){
        super();
        this.sampleRate = sampleRate;
        this.sampleSize = sampleSize;
        this.channels = channels;
        this.buffer = buffer;
    }
}
