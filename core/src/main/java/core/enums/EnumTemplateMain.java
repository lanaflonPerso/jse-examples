package core.enums;

public class EnumTemplateMain {

    public static void main(String...args) {
        ENUM_WITH_METHOD[] directions = ENUM_WITH_METHOD.values();
        for (ENUM_WITH_METHOD DIRECTION : directions) {
            System.out.println(DIRECTION.name());
            System.out.println(DIRECTION.getDirection());
            DIRECTION.directionMethod();
        }
    }
}