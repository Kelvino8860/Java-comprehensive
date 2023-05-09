public class TestLambda {
    public static void main(String[] args) throws Exception {

        TestLambda test = new TestLambda();

        test.setAction1(new T1() {
            @Override
            public void m1(){
                System.out.print("Action 1! ");
            }
        });

        test.setAction2(new T2() {
            @Override
            public void m2(Double d){
                System.out.println("Hello Kelvino");
            }
        });

        System.out.println(test.getValue(new T3() {
            @Override
            public int m3(int d1, int d2){
                 return d1 + d2;
            }
        }));
    }

    public void setAction1(T1 t) {
        t.m1();
    }

    public void setAction2(T2 t) {
        t.m2(4.5);
    }

    public int getValue(T3 t) {
        return t.m3(5, 2);
    }
}

@FunctionalInterface
interface T1 {
    public void m1();
}

@FunctionalInterface
interface T2 {
    public void m2(Double d);
}

@FunctionalInterface
interface T3 {
    public int m3(int d1, int d2);
}
