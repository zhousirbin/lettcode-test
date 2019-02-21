package company.memory;

public class ReferenceGc {
    public Object instance = null;
    public static void main(String[] args){
        ReferenceGc referenceGc = new ReferenceGc();
        ReferenceGc referenceGc1 = new ReferenceGc();
        referenceGc.instance=referenceGc1;
        referenceGc1.instance= referenceGc;

        referenceGc =null;
        referenceGc1=null;
        System.gc();
    }


}
