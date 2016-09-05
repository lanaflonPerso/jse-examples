package core.assignment;

public class PvtConst {
    private PvtConst() {

    }

    public PvtConst(int a) {
        // add this method else code wont compile
    }
}

class ExtPvtConst extends PvtConst {

    public ExtPvtConst(int a) {
        super(a);
    }

}
