package core.java7.arm;

public class CustomAutomaticResourceManagementMain {
    public static void main(String...args) {
        try (CustomAutomaticResourceManagement arm = new CustomAutomaticResourceManagement();
                CustomAutomaticResourceManagement2 arm2 = new CustomAutomaticResourceManagement2()) {

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
