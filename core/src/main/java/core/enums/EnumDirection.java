package core.enums;

enum DIRECTION {
    EAST(1), WEST(2), NORTH(3), SOUTH(4);

    private int direction;

    private DIRECTION(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}