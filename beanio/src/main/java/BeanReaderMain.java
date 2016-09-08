import java.util.ArrayList;
import java.util.List;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

/**
 * http://www.beanio.org/
 * http://www.beanio.org/2.0/docs/reference/index.html#DelimitedStreamFormat
 */
public class BeanReaderMain {

    public static void main(String...args) {
        BeanReaderMain br = new BeanReaderMain();
        List<Object> records = br.beanReader("C:\\Mercury\\github\\jse-examples\\beanio\\src\\main\\resources\\data.csv", "model/pmRopInfo.xml");
        for(Object record :  records){
            System.out.println(record);
        }
    }

    public List<Object> beanReader(final String resource, final String model) {
        StreamFactory factory = StreamFactory.newInstance();
        factory.load(loadResource(model));
        BeanReader beanReader = null;
        final List<Object> recordList = new ArrayList<>();
        try {
            beanReader = factory.createReader("data", resource);
            Object record;
            while ((record = beanReader.read()) != null) {
                recordList.add(record);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }
        return recordList;
    }

    public String fileNameWithoutExt(final String fileName){
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public String loadResource(String resource){
        return Thread.currentThread().getContextClassLoader().getResource(resource).getFile();
    }
}