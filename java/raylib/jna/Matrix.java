package raylib.jna;

import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import clojure.lang.APersistentVector;
import clojure.lang.APersistentMap;
import clojure.lang.Keyword;

@FieldOrder({"m0","m4","m8","m12",
"m1","m5","m9","m13",
"m2","m6","m10","m14",
"m3","m7","m11","m15"})
public class Matrix extends Structure{
    public static class ByValue extends Matrix implements Structure.ByValue{
        public ByValue(){
            super();
        }

        public ByValue(APersistentMap map){
            super(map);
        }

        public ByValue(APersistentVector v){
            super(v);
        }

        public ByValue(float m0, float m4, float m8, float m12,
                float m1, float m5, float m9, float m13,
                float m2, float m6, float m10, float m14,
                float m3, float m7, float m11, float m15){
            super( m0,  m4,  m8,  m12,
                    m1,  m5,  m9,  m13,
                    m2,  m6,  m10,  m14,
                    m3,  m7,  m11,  m15);
        }
        public ByValue(Object obj){
            super(obj);
        }
    }
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

    public Matrix(APersistentVector vec){
        super();
        if(vec.count() != 16)
            throw new IllegalArgumentException("PersistentVector needs to be of size 16");
        this.m0  = ((Number)vec.get(0)).floatValue();
        this.m4  = ((Number)vec.get(1)).floatValue();
        this.m8  = ((Number)vec.get(2)).floatValue();
        this.m12 = ((Number)vec.get(3)).floatValue();
        this.m1  = ((Number)vec.get(4)).floatValue();
        this.m5  = ((Number)vec.get(5)).floatValue();
        this.m9  = ((Number)vec.get(6)).floatValue();
        this.m13 = ((Number)vec.get(7)).floatValue();
        this.m2  = ((Number)vec.get(8)).floatValue();
        this.m6  = ((Number)vec.get(9)).floatValue();
        this.m10 = ((Number)vec.get(10)).floatValue();
        this.m14 = ((Number)vec.get(11)).floatValue();
        this.m3  = ((Number)vec.get(12)).floatValue();
        this.m7  = ((Number)vec.get(13)).floatValue();
        this.m11 = ((Number)vec.get(14)).floatValue();
        this.m15 = ((Number)vec.get(15)).floatValue();
    }

    public Matrix(Matrix m){
        super();
        this.m0 = m.m0;
        this.m1 = m.m1;
        this.m2 = m.m2;
        this.m3 = m.m3;
        this.m4 = m.m4;
        this.m5 = m.m5;
        this.m6 = m.m6;
        this.m7 = m.m7;
        this.m8 = m.m8;
        this.m9 = m.m9;
        this.m10 = m.m10;
        this.m11 = m.m11;
        this.m12 = m.m12;
        this.m13 = m.m13;
        this.m14 = m.m14;
        this.m15 = m.m15;

    }

    public Matrix(APersistentMap map){
        super();
        Number m0 = (Number)map.get(Keyword.intern("m0"));
        if(m0 == null)
            throw new IllegalArgumentException("Map needs key :m0");
        this.m0 = m0.floatValue();
        Number m1 = (Number)map.get(Keyword.intern("m1"));
        if(m1 == null)
            throw new IllegalArgumentException("Map needs key :m1");
        this.m1 = m1.floatValue();
        Number m2 = (Number)map.get(Keyword.intern("m2"));
        if(m2 == null)
            throw new IllegalArgumentException("Map needs key :m2");
        this.m2 = m2.floatValue();
        Number m3 = (Number)map.get(Keyword.intern("m3"));
        if(m3 == null)
            throw new IllegalArgumentException("Map needs key :m3");
        this.m3 = m3.floatValue();
        Number m4 = (Number)map.get(Keyword.intern("m4"));
        if(m4 == null)
            throw new IllegalArgumentException("Map needs key :m4");
        this.m4 = m4.floatValue();
        Number m5 = (Number)map.get(Keyword.intern("m5"));
        if(m5 == null)
            throw new IllegalArgumentException("Map needs key :m5");
        this.m5 = m5.floatValue();
        Number m6 = (Number)map.get(Keyword.intern("m6"));
        if(m6 == null)
            throw new IllegalArgumentException("Map needs key :m6");
        this.m6 = m6.floatValue();
        Number m7 = (Number)map.get(Keyword.intern("m7"));
        if(m7 == null)
            throw new IllegalArgumentException("Map needs key :m7");
        this.m7 = m7.floatValue();
        Number m8 = (Number)map.get(Keyword.intern("m8"));
        if(m8 == null)
            throw new IllegalArgumentException("Map needs key :m8");
        this.m8 = m8.floatValue();
        Number m9 = (Number)map.get(Keyword.intern("m9"));
        if(m9 == null)
            throw new IllegalArgumentException("Map needs key :m9");
        this.m9 = m9.floatValue();
        Number m10 = (Number)map.get(Keyword.intern("m10"));
        if(m10 == null)
            throw new IllegalArgumentException("Map needs key :m10");
        this.m10 = m10.floatValue();
        Number m11 = (Number)map.get(Keyword.intern("m11"));
        if(m11 == null)
            throw new IllegalArgumentException("Map needs key :m11");
        this.m11 = m11.floatValue();
        Number m12 = (Number)map.get(Keyword.intern("m12"));
        if(m12 == null)
            throw new IllegalArgumentException("Map needs key :m12");
        this.m12 = m12.floatValue();
        Number m13 = (Number)map.get(Keyword.intern("m13"));
        if(m13 == null)
            throw new IllegalArgumentException("Map needs key :m13");
        this.m13 = m13.floatValue();
        Number m14 = (Number)map.get(Keyword.intern("m14"));
        if(m14 == null)
            throw new IllegalArgumentException("Map needs key :m14");
        this.m14 = m14.floatValue();
        Number m15 = (Number)map.get(Keyword.intern("m15"));
        if(m15 == null)
            throw new IllegalArgumentException("Map needs key :m15");
        this.m15 = m15.floatValue();
    }

    public Matrix(Object obj){
        super();
        if(obj instanceof Matrix){
            Matrix m = (Matrix)obj;
            this.m0 = m.m0;
            this.m1 = m.m1;
            this.m2 = m.m2;
            this.m3 = m.m3;
            this.m4 = m.m4;
            this.m5 = m.m5;
            this.m6 = m.m6;
            this.m7 = m.m7;
            this.m8 = m.m8;
            this.m9 = m.m9;
            this.m10 = m.m10;
            this.m11 = m.m11;
            this.m12 = m.m12;
            this.m13 = m.m13;
            this.m14 = m.m14;
            this.m15 = m.m15;
        }else if(obj instanceof APersistentMap){
            APersistentMap map = (APersistentMap)obj;
            Number m0 = (Number)map.get(Keyword.intern("m0"));
            if(m0 == null)
                throw new IllegalArgumentException("Map needs key :m0");
            this.m0 = m0.floatValue();
            Number m1 = (Number)map.get(Keyword.intern("m1"));
            if(m1 == null)
                throw new IllegalArgumentException("Map needs key :m1");
            this.m1 = m1.floatValue();
            Number m2 = (Number)map.get(Keyword.intern("m2"));
            if(m2 == null)
                throw new IllegalArgumentException("Map needs key :m2");
            this.m2 = m2.floatValue();
            Number m3 = (Number)map.get(Keyword.intern("m3"));
            if(m3 == null)
                throw new IllegalArgumentException("Map needs key :m3");
            this.m3 = m3.floatValue();
            Number m4 = (Number)map.get(Keyword.intern("m4"));
            if(m4 == null)
                throw new IllegalArgumentException("Map needs key :m4");
            this.m4 = m4.floatValue();
            Number m5 = (Number)map.get(Keyword.intern("m5"));
            if(m5 == null)
                throw new IllegalArgumentException("Map needs key :m5");
            this.m5 = m5.floatValue();
            Number m6 = (Number)map.get(Keyword.intern("m6"));
            if(m6 == null)
                throw new IllegalArgumentException("Map needs key :m6");
            this.m6 = m6.floatValue();
            Number m7 = (Number)map.get(Keyword.intern("m7"));
            if(m7 == null)
                throw new IllegalArgumentException("Map needs key :m7");
            this.m7 = m7.floatValue();
            Number m8 = (Number)map.get(Keyword.intern("m8"));
            if(m8 == null)
                throw new IllegalArgumentException("Map needs key :m8");
            this.m8 = m8.floatValue();
            Number m9 = (Number)map.get(Keyword.intern("m9"));
            if(m9 == null)
                throw new IllegalArgumentException("Map needs key :m9");
            this.m9 = m9.floatValue();
            Number m10 = (Number)map.get(Keyword.intern("m10"));
            if(m10 == null)
                throw new IllegalArgumentException("Map needs key :m10");
            this.m10 = m10.floatValue();
            Number m11 = (Number)map.get(Keyword.intern("m11"));
            if(m11 == null)
                throw new IllegalArgumentException("Map needs key :m11");
            this.m11 = m11.floatValue();
            Number m12 = (Number)map.get(Keyword.intern("m12"));
            if(m12 == null)
                throw new IllegalArgumentException("Map needs key :m12");
            this.m12 = m12.floatValue();
            Number m13 = (Number)map.get(Keyword.intern("m13"));
            if(m13 == null)
                throw new IllegalArgumentException("Map needs key :m13");
            this.m13 = m13.floatValue();
            Number m14 = (Number)map.get(Keyword.intern("m14"));
            if(m14 == null)
                throw new IllegalArgumentException("Map needs key :m14");
            this.m14 = m14.floatValue();
            Number m15 = (Number)map.get(Keyword.intern("m15"));
            if(m15 == null)
                throw new IllegalArgumentException("Map needs key :m15");
            this.m15 = m15.floatValue();
        }
        else if (obj instanceof APersistentVector) {  
            APersistentVector vec = (APersistentVector)obj;
            if(vec.count() != 16)
                throw new IllegalArgumentException("PersistentVector needs to be of size 16");
            this.m0  = ((Number)vec.get(0)).floatValue();
            this.m4  = ((Number)vec.get(1)).floatValue();
            this.m8  = ((Number)vec.get(2)).floatValue();
            this.m12 = ((Number)vec.get(3)).floatValue();
            this.m1  = ((Number)vec.get(4)).floatValue();
            this.m5  = ((Number)vec.get(5)).floatValue();
            this.m9  = ((Number)vec.get(6)).floatValue();
            this.m13 = ((Number)vec.get(7)).floatValue();
            this.m2  = ((Number)vec.get(8)).floatValue();
            this.m6  = ((Number)vec.get(9)).floatValue();
            this.m10 = ((Number)vec.get(10)).floatValue();
            this.m14 = ((Number)vec.get(11)).floatValue();
            this.m3  = ((Number)vec.get(12)).floatValue();
            this.m7  = ((Number)vec.get(13)).floatValue();
            this.m11 = ((Number)vec.get(14)).floatValue();
            this.m15 = ((Number)vec.get(15)).floatValue();
        }else{
            throw new IllegalArgumentException("obj of unsupported type");
        }
    }

    public Matrix(){
        super();
    }
}
