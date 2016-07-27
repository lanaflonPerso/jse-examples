package core.designpattern.creation.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

    public static Map<Constant, Prototype> prototypeMap = new HashMap<Constant, Prototype>() {
        private static final long serialVersionUID = 5745283627312407231L;

        {
            put(Constant.VEGETABLE, new Vegetables());
            put(Constant.FRUITS, new Fruits());
            put(Constant.FLOWERS, new Flowers());
        }
    };

    public static Prototype getInstance(Constant constant) {
        return prototypeMap.get(constant);
    }

}
