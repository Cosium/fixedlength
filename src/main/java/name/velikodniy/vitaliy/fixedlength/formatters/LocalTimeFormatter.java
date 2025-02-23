package name.velikodniy.vitaliy.fixedlength.formatters;

import name.velikodniy.vitaliy.fixedlength.annotation.FixedField;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeFormatter extends Formatter<LocalTime> {

    private static final String DEFAULT_FORMAT = "HHmmss";

    private static DateTimeFormatter format(FixedField field) {
        String format;
        if (!field.format().isEmpty()) {
            format = field.format();
        } else {
            format = DEFAULT_FORMAT;
        }
        return DateTimeFormatter.ofPattern(format);
    }

    @Override
    public LocalTime asObject(String string, FixedField field) {
        return LocalTime.parse(string, format(field));
    }

    @Override
    public String asString(LocalTime object, FixedField field) {
        return object.format(format(field));
    }
}
