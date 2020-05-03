package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"hResolution","vResolution","hScreenSize","vScreenSize","vScreenCenter","eyeToScreenDistance","lensSeparationDistance",
             "interpupillaryDistance","lenDistortionValues","chromaAbCorrection"})
public class VrDeviceInfo extends Structure{
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
