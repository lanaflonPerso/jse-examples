package core.serialization;

import java.io.Serializable;

class SerializableClass implements Serializable {
    transient static final String firstname = "Himansu";
    transient static String thirdName = "Chaminda";
    static String fivthName = "Jeetu";
    transient final String secondName = "Dinesh";
    final String sixName = "Sergii";
    transient String forthName = "Anish";

    public String toString() {
        return this.firstname + " " + this.secondName + " " + this.thirdName + " " + this.forthName + " "
                + this.fivthName + " " + this.sixName;
    }
}
