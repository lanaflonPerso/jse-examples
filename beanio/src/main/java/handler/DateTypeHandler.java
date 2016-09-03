package handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.beanio.types.TypeConversionException;
import org.beanio.types.TypeHandler;
import org.testng.util.Strings;


public class DateTypeHandler implements TypeHandler {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Object parse(String text) throws TypeConversionException {
        if (Strings.isNullOrEmpty(text)) {
            return null;
        }
        try {
            return dateFormat.parse(text);
        } catch (ParseException ex) {
            throw new TypeConversionException(ex);
        }
    }

    @Override
    public String format(Object value) {
        if (value == null || value.toString().isEmpty()) {
            return "";
        }
        return dateFormat.format(value);
    }

    @Override
    public Class<?> getType() {
        return java.util.Date.class;
    }

}
