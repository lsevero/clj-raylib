package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Pointer;

@FieldOrder({"sampleCount","sampleRate","sampleSize","channels","data"})
public class Wave extends Structure{
    public int sampleCount;
    public int sampleRate;
    public int sampleSize;
    public int channels;
    public Pointer data;

    public Wave(int sampleCount, int sampleRate, int sampleSize, int channels, Pointer data){
        super();
        this.sampleCount = sampleCount;
        this.sampleRate = sampleRate;
        this.sampleSize = sampleSize;
        this.channels = channels;
        this.data = data;
    }
}
