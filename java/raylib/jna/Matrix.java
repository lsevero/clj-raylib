package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

@FieldOrder({"m0","m4","m8","m12",
             "m1","m5","m9","m13",
             "m2","m6","m10","m14",
             "m3","m7","m11","m15"})
public class Matrix extends Structure{
    public float m0, m4, m8, m12;
    public float m1, m5, m9, m13;
    public float m2, m6, m10, m14;
    public float m3, m7, m11, m15;

    public Matrix(float m0, float m4, float m8, float m12,
                   float m1, float m5, float m9, float m13,
                   float m2, float m6, float m10, float m14,
                   float m3, float m7, float m11, float m15){
        super();
        this.m0 = m0;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
        this.m7 = m7;
        this.m8 = m8;
        this.m9 = m9;
        this.m10 = m10;
        this.m11 = m11;
        this.m12 = m12;
        this.m13 = m13;
        this.m14 = m14;
        this.m15 = m15;
    }

    public Matrix(){
        super();
    }
}
