package com.jcampoy.liferay.samples;

import java.util.List;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;

public class DLFileVersionListener extends BaseModelListener<DLFileVersion> {

	Log _log = LogFactoryUtil.getLog(DLFileVersionListener.class);

	@Override
	public void onAfterUpdate(DLFileVersion fileVersion) throws ModelListenerException {

		try {
			boolean logDetails = false;

			String latestVersion = "-";

			_log.info("** onAfterUpdate DLFileVersion " + fileVersion.toString());

			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(fileVersion.getFileEntryId());

			if (fileEntry == null) {
				_log.info("FileEntry is null for DLFileVersion " +fileVersion.toString());
			}
			else {
				List<DLFileVersion> versions = DLFileVersionLocalServiceUtil.getFileVersions(fileVersion.getFileEntryId(), -1);

				if (versions == null || versions.isEmpty()) {
					_log.info ("Orphan? -> " + fileEntry.toString());
					_log.info ("--");
				}
				else {
					try {
						DLFileVersion latestVer = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(), true);

						latestVersion = latestVer.getVersion();

						if (!latestVersion.equals(fileEntry.getVersion())) {
							_log.info("Inconsistent? -> DLE(" + fileEntry.getVersion()+ ")" + " DLFV("+latestVersion+") for fileEntryId: " + fileEntry.getFileEntryId());
							logDetails = true;
						}
					}
					catch (Exception ve) {
						_log.info("Corrupt? -> " +ve.getMessage() + " for DLFE with fileEntryId(" + fileEntry.getFileEntryId() +") and version ("+fileEntry.getVersion()+")");
						logDetails = true;
					}
				}

				if (logDetails) {
					_log.info ("DLFE " + fileEntry.toString());
					
					for (DLFileVersion fv: versions) {
						_log.info("  DLFV " + fv.toString());
					}

					throw new ListenerException("--StackTrace--");
				}
				else {
					_log.info("Ok -> DLE(" + fileEntry.getVersion()+ ")" + " DLFV("+latestVersion+") for fileEntryId: " + fileEntry.getFileEntryId());
				}
			}
		}
		catch (ListenerException le) {
			_log.info("StackTrace to analyze possible inconsistence", le);
		}
		catch (SystemException e) {
			_log.error("Unexpected error", e);
		}
	}

}
