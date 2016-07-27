package core.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * http://mindprod.com/jgloss/phantom.html
 */
public class Reference {

    public static WeakReference<List> WeakReference(List reference){
        WeakReference<List> weakRef = new WeakReference<>(reference);
        return weakRef;
    }

    public static SoftReference<List> SoftReference(List reference){
        SoftReference<List> softRef = new SoftReference<>(reference);
        return softRef;
    }

    public static List StrongReference(List strongReference){
        return strongReference;
    }

    public static PhantomReference PhantomReference(List reference){
        PhantomReference<List> phantomRef = new PhantomReference<>(reference, new ReferenceQueue<>());
        return phantomRef;
    }
}
