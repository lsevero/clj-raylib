package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.RAudioBuffer;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"sampleRate","sampleSize","channels","buffer"})
public class AudioStream extends Structure{
    public static class ByValue extends AudioStream implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(int sampleRate, int sampleSize, int channels, RAudioBuffer.ByReference buffer){
            super();
            this.sampleRate = sampleRate;
            this.sampleSize = sampleSize;
            this.channels = channels;
            this.buffer = buffer;
        }


        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(ByValue br){
            super((AudioStream)br);
        }

        public ByValue(Object obj){
            super(obj);
        }
    }

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

    public AudioStream(AudioStream as){
        super();
        this.sampleRate = as.sampleRate;
        this.sampleSize = as.sampleSize;
        this.channels = as.channels;
        this.buffer = as.buffer;
    }

    public AudioStream(APersistentMap map) throws IllegalArgumentException{
        super();
        Number sampleRate = (Number)map.get(Keyword.intern("sampleRate"));
        if(sampleRate == null)
            throw new IllegalArgumentException("Map needs key :sampleRate");
        this.sampleRate = sampleRate.intValue();
        Number sampleSize = (Number)map.get(Keyword.intern("sampleSize"));
        if(sampleSize == null)
            throw new IllegalArgumentException("Map needs key :sampleSize");
        this.sampleSize = sampleSize.intValue();
        Number channels = (Number)map.get(Keyword.intern("channels"));
        if(channels == null)
            throw new IllegalArgumentException("Map needs key :channels");
        this.channels = channels.intValue();
        Object buffer = map.get(Keyword.intern("buffer"));
        if(buffer == null)
            throw new IllegalArgumentException("Map needs key :buffer");
        this.buffer = (RAudioBuffer.ByReference)buffer;
    }

    public AudioStream(Object obj){
        super();
        if(obj instanceof AudioStream){
            AudioStream as = (AudioStream)obj;
            this.sampleRate = as.sampleRate;
            this.sampleSize = as.sampleSize;
            this.channels = as.channels;
            this.buffer = as.buffer;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;

            Number sampleRate = (Number)map.get(Keyword.intern("sampleRate"));
            if(sampleRate == null)
                throw new IllegalArgumentException("Map needs key :sampleRate");
            this.sampleRate = sampleRate.intValue();
            Number sampleSize = (Number)map.get(Keyword.intern("sampleSize"));
            if(sampleSize == null)
                throw new IllegalArgumentException("Map needs key :sampleSize");
            this.sampleSize = sampleSize.intValue();
            Number channels = (Number)map.get(Keyword.intern("channels"));
            if(channels == null)
                throw new IllegalArgumentException("Map needs key :channels");
            this.channels = channels.intValue();
            Object buffer = map.get(Keyword.intern("buffer"));
            if(buffer == null)
                throw new IllegalArgumentException("Map needs key :buffer");
            this.buffer = (RAudioBuffer.ByReference)buffer;
        }else{
            throw new IllegalArgumentException("obj of unsupported type "+obj);
        }
    }


    public AudioStream(){
        super();
    }
}
