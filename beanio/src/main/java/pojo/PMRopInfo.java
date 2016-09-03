package pojo;/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2016
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
import java.io.Serializable;
import java.util.Date;

/**
 * Data about every detected {@link PMRopInfo} is exposed in format of this POJO.
 *
 * @author ehimnay
 */
public class PMRopInfo implements Serializable {

    private String nodeName;
    private String nodeType;
    private String dataType;
    private String fileType;
    private String fileSize;
    private String fileLocation;
    private Date fileCreationTimeInOss;
    private Date startRopTimeInOss;
    private Date endRopTimeInOss;


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Date getEndRopTimeInOss() {
        return endRopTimeInOss;
    }

    public void setEndRopTimeInOss(Date endRopTimeInOss) {
        this.endRopTimeInOss = endRopTimeInOss;
    }

    public Date getFileCreationTimeInOss() {
        return fileCreationTimeInOss;
    }

    public void setFileCreationTimeInOss(Date fileCreationTimeInOss) {
        this.fileCreationTimeInOss = fileCreationTimeInOss;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public Date getStartRopTimeInOss() {
        return startRopTimeInOss;
    }

    public void setStartRopTimeInOss(Date startRopTimeInOss) {
        this.startRopTimeInOss = startRopTimeInOss;
    }

    @Override
    public String toString() {
        return "pojo.PMRopInfo [nodeName=" + nodeName
                + ", nodeType=" + nodeType
                + ", dataType=" + dataType
                + ", fileType=" + fileType
                + ", fileSize=" + fileSize
                + ", fileLocation=" + fileLocation
                + ", fileCreationTimeInOss=" + fileCreationTimeInOss
                + ", startRopTimeInOss=" + startRopTimeInOss
                + ", endRopTimeInOss=" + endRopTimeInOss + "]";
    }

}