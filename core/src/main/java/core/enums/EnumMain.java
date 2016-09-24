package core.enums;

public class EnumMain {
    public static void main(String...args) {
        DIRECTION[] DIRECTIONs = DIRECTION.values();
        for (DIRECTION DIRECTION : DIRECTIONs) {
            System.out.println(DIRECTION.name());
            System.out.println(DIRECTION.getDirection());

        }

        ClientType client = ClientType.PMIC;
        System.out.println(client.name());
        System.out.println(client.value());
        System.out.println(client.equal("PMIC"));
    }
}