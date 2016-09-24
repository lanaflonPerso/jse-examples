package core.pojo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class CtumFileCollectionConfig {

    private static final Field[] declaredFields;

    static {
        declaredFields = CtumFileCollectionConfig.class.getDeclaredFields();
    }

    private String fileTypePrefix;
    private String logFileTypeFilter;
    private String sourceFileRopStartDateFormat;
    private String sourceFileRopStartTimeFormat;
    private Boolean decompressionRequired;
    private Boolean isRecovery;
    private String sourceDirectory;
    private String destinationDirectory;
    private String[] availableDestinationDirectories;
    private Map<String, String> destAndSourceFileNames;
    private TimeZone nodeTimeZone;
    private String destTimeZone;
    private String setUpFilter;

    public String getFileTypePrefix() {
        return fileTypePrefix;
    }

    public void setFileTypePrefix(final String fileTypePrefix) {
        this.fileTypePrefix = fileTypePrefix;
    }

    public String getLogFileTypeFilter() {
        return logFileTypeFilter;
    }

    public void setLogFileTypeFilter(final String logFileTypeFilter) {
        this.logFileTypeFilter = logFileTypeFilter;
    }

    public String getSourceFileRopStartDateFormat() {
        return sourceFileRopStartDateFormat;
    }

    public void setSourceFileRopStartDateFormat(final String sourceFileRopStartDateFormat) {
        this.sourceFileRopStartDateFormat = sourceFileRopStartDateFormat;
    }

    public String getSourceFileRopStartTimeFormat() {
        return sourceFileRopStartTimeFormat;
    }

    public void setSourceFileRopStartTimeFormat(final String sourceFileRopStartTimeFormat) {
        this.sourceFileRopStartTimeFormat = sourceFileRopStartTimeFormat;
    }

    public String[] getAvailableDestinationDirectories() {
        return availableDestinationDirectories;
    }

    public void setAvailableDestinationDirectories(final String...argsavailableDestinationDirectories) {
        this.availableDestinationDirectories = availableDestinationDirectories;
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public void setDestinationDirectory(final String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public Boolean getDecompressionRequired() {
        return decompressionRequired;
    }

    public void setDecompressionRequired(final Boolean decompressionRequired) {
        this.decompressionRequired = decompressionRequired;
    }

    public Boolean getIsRecovery() {
        return isRecovery;
    }

    public void setRecovery(final Boolean isRecovery) {
        this.isRecovery = isRecovery;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(final String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public TimeZone getNodeTimeZone() {
        return nodeTimeZone;
    }

    public void setNodeTimeZone(final TimeZone nodeTimeZone) {
        this.nodeTimeZone = nodeTimeZone;
    }

    public String getSetUpFilter() {
        return setUpFilter;
    }

    public void setSetUpFilter(final String setUpFilter) {
        this.setUpFilter = setUpFilter;
    }

    public String getDestTimeZone() {
        return destTimeZone;
    }

    public void setDestTimeZone(final String destTimeZone) {
        this.destTimeZone = destTimeZone;
    }

    public Map<String, String> getDestAndSourceFileNames() {
        return destAndSourceFileNames;
    }

    public void setDestAndSourceFileNames(final Map<String, String> destAndSourceFileNames) {
        this.destAndSourceFileNames = destAndSourceFileNames;
    }

    public Map<String, Object> asMapOfAttributes() {
        final Map<String, Object> mapOfAttributes = new HashMap<>();
        for (final Field field : declaredFields) {
            try {
                mapOfAttributes.put(field.getName(), field.get(this));
            } catch (IllegalAccessException exception) {
            }
        }
        return mapOfAttributes;
    }
}
