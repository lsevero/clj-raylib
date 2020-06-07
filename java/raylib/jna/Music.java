package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Pointer;
import raylib.jna.AudioStream;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"ctxType","ctxData","sampleCount","loopCount","stream"})
public class Music extends Structure{
    public static class ByValue extends Music implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int ctxType, Pointer ctxData, int sampleCount, int loopCount, AudioStream stream){
            super(ctxType,ctxData,sampleCount,loopCount,stream);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }

    public int ctxType;
    public Pointer ctxData;
    public int sampleCount;
    public int loopCount;
    public AudioStream stream;

    public Music(APersistentMap map){
        super();
        Number ctxType = (Number)map.get(Keyword.intern("ctxType"));
        if(ctxType == null)
            throw new IllegalArgumentException("Map needs key :ctxType");
        this.ctxType = ctxType.intValue();

        Object ctxData = map.get(Keyword.intern("ctxData"));
        if(ctxData == null)
            throw new IllegalArgumentException("Map needs key :ctxData");
        this.ctxData = (Pointer)ctxData;

        Number sampleCount = (Number)map.get(Keyword.intern("sampleCount"));
        if(sampleCount == null)
            throw new IllegalArgumentException("Map needs key :sampleCount");
        this.sampleCount = sampleCount.intValue();

        Number loopCount = (Number)map.get(Keyword.intern("loopCount"));
        if(loopCount == null)
            throw new IllegalArgumentException("Map needs key :loopCount");
        this.loopCount = loopCount.intValue();

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

    public Music(int ctxType, Pointer ctxData, int sampleCount, int loopCount, AudioStream stream){
        super();
        this.ctxType = ctxType;
        this.ctxData = ctxData;
        this.sampleCount = sampleCount;
        this.loopCount = loopCount;
        this.stream = stream;
    }

    public Music(Music m){
        super();
        this.ctxType = m.ctxType;
        this.ctxData = m.ctxData;
        this.sampleCount = m.sampleCount;
        this.loopCount = m.loopCount;
        this.stream = new AudioStream(m.stream);
    }
    public Music(Object obj){
        super();
        if(obj instanceof Music){
            Music m = (Music)obj;
            this.ctxType = m.ctxType;
            this.ctxData = m.ctxData;
            this.sampleCount = m.sampleCount;
            this.loopCount = m.loopCount;
            this.stream = new AudioStream(m.stream);
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number ctxType = (Number)map.get(Keyword.intern("ctxType"));
            if(ctxType == null)
                throw new IllegalArgumentException("Map needs key :ctxType");
            this.ctxType = ctxType.intValue();

            Object ctxData = map.get(Keyword.intern("ctxData"));
            if(ctxData == null)
                throw new IllegalArgumentException("Map needs key :ctxData");
            this.ctxData = (Pointer)ctxData;

            Number sampleCount = (Number)map.get(Keyword.intern("sampleCount"));
            if(sampleCount == null)
                throw new IllegalArgumentException("Map needs key :sampleCount");
            this.sampleCount = sampleCount.intValue();

            Number loopCount = (Number)map.get(Keyword.intern("loopCount"));
            if(loopCount == null)
                throw new IllegalArgumentException("Map needs key :loopCount");
            this.loopCount = loopCount.intValue();

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
            throw new IllegalArgumentException("obj of unsupported type "+obj);
        }
    }
    public Music(){
        super();
    }
}
