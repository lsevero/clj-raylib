package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.Pointer;
import clojure.lang.Keyword;
import clojure.lang.APersistentMap;

@FieldOrder({"sampleCount","sampleRate","sampleSize","channels","data"})
public class Wave extends Structure{
    public static class ByReference extends Wave implements Structure.ByReference{
        public ByReference(){
            super();
        }

        public ByReference(APersistentMap map){
            super(map);
        }

        public ByReference(ByReference br){
            super((Wave)br);
        }
        public ByReference(ByValue br){
            super((Wave)br);
        }
        public ByReference(Object obj){
            super(obj);
        }
    }

    public static class ByValue extends Wave implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(ByReference br){
            super((Wave)br);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }


    public int sampleCount;
    public int sampleRate;
    public int sampleSize;
    public int channels;
    public Pointer data;

    public Wave(APersistentMap map){
        super();
        Number sampleCount = (Number)map.get(Keyword.intern("sampleCount"));
        if(sampleCount == null)
            throw new IllegalArgumentException("Map needs key :sampleCount");
        this.sampleCount = sampleCount.intValue();
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
        Object data = map.get(Keyword.intern("data"));
        if(data == null)
            throw new IllegalArgumentException("Map needs key :data");
        this.data = (Pointer)data;
    }

    public Wave(int sampleCount, int sampleRate, int sampleSize, int channels, Pointer data){
        super();
        this.sampleCount = sampleCount;
        this.sampleRate = sampleRate;
        this.sampleSize = sampleSize;
        this.channels = channels;
        this.data = data;
    }

    public Wave(Wave w){
        super();
        this.sampleCount = w.sampleCount;
        this.sampleRate = w.sampleRate;
        this.sampleSize = w.sampleSize;
        this.channels = w.channels;
        this.data = w.data;
    }

    public Wave(Object obj) throws IllegalArgumentException{
        super();
        if(obj instanceof Wave){
            Wave w = (Wave)obj;
            this.sampleCount = w.sampleCount;
            this.sampleRate = w.sampleRate;
            this.sampleSize = w.sampleSize;
            this.channels = w.channels;
            this.data = w.data;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number sampleCount = (Number)map.get(Keyword.intern("sampleCount"));
            if(sampleCount == null)
                throw new IllegalArgumentException("Map needs key :sampleCount");
            this.sampleCount = sampleCount.intValue();
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
            Object data = map.get(Keyword.intern("data"));
            if(data == null)
                throw new IllegalArgumentException("Map needs key :data");
            this.data = (Pointer)data;
        }else{
            throw new IllegalArgumentException("obj of unsupported type "+obj);
        }
    }

    public Wave(){
        super();
    }
}
