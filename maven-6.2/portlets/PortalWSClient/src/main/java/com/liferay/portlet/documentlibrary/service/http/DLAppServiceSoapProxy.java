package com.liferay.portlet.documentlibrary.service.http;

public class DLAppServiceSoapProxy implements com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoap {
  private String _endpoint = null;
  private com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoap dLAppServiceSoap = null;
  
  public DLAppServiceSoapProxy() {
    _initDLAppServiceSoapProxy();
  }
  
  public DLAppServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDLAppServiceSoapProxy();
  }
  
  private void _initDLAppServiceSoapProxy() {
    try {
      dLAppServiceSoap = (new com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoapServiceLocator()).getPortlet_DL_DLAppService();
      if (dLAppServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dLAppServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dLAppServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dLAppServiceSoap != null)
      ((javax.xml.rpc.Stub)dLAppServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoap getDLAppServiceSoap() {
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap;
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap addFileEntry(long repositoryId, long folderId, java.lang.String sourceFileName, java.lang.String mimeType, java.lang.String title, java.lang.String description, java.lang.String changeLog, byte[] bytes, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.addFileEntry(repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, bytes, serviceContext);
  }
  
  public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap addFileShortcut(long repositoryId, long folderId, long toFileEntryId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.addFileShortcut(repositoryId, folderId, toFileEntryId, serviceContext);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap addFolder(long repositoryId, long parentFolderId, java.lang.String name, java.lang.String description, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.addFolder(repositoryId, parentFolderId, name, description, serviceContext);
  }
  
  public void cancelCheckOut(long fileEntryId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.cancelCheckOut(fileEntryId);
  }
  
  public void checkInFileEntry(long fileEntryId, boolean majorVersion, java.lang.String changeLog, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.checkInFileEntry(fileEntryId, majorVersion, changeLog, serviceContext);
  }
  
  public void checkInFileEntry(long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.checkInFileEntry(fileEntryId, lockUuid);
  }
  
  public void checkInFileEntry(long fileEntryId, java.lang.String lockUuid, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.checkInFileEntry(fileEntryId, lockUuid, serviceContext);
  }
  
  public void checkOutFileEntry(long fileEntryId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.checkOutFileEntry(fileEntryId, serviceContext);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap checkOutFileEntry(long fileEntryId, java.lang.String owner, long expirationTime, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.checkOutFileEntry(fileEntryId, owner, expirationTime, serviceContext);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap copyFolder(long repositoryId, long sourceFolderId, long parentFolderId, java.lang.String name, java.lang.String description, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.copyFolder(repositoryId, sourceFolderId, parentFolderId, name, description, serviceContext);
  }
  
  public void deleteFileEntryByTitle(long repositoryId, long folderId, java.lang.String title) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteFileEntryByTitle(repositoryId, folderId, title);
  }
  
  public void deleteFileEntry(long fileEntryId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteFileEntry(fileEntryId);
  }
  
  public void deleteFileShortcut(long fileShortcutId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteFileShortcut(fileShortcutId);
  }
  
  public void deleteFileVersion(long fileEntryId, java.lang.String version) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteFileVersion(fileEntryId, version);
  }
  
  public void deleteFolder(long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteFolder(folderId);
  }
  
  public void deleteFolder(long repositoryId, long parentFolderId, java.lang.String name) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteFolder(repositoryId, parentFolderId, name);
  }
  
  public void deleteTempFileEntry(long groupId, long folderId, java.lang.String fileName, java.lang.String tempFolderName) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.deleteTempFileEntry(groupId, folderId, fileName, tempFolderName);
  }
  
  public int getFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntriesAndFileShortcutsCount(repositoryId, folderId, status);
  }
  
  public int getFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status, java.lang.String[] mimeTypes) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntriesAndFileShortcutsCount(repositoryId, folderId, status, mimeTypes);
  }
  
  public int getFileEntriesCount(long repositoryId, long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntriesCount(repositoryId, folderId);
  }
  
  public int getFileEntriesCount(long repositoryId, long folderId, long fileEntryTypeId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntriesCount(repositoryId, folderId, fileEntryTypeId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, java.lang.String[] mimeTypes) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId, mimeTypes);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId, start, end, obc);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, long fileEntryTypeId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId, fileEntryTypeId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, long fileEntryTypeId, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId, fileEntryTypeId, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, long fileEntryTypeId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntries(repositoryId, folderId, fileEntryTypeId, start, end, obc);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap getFileEntryByUuidAndGroupId(java.lang.String uuid, long groupId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntryByUuidAndGroupId(uuid, groupId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap getFileEntry(long fileEntryId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntry(fileEntryId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap getFileEntry(long groupId, long folderId, java.lang.String title) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileEntry(groupId, folderId, title);
  }
  
  public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap getFileShortcut(long fileShortcutId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFileShortcut(fileShortcutId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap getFolder(long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolder(folderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap getFolder(long repositoryId, long parentFolderId, java.lang.String name) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolder(repositoryId, parentFolderId, name);
  }
  
  public int getFoldersAndFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status, java.lang.String[] mimeTypes, boolean includeMountFolders) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFoldersAndFileEntriesAndFileShortcutsCount(repositoryId, folderId, status, mimeTypes, includeMountFolders);
  }
  
  public int getFoldersAndFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status, boolean includeMountFolders) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFoldersAndFileEntriesAndFileShortcutsCount(repositoryId, folderId, status, includeMountFolders);
  }
  
  public int getFoldersCount(long repositoryId, long parentFolderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFoldersCount(repositoryId, parentFolderId);
  }
  
  public int getFoldersCount(long repositoryId, long parentFolderId, boolean includeMountFolders) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFoldersCount(repositoryId, parentFolderId, includeMountFolders);
  }
  
  public int getFoldersCount(long repositoryId, long parentFolderId, int status, boolean includeMountFolders) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFoldersCount(repositoryId, parentFolderId, status, includeMountFolders);
  }
  
  public int getFoldersFileEntriesCount(long repositoryId, long[] folderIds, int status) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFoldersFileEntriesCount(repositoryId, folderIds, status);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, boolean includeMountFolders) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId, includeMountFolders);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, boolean includeMountFolders, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId, includeMountFolders, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, boolean includeMountFolders, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId, includeMountFolders, start, end, obc);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, int status, boolean includeMountFolders, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId, status, includeMountFolders, start, end, obc);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getFolders(repositoryId, parentFolderId, start, end, obc);
  }
  
  public int getGroupFileEntriesCount(long groupId, long userId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntriesCount(groupId, userId);
  }
  
  public int getGroupFileEntriesCount(long groupId, long userId, long rootFolderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntriesCount(groupId, userId, rootFolderId);
  }
  
  public int getGroupFileEntriesCount(long groupId, long userId, long rootFolderId, java.lang.String[] mimeTypes, int status) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntriesCount(groupId, userId, rootFolderId, mimeTypes, status);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntries(groupId, userId, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntries(groupId, userId, start, end, obc);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, long rootFolderId, java.lang.String[] mimeTypes, int status, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntries(groupId, userId, rootFolderId, mimeTypes, status, start, end, obc);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, long rootFolderId, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntries(groupId, userId, rootFolderId, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, long rootFolderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getGroupFileEntries(groupId, userId, rootFolderId, start, end, obc);
  }
  
  public int getMountFoldersCount(long repositoryId, long parentFolderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getMountFoldersCount(repositoryId, parentFolderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getMountFolders(long repositoryId, long parentFolderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getMountFolders(repositoryId, parentFolderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getMountFolders(long repositoryId, long parentFolderId, int start, int end) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getMountFolders(repositoryId, parentFolderId, start, end);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap[] getMountFolders(long repositoryId, long parentFolderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getMountFolders(repositoryId, parentFolderId, start, end, obc);
  }
  
  public void getSubfolderIds(long repositoryId, long[] folderIds, long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.getSubfolderIds(repositoryId, folderIds, folderId);
  }
  
  public long[] getSubfolderIds(long repositoryId, long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getSubfolderIds(repositoryId, folderId);
  }
  
  public long[] getSubfolderIds(long repositoryId, long folderId, boolean recurse) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getSubfolderIds(repositoryId, folderId, recurse);
  }
  
  public java.lang.String[] getTempFileEntryNames(long groupId, long folderId, java.lang.String tempFolderName) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.getTempFileEntryNames(groupId, folderId, tempFolderName);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap moveFileEntryFromTrash(long fileEntryId, long newFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFileEntryFromTrash(fileEntryId, newFolderId, serviceContext);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap moveFileEntryToTrash(long fileEntryId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFileEntryToTrash(fileEntryId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap moveFileEntry(long fileEntryId, long newFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFileEntry(fileEntryId, newFolderId, serviceContext);
  }
  
  public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap moveFileShortcutFromTrash(long fileShortcutId, long newFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFileShortcutFromTrash(fileShortcutId, newFolderId, serviceContext);
  }
  
  public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap moveFileShortcutToTrash(long fileShortcutId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFileShortcutToTrash(fileShortcutId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap moveFolderFromTrash(long folderId, long parentFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFolderFromTrash(folderId, parentFolderId, serviceContext);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap moveFolderToTrash(long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFolderToTrash(folderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap moveFolder(long folderId, long parentFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.moveFolder(folderId, parentFolderId, serviceContext);
  }
  
  public void restoreFileEntryFromTrash(long fileEntryId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.restoreFileEntryFromTrash(fileEntryId);
  }
  
  public void restoreFileShortcutFromTrash(long fileShortcutId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.restoreFileShortcutFromTrash(fileShortcutId);
  }
  
  public void restoreFolderFromTrash(long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.restoreFolderFromTrash(folderId);
  }
  
  public void revertFileEntry(long fileEntryId, java.lang.String version, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.revertFileEntry(fileEntryId, version, serviceContext);
  }
  
  public void subscribeFileEntryType(long groupId, long fileEntryTypeId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.subscribeFileEntryType(groupId, fileEntryTypeId);
  }
  
  public void subscribeFolder(long groupId, long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.subscribeFolder(groupId, folderId);
  }
  
  public void unlockFileEntry(long fileEntryId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.unlockFileEntry(fileEntryId);
  }
  
  public void unlockFileEntry(long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.unlockFileEntry(fileEntryId, lockUuid);
  }
  
  public void unlockFolder(long repositoryId, long folderId, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.unlockFolder(repositoryId, folderId, lockUuid);
  }
  
  public void unlockFolder(long repositoryId, long parentFolderId, java.lang.String name, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.unlockFolder(repositoryId, parentFolderId, name, lockUuid);
  }
  
  public void unsubscribeFileEntryType(long groupId, long fileEntryTypeId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.unsubscribeFileEntryType(groupId, fileEntryTypeId);
  }
  
  public void unsubscribeFolder(long groupId, long folderId) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    dLAppServiceSoap.unsubscribeFolder(groupId, folderId);
  }
  
  public com.liferay.portal.kernel.repository.model.FileEntrySoap updateFileEntry(long fileEntryId, java.lang.String sourceFileName, java.lang.String mimeType, java.lang.String title, java.lang.String description, java.lang.String changeLog, boolean majorVersion, byte[] bytes, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.updateFileEntry(fileEntryId, sourceFileName, mimeType, title, description, changeLog, majorVersion, bytes, serviceContext);
  }
  
  public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap updateFileShortcut(long fileShortcutId, long folderId, long toFileEntryId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.updateFileShortcut(fileShortcutId, folderId, toFileEntryId, serviceContext);
  }
  
  public com.liferay.portal.kernel.repository.model.FolderSoap updateFolder(long folderId, java.lang.String name, java.lang.String description, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.updateFolder(folderId, name, description, serviceContext);
  }
  
  public boolean verifyFileEntryCheckOut(long repositoryId, long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.verifyFileEntryCheckOut(repositoryId, fileEntryId, lockUuid);
  }
  
  public boolean verifyFileEntryLock(long repositoryId, long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.verifyFileEntryLock(repositoryId, fileEntryId, lockUuid);
  }
  
  public boolean verifyInheritableLock(long repositoryId, long folderId, java.lang.String lockUuid) throws java.rmi.RemoteException{
    if (dLAppServiceSoap == null)
      _initDLAppServiceSoapProxy();
    return dLAppServiceSoap.verifyInheritableLock(repositoryId, folderId, lockUuid);
  }
  
  
}