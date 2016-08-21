package core.anonymous;

public class AnonymousMain {

    // Type 1
    public static Hello helloOutside = new Hello(){
        @Override
        public  void sayHello(){
            System.out.println("Anonymous Class Inside Class");
        }
    };

    public static void main(String...args) {
        helloOutside.sayHello();

        // Type 2
        Hello helloInside = new Hello(){
            @Override
            public void sayHello(){
                System.out.println("Anonymous Class Inside Method");
            }
        };
        helloInside.sayHello();

        // Type 3
        Anonymous helloAnonymous = new Anonymous("Hello World"){
            @Override
            public void sayHello(){
                super.sayHello();
            }
        };
        helloAnonymous.sayHello();
    }

}
