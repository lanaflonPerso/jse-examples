package core.collection.unmodified;

import java.util.List;

public class UnmodifiedList extends UnmodifiedListCollection {

    @SuppressWarnings("rawtypes")
    final List list;

    @SuppressWarnings("rawtypes")
    public UnmodifiedList(List list) {
        super(list);
        this.list = list;
    }

    public boolean add(Object arg0) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    // keep adding others methods.
}
