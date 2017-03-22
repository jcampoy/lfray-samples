/**
 * DLAppServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.liferay.portlet.documentlibrary.service.http;

public interface DLAppServiceSoap extends java.rmi.Remote {
    public com.liferay.portal.kernel.repository.model.FileEntrySoap addFileEntry(long repositoryId, long folderId, java.lang.String sourceFileName, java.lang.String mimeType, java.lang.String title, java.lang.String description, java.lang.String changeLog, byte[] bytes, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap addFileShortcut(long repositoryId, long folderId, long toFileEntryId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap addFolder(long repositoryId, long parentFolderId, java.lang.String name, java.lang.String description, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void cancelCheckOut(long fileEntryId) throws java.rmi.RemoteException;
    public void checkInFileEntry(long fileEntryId, boolean majorVersion, java.lang.String changeLog, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void checkInFileEntry(long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException;
    public void checkInFileEntry(long fileEntryId, java.lang.String lockUuid, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void checkOutFileEntry(long fileEntryId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap checkOutFileEntry(long fileEntryId, java.lang.String owner, long expirationTime, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap copyFolder(long repositoryId, long sourceFolderId, long parentFolderId, java.lang.String name, java.lang.String description, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void deleteFileEntryByTitle(long repositoryId, long folderId, java.lang.String title) throws java.rmi.RemoteException;
    public void deleteFileEntry(long fileEntryId) throws java.rmi.RemoteException;
    public void deleteFileShortcut(long fileShortcutId) throws java.rmi.RemoteException;
    public void deleteFileVersion(long fileEntryId, java.lang.String version) throws java.rmi.RemoteException;
    public void deleteFolder(long folderId) throws java.rmi.RemoteException;
    public void deleteFolder(long repositoryId, long parentFolderId, java.lang.String name) throws java.rmi.RemoteException;
    public void deleteTempFileEntry(long groupId, long folderId, java.lang.String fileName, java.lang.String tempFolderName) throws java.rmi.RemoteException;
    public int getFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status) throws java.rmi.RemoteException;
    public int getFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status, java.lang.String[] mimeTypes) throws java.rmi.RemoteException;
    public int getFileEntriesCount(long repositoryId, long folderId) throws java.rmi.RemoteException;
    public int getFileEntriesCount(long repositoryId, long folderId, long fileEntryTypeId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, java.lang.String[] mimeTypes) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, long fileEntryTypeId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, long fileEntryTypeId, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getFileEntries(long repositoryId, long folderId, long fileEntryTypeId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap getFileEntryByUuidAndGroupId(java.lang.String uuid, long groupId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap getFileEntry(long fileEntryId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap getFileEntry(long groupId, long folderId, java.lang.String title) throws java.rmi.RemoteException;
    public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap getFileShortcut(long fileShortcutId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap getFolder(long folderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap getFolder(long repositoryId, long parentFolderId, java.lang.String name) throws java.rmi.RemoteException;
    public int getFoldersAndFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status, java.lang.String[] mimeTypes, boolean includeMountFolders) throws java.rmi.RemoteException;
    public int getFoldersAndFileEntriesAndFileShortcutsCount(long repositoryId, long folderId, int status, boolean includeMountFolders) throws java.rmi.RemoteException;
    public int getFoldersCount(long repositoryId, long parentFolderId) throws java.rmi.RemoteException;
    public int getFoldersCount(long repositoryId, long parentFolderId, boolean includeMountFolders) throws java.rmi.RemoteException;
    public int getFoldersCount(long repositoryId, long parentFolderId, int status, boolean includeMountFolders) throws java.rmi.RemoteException;
    public int getFoldersFileEntriesCount(long repositoryId, long[] folderIds, int status) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, boolean includeMountFolders) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, boolean includeMountFolders, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, boolean includeMountFolders, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, int status, boolean includeMountFolders, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getFolders(long repositoryId, long parentFolderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public int getGroupFileEntriesCount(long groupId, long userId) throws java.rmi.RemoteException;
    public int getGroupFileEntriesCount(long groupId, long userId, long rootFolderId) throws java.rmi.RemoteException;
    public int getGroupFileEntriesCount(long groupId, long userId, long rootFolderId, java.lang.String[] mimeTypes, int status) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, long rootFolderId, java.lang.String[] mimeTypes, int status, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, long rootFolderId, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap[] getGroupFileEntries(long groupId, long userId, long rootFolderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public int getMountFoldersCount(long repositoryId, long parentFolderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getMountFolders(long repositoryId, long parentFolderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getMountFolders(long repositoryId, long parentFolderId, int start, int end) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap[] getMountFolders(long repositoryId, long parentFolderId, int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) throws java.rmi.RemoteException;
    public void getSubfolderIds(long repositoryId, long[] folderIds, long folderId) throws java.rmi.RemoteException;
    public long[] getSubfolderIds(long repositoryId, long folderId) throws java.rmi.RemoteException;
    public long[] getSubfolderIds(long repositoryId, long folderId, boolean recurse) throws java.rmi.RemoteException;
    public java.lang.String[] getTempFileEntryNames(long groupId, long folderId, java.lang.String tempFolderName) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap moveFileEntryFromTrash(long fileEntryId, long newFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap moveFileEntryToTrash(long fileEntryId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap moveFileEntry(long fileEntryId, long newFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap moveFileShortcutFromTrash(long fileShortcutId, long newFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap moveFileShortcutToTrash(long fileShortcutId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap moveFolderFromTrash(long folderId, long parentFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap moveFolderToTrash(long folderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap moveFolder(long folderId, long parentFolderId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void restoreFileEntryFromTrash(long fileEntryId) throws java.rmi.RemoteException;
    public void restoreFileShortcutFromTrash(long fileShortcutId) throws java.rmi.RemoteException;
    public void restoreFolderFromTrash(long folderId) throws java.rmi.RemoteException;
    public void revertFileEntry(long fileEntryId, java.lang.String version, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void subscribeFileEntryType(long groupId, long fileEntryTypeId) throws java.rmi.RemoteException;
    public void subscribeFolder(long groupId, long folderId) throws java.rmi.RemoteException;
    public void unlockFileEntry(long fileEntryId) throws java.rmi.RemoteException;
    public void unlockFileEntry(long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException;
    public void unlockFolder(long repositoryId, long folderId, java.lang.String lockUuid) throws java.rmi.RemoteException;
    public void unlockFolder(long repositoryId, long parentFolderId, java.lang.String name, java.lang.String lockUuid) throws java.rmi.RemoteException;
    public void unsubscribeFileEntryType(long groupId, long fileEntryTypeId) throws java.rmi.RemoteException;
    public void unsubscribeFolder(long groupId, long folderId) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FileEntrySoap updateFileEntry(long fileEntryId, java.lang.String sourceFileName, java.lang.String mimeType, java.lang.String title, java.lang.String description, java.lang.String changeLog, boolean majorVersion, byte[] bytes, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portlet.documentlibrary.model.DLFileShortcutSoap updateFileShortcut(long fileShortcutId, long folderId, long toFileEntryId, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public com.liferay.portal.kernel.repository.model.FolderSoap updateFolder(long folderId, java.lang.String name, java.lang.String description, com.liferay.portal.service.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public boolean verifyFileEntryCheckOut(long repositoryId, long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException;
    public boolean verifyFileEntryLock(long repositoryId, long fileEntryId, java.lang.String lockUuid) throws java.rmi.RemoteException;
    public boolean verifyInheritableLock(long repositoryId, long folderId, java.lang.String lockUuid) throws java.rmi.RemoteException;
}
