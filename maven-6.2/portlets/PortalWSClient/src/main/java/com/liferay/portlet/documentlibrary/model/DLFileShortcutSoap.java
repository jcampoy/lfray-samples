/**
 * DLFileShortcutSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.liferay.portlet.documentlibrary.model;

public class DLFileShortcutSoap  implements java.io.Serializable {
    private boolean active;

    private long companyId;

    private java.util.Calendar createDate;

    private long fileShortcutId;

    private long folderId;

    private long groupId;

    private java.util.Calendar modifiedDate;

    private long primaryKey;

    private long repositoryId;

    private int status;

    private long statusByUserId;

    private java.lang.String statusByUserName;

    private java.util.Calendar statusDate;

    private long toFileEntryId;

    private java.lang.String treePath;

    private long userId;

    private java.lang.String userName;

    private java.lang.String uuid;

    public DLFileShortcutSoap() {
    }

    public DLFileShortcutSoap(
           boolean active,
           long companyId,
           java.util.Calendar createDate,
           long fileShortcutId,
           long folderId,
           long groupId,
           java.util.Calendar modifiedDate,
           long primaryKey,
           long repositoryId,
           int status,
           long statusByUserId,
           java.lang.String statusByUserName,
           java.util.Calendar statusDate,
           long toFileEntryId,
           java.lang.String treePath,
           long userId,
           java.lang.String userName,
           java.lang.String uuid) {
           this.active = active;
           this.companyId = companyId;
           this.createDate = createDate;
           this.fileShortcutId = fileShortcutId;
           this.folderId = folderId;
           this.groupId = groupId;
           this.modifiedDate = modifiedDate;
           this.primaryKey = primaryKey;
           this.repositoryId = repositoryId;
           this.status = status;
           this.statusByUserId = statusByUserId;
           this.statusByUserName = statusByUserName;
           this.statusDate = statusDate;
           this.toFileEntryId = toFileEntryId;
           this.treePath = treePath;
           this.userId = userId;
           this.userName = userName;
           this.uuid = uuid;
    }


    /**
     * Gets the active value for this DLFileShortcutSoap.
     * 
     * @return active
     */
    public boolean isActive() {
        return active;
    }


    /**
     * Sets the active value for this DLFileShortcutSoap.
     * 
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Gets the companyId value for this DLFileShortcutSoap.
     * 
     * @return companyId
     */
    public long getCompanyId() {
        return companyId;
    }


    /**
     * Sets the companyId value for this DLFileShortcutSoap.
     * 
     * @param companyId
     */
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }


    /**
     * Gets the createDate value for this DLFileShortcutSoap.
     * 
     * @return createDate
     */
    public java.util.Calendar getCreateDate() {
        return createDate;
    }


    /**
     * Sets the createDate value for this DLFileShortcutSoap.
     * 
     * @param createDate
     */
    public void setCreateDate(java.util.Calendar createDate) {
        this.createDate = createDate;
    }


    /**
     * Gets the fileShortcutId value for this DLFileShortcutSoap.
     * 
     * @return fileShortcutId
     */
    public long getFileShortcutId() {
        return fileShortcutId;
    }


    /**
     * Sets the fileShortcutId value for this DLFileShortcutSoap.
     * 
     * @param fileShortcutId
     */
    public void setFileShortcutId(long fileShortcutId) {
        this.fileShortcutId = fileShortcutId;
    }


    /**
     * Gets the folderId value for this DLFileShortcutSoap.
     * 
     * @return folderId
     */
    public long getFolderId() {
        return folderId;
    }


    /**
     * Sets the folderId value for this DLFileShortcutSoap.
     * 
     * @param folderId
     */
    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }


    /**
     * Gets the groupId value for this DLFileShortcutSoap.
     * 
     * @return groupId
     */
    public long getGroupId() {
        return groupId;
    }


    /**
     * Sets the groupId value for this DLFileShortcutSoap.
     * 
     * @param groupId
     */
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }


    /**
     * Gets the modifiedDate value for this DLFileShortcutSoap.
     * 
     * @return modifiedDate
     */
    public java.util.Calendar getModifiedDate() {
        return modifiedDate;
    }


    /**
     * Sets the modifiedDate value for this DLFileShortcutSoap.
     * 
     * @param modifiedDate
     */
    public void setModifiedDate(java.util.Calendar modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


    /**
     * Gets the primaryKey value for this DLFileShortcutSoap.
     * 
     * @return primaryKey
     */
    public long getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this DLFileShortcutSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the repositoryId value for this DLFileShortcutSoap.
     * 
     * @return repositoryId
     */
    public long getRepositoryId() {
        return repositoryId;
    }


    /**
     * Sets the repositoryId value for this DLFileShortcutSoap.
     * 
     * @param repositoryId
     */
    public void setRepositoryId(long repositoryId) {
        this.repositoryId = repositoryId;
    }


    /**
     * Gets the status value for this DLFileShortcutSoap.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this DLFileShortcutSoap.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the statusByUserId value for this DLFileShortcutSoap.
     * 
     * @return statusByUserId
     */
    public long getStatusByUserId() {
        return statusByUserId;
    }


    /**
     * Sets the statusByUserId value for this DLFileShortcutSoap.
     * 
     * @param statusByUserId
     */
    public void setStatusByUserId(long statusByUserId) {
        this.statusByUserId = statusByUserId;
    }


    /**
     * Gets the statusByUserName value for this DLFileShortcutSoap.
     * 
     * @return statusByUserName
     */
    public java.lang.String getStatusByUserName() {
        return statusByUserName;
    }


    /**
     * Sets the statusByUserName value for this DLFileShortcutSoap.
     * 
     * @param statusByUserName
     */
    public void setStatusByUserName(java.lang.String statusByUserName) {
        this.statusByUserName = statusByUserName;
    }


    /**
     * Gets the statusDate value for this DLFileShortcutSoap.
     * 
     * @return statusDate
     */
    public java.util.Calendar getStatusDate() {
        return statusDate;
    }


    /**
     * Sets the statusDate value for this DLFileShortcutSoap.
     * 
     * @param statusDate
     */
    public void setStatusDate(java.util.Calendar statusDate) {
        this.statusDate = statusDate;
    }


    /**
     * Gets the toFileEntryId value for this DLFileShortcutSoap.
     * 
     * @return toFileEntryId
     */
    public long getToFileEntryId() {
        return toFileEntryId;
    }


    /**
     * Sets the toFileEntryId value for this DLFileShortcutSoap.
     * 
     * @param toFileEntryId
     */
    public void setToFileEntryId(long toFileEntryId) {
        this.toFileEntryId = toFileEntryId;
    }


    /**
     * Gets the treePath value for this DLFileShortcutSoap.
     * 
     * @return treePath
     */
    public java.lang.String getTreePath() {
        return treePath;
    }


    /**
     * Sets the treePath value for this DLFileShortcutSoap.
     * 
     * @param treePath
     */
    public void setTreePath(java.lang.String treePath) {
        this.treePath = treePath;
    }


    /**
     * Gets the userId value for this DLFileShortcutSoap.
     * 
     * @return userId
     */
    public long getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this DLFileShortcutSoap.
     * 
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }


    /**
     * Gets the userName value for this DLFileShortcutSoap.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this DLFileShortcutSoap.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }


    /**
     * Gets the uuid value for this DLFileShortcutSoap.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this DLFileShortcutSoap.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DLFileShortcutSoap)) return false;
        DLFileShortcutSoap other = (DLFileShortcutSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.active == other.isActive() &&
            this.companyId == other.getCompanyId() &&
            ((this.createDate==null && other.getCreateDate()==null) || 
             (this.createDate!=null &&
              this.createDate.equals(other.getCreateDate()))) &&
            this.fileShortcutId == other.getFileShortcutId() &&
            this.folderId == other.getFolderId() &&
            this.groupId == other.getGroupId() &&
            ((this.modifiedDate==null && other.getModifiedDate()==null) || 
             (this.modifiedDate!=null &&
              this.modifiedDate.equals(other.getModifiedDate()))) &&
            this.primaryKey == other.getPrimaryKey() &&
            this.repositoryId == other.getRepositoryId() &&
            this.status == other.getStatus() &&
            this.statusByUserId == other.getStatusByUserId() &&
            ((this.statusByUserName==null && other.getStatusByUserName()==null) || 
             (this.statusByUserName!=null &&
              this.statusByUserName.equals(other.getStatusByUserName()))) &&
            ((this.statusDate==null && other.getStatusDate()==null) || 
             (this.statusDate!=null &&
              this.statusDate.equals(other.getStatusDate()))) &&
            this.toFileEntryId == other.getToFileEntryId() &&
            ((this.treePath==null && other.getTreePath()==null) || 
             (this.treePath!=null &&
              this.treePath.equals(other.getTreePath()))) &&
            this.userId == other.getUserId() &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName()))) &&
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isActive() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Long(getCompanyId()).hashCode();
        if (getCreateDate() != null) {
            _hashCode += getCreateDate().hashCode();
        }
        _hashCode += new Long(getFileShortcutId()).hashCode();
        _hashCode += new Long(getFolderId()).hashCode();
        _hashCode += new Long(getGroupId()).hashCode();
        if (getModifiedDate() != null) {
            _hashCode += getModifiedDate().hashCode();
        }
        _hashCode += new Long(getPrimaryKey()).hashCode();
        _hashCode += new Long(getRepositoryId()).hashCode();
        _hashCode += getStatus();
        _hashCode += new Long(getStatusByUserId()).hashCode();
        if (getStatusByUserName() != null) {
            _hashCode += getStatusByUserName().hashCode();
        }
        if (getStatusDate() != null) {
            _hashCode += getStatusDate().hashCode();
        }
        _hashCode += new Long(getToFileEntryId()).hashCode();
        if (getTreePath() != null) {
            _hashCode += getTreePath().hashCode();
        }
        _hashCode += new Long(getUserId()).hashCode();
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DLFileShortcutSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.documentlibrary.portlet.liferay.com", "DLFileShortcutSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("active");
        elemField.setXmlName(new javax.xml.namespace.QName("", "active"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fileShortcutId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fileShortcutId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folderId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifiedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifiedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repositoryId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "repositoryId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusByUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusByUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusByUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusByUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "statusDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toFileEntryId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toFileEntryId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("treePath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "treePath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
