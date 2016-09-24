package core.xml.vtd;

import java.io.File;
import java.io.FileInputStream;

import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

/**
 * VTD-XML: The Future of XML Processing TD-XML is the next generation XML
 * parser/indexer/editor/slicer/assembler/xpath-engine that goes beyond DOM, SAX and PULL in performance,
 * memory usage, and ease of use.
 *
 * http://vtd-xml.sourceforge.net/
 */
public class VTD {
    public static void main(String...args) {
        try {
            File f = new File("employee.xml");
            FileInputStream fis = new FileInputStream(f);
            byte[] ba = new byte[(int) f.length()];
            fis.read(ba);
            VTDGen vg = new VTDGen();
            vg.setDoc(ba);
            vg.parse(false);
            VTDNav vn = vg.getNav();
            if (vn.matchElement("Employee")) {
                System.out.println(vn.toString(vn.getAttrVal("name")));
                if (vn.toElement(VTDNav.FIRST_CHILD, "item")) {
                    if (vn.toElement(VTDNav.FIRST_CHILD)) {
                        do {
                            System.out.print(vn.toString(vn.getCurrentIndex()));
                            System.out.print("==>");
                            System.out.println(vn.toString(vn.getText()));
                        } while (vn.toElement(VTDNav.NEXT_SIBLING));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("exception occurred ==>" + e);
        }
    }
}
