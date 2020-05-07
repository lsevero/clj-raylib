package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"hResolution","vResolution","hScreenSize","vScreenSize","vScreenCenter","eyeToScreenDistance","lensSeparationDistance",
             "interpupillaryDistance","lenDistortionValues","chromaAbCorrection"})
public class VrDeviceInfo extends Structure{
    public static class ByValue extends VrDeviceInfo implements Structure.ByValue{

        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(int hResolution, int vResolution, float hScreenSize, float vScreenSize, float vScreenCenter, float eyeToScreenDistance,
                 float lensSeparationDistance, float interpupillaryDistance, float[] lensDistortionValues, float[] chromaAbCorrection){
            super(hResolution, vResolution, hScreenSize, vScreenSize, vScreenCenter, eyeToScreenDistance,lensSeparationDistance,interpupillaryDistance, lensDistortionValues, chromaAbCorrection);
        }
    }

    public int hResolution;
    public int vResolution;
    public float hScreenSize;
    public float vScreenSize;
    public float vScreenCenter;
    public float eyeToScreenDistance;
    public float lensSeparationDistance;
    public float interpupillaryDistance;
    public float[] lensDistortionValues = new float[4];
    public float[] chromaAbCorrection = new float[4];

    public VrDeviceInfo(APersistentMap map) throws IllegalArgumentException{
        super();
        Number hResolution = (Number)map.get(Keyword.intern("hResolution"));
        if(hResolution == null)
            throw new IllegalArgumentException("Map needs key :hResolution");
        this.hResolution = hResolution.intValue();
        Number vResolution = (Number)map.get(Keyword.intern("vResolution"));
        if(vResolution == null)
            throw new IllegalArgumentException("Map needs key :vResolution");
        this.vResolution = vResolution.intValue();
        Number hScreenSize = (Number)map.get(Keyword.intern("hScreenSize"));
        if(hScreenSize == null)
            throw new IllegalArgumentException("Map needs key :hScreenSize");
        this.hScreenSize = hScreenSize.floatValue();
        Number vScreenSize = (Number)map.get(Keyword.intern("vScreenSize"));
        if(vScreenSize == null)
            throw new IllegalArgumentException("Map needs key :vScreenSize");
        this.vScreenSize = vScreenSize.floatValue();
        Number vScreenCenter = (Number)map.get(Keyword.intern("vScreenCenter"));
        if(vScreenCenter == null)
            throw new IllegalArgumentException("Map needs key :vScreenCenter");
        this.vScreenCenter = vScreenCenter.floatValue();
        Number eyeToScreenDistance = (Number)map.get(Keyword.intern("eyeToScreenDistance"));
        if(eyeToScreenDistance == null)
            throw new IllegalArgumentException("Map needs key :eyeToScreenDistance");
        this.eyeToScreenDistance = eyeToScreenDistance.floatValue();
        Number lensSeparationDistance = (Number)map.get(Keyword.intern("lensSeparationDistance"));
        if(lensSeparationDistance == null)
            throw new IllegalArgumentException("Map needs key :lensSeparationDistance");
        this.lensSeparationDistance = lensSeparationDistance.floatValue();
        Number interpupillaryDistance = (Number)map.get(Keyword.intern("interpupillaryDistance"));
        if(interpupillaryDistance == null)
            throw new IllegalArgumentException("Map needs key :interpupillaryDistance");
        this.interpupillaryDistance = interpupillaryDistance.floatValue();


        Object lensDistortionValues = map.get(Keyword.intern("lensDistortionValues"));
        if(lensDistortionValues == null)
            throw new IllegalArgumentException("Map needs key :lensDistortionValues");
        this.lensDistortionValues = (float[])lensDistortionValues;
        Object chromaAbCorrection = map.get(Keyword.intern("chromaAbCorrection"));
        if(chromaAbCorrection == null)
            throw new IllegalArgumentException("Map needs key :chromaAbCorrection");
        this.chromaAbCorrection = (float[])chromaAbCorrection;
    }


    public VrDeviceInfo(int hResolution, int vResolution, float hScreenSize, float vScreenSize, float vScreenCenter, float eyeToScreenDistance,
                 float lensSeparationDistance, float interpupillaryDistance, float[] lensDistortionValues, float[] chromaAbCorrection){
        super();
        this.hResolution = hResolution;
        this.vResolution = vResolution;
        this.hScreenSize = hScreenSize;
        this.vScreenSize = vScreenSize;
        this.vScreenCenter = vScreenCenter;
        this.eyeToScreenDistance = eyeToScreenDistance;
        this.lensSeparationDistance = lensSeparationDistance;
        this.interpupillaryDistance = interpupillaryDistance;
        this.lensDistortionValues = lensDistortionValues;
        this.chromaAbCorrection = chromaAbCorrection;
    }


    public VrDeviceInfo(){
        super();
    }
}
