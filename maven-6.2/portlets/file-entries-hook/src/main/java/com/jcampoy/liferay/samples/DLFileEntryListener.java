package com.jcampoy.liferay.samples;

import java.util.List;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;

public class DLFileEntryListener extends BaseModelListener<DLFileEntry> {

	Log _log = LogFactoryUtil.getLog(DLFileEntryListener.class);

	@Override
	public void onBeforeUpdate(DLFileEntry fileEntry) throws ModelListenerException {

		try {
			boolean logDetails = false;

			List<DLFileVersion> versions = DLFileVersionLocalServiceUtil.getFileVersions(fileEntry.getFileEntryId(), -1);

			_log.info("* BeforeUpdate DLFileEntry " +fileEntry.toString());

			if (versions == null || versions.isEmpty()) {
				_log.error ("Orphan? -> " + fileEntry.toString());
				_log.error ("--");
			}
			else {
				try {
					DLFileVersion latestVer = DLFileVersionLocalServiceUtil.getLatestFileVersion(fileEntry.getFileEntryId(), true);

					if (!latestVer.getVersion().equals(fileEntry.getVersion())) {
						_log.error("Inconsistent? -> DLE(" + fileEntry.getVersion()+ ")" + " DLFV("+latestVer.getVersion()+") for fileEntryId: " + fileEntry.getFileEntryId());

						logDetails = true;
					}
				}
				catch (Exception ve) {
					_log.error("Corrupt? -> " +ve.getMessage() + " for DLFE with fileEntryId(" + fileEntry.getFileEntryId() +") and version ("+fileEntry.getVersion()+")");
					logDetails = true;
				}
			}

			if (logDetails) {
				_log.error ("DLFE " + fileEntry.toString());
				
				for (DLFileVersion fv: versions) {
					_log.error("  DLFV " + fv.toString());
				}

				throw new ListenerException("--StackTrace--");
			}
		}
		catch (ListenerException le) {
			_log.error("StackTrace to analyze possible inconsistence", le);
		}
		catch (SystemException e) {
			_log.error("Unexpected error", e);
		}
	}

}
