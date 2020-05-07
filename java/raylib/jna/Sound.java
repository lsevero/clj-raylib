package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import raylib.jna.AudioStream;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"sampleCount","stream"})
public class Sound extends Structure{
    public static class ByValue extends Sound implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int sampleCount, AudioStream stream){
            super(sampleCount, stream);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }

    public int sampleCount;
    public AudioStream stream;

    public Sound(APersistentMap map){
        super();
        Number sampleCount = (Number)map.get(Keyword.intern("sampleCount"));
        if(sampleCount == null)
            throw new IllegalArgumentException("Map needs key :sampleCount");
        this.sampleCount = sampleCount.intValue();


        Object stream = map.get(Keyword.intern("stream"));
        if(stream == null)
            throw new IllegalArgumentException("Map needs key :stream");
        if(stream instanceof APersistentMap){
            this.stream = new AudioStream((APersistentMap)stream);
        }
        else if(stream instanceof AudioStream){
            this.stream = new AudioStream((AudioStream)stream);
        }
        else{
            throw new IllegalArgumentException(":stream is of unsupported type");
        }
    }

    public Sound(int sampleCount, AudioStream stream){
        super();
        this.sampleCount = sampleCount;
        this.stream = stream;
    }

    public Sound(Sound s){
        super();
        this.sampleCount = s.sampleCount;
        this.stream = new AudioStream(s.stream);
    }

    public Sound(Object obj) throws IllegalArgumentException{
        super();
        if(obj instanceof Sound){
            Sound s = (Sound)obj;
            this.sampleCount = s.sampleCount;
            this.stream = new AudioStream(s.stream);
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number sampleCount = (Number)map.get(Keyword.intern("sampleCount"));
            if(sampleCount == null)
                throw new IllegalArgumentException("Map needs key :sampleCount");
            this.sampleCount = sampleCount.intValue();


            Object stream = map.get(Keyword.intern("stream"));
            if(stream == null)
                throw new IllegalArgumentException("Map needs key :stream");
            if(stream instanceof APersistentMap){
                this.stream = new AudioStream((APersistentMap)stream);
            }
            else if(stream instanceof AudioStream){
                this.stream = new AudioStream((AudioStream)stream);
            }
            else{
                throw new IllegalArgumentException(":stream is of unsupported type");
            }
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }
    }

    public Sound(){
        super();
    }
}
