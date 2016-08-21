package core.anonymous;

class Anonymous {
    private String string;

    public Anonymous(String string) {
        this.string = string;
    }

    public void sayHello() {
        System.out.println("Anonymous : " + string);
    }
}