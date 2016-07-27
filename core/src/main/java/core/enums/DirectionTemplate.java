package core.enums;

enum ENUM_WITH_METHOD {
    EAST(1) {
        public void directionMethod() {
            System.out.println("You are in direction EAST");
        }
    },
    WEST(2) {
        public void directionMethod() {
            System.out.println("You are in direction WEST");
        }
    },
    NORTH(3) {
        public void directionMethod() {
            System.out.println("You are in direction NORTH");
        }
    },
    SOUTH(4) {
        public void directionMethod() {
            System.out.println("You are in direction SOUTH");
            ;
        }
    };

    private int direction;

    private ENUM_WITH_METHOD(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public abstract void directionMethod();

}