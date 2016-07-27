package core.collection.custom.hashmap;

class Entry {
    final String key;
    String value;
    Entry next;

    public Entry(String k, String v) {
        key = k;
        value = v;
        next = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }
}
