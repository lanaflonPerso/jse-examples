package core.enums;

/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/

/**
 * ClientType enum is used to identify the client.
 */
public enum ClientType {

    PMIC("PM"), TOPOLOGY("TOPOLOGY"), UNKNOWN("UNKNOWN");

    private String client;

    ClientType(String client){
        this.client = client;
    }
    /**
     * This returns {@link #name()}
     *
     * @return String representation of enum constant
     */
    public String value() {
        return client;
    }

    public boolean equal(String type) {
        return this.value().equals(type);
    }

}
