package com.org.puzzle;

public class AccessModifier {

   public String pubField;

    String dftField;

    private String pvtfield;

    protected String prtField;

    public String getPubField() {
        return pubField;
    }

    String getDftField() {
        return dftField;
    }

    private String getPvtfield() {
        return pvtfield;
    }

    protected String getPrtField() {
        return prtField;
    }
}
