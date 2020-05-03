package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.AudioStream;

@FieldOrder({"sampleCount","stream"})
public class Sound extends Structure{
    public int sampleCount;
    public AudioStream stream;

    public Sound(int sampleCount, AudioStream stream){
        super();
        this.sampleCount = sampleCount;
        this.stream = stream;
    }

    public Sound(){
        super();
    }
}
