package company.fanxing;

public class Box<T> {

    private T object;

    public T getObject() {
        return object;
    }


    public <T> T getT3(T t){
        return t;
    }



    public void setObject(T object) {
        this.object = object;
    }
}
