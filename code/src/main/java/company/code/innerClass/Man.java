package company.code.innerClass;

class People{
    public People() {

    }
}

class Man{

    public static void main(String[] args){

        Man man = new Man();
        man.getWoman();
    }

    public Man(){

    }

    public People getWoman(){
        class Woman extends People{   //局部内部类
            int age =0;
        }
        System.out.println(1);
        return new Woman();
    }
}
