package gov.nysenate.openleg.processor.hearing;

import gov.nysenate.openleg.dao.base.LimitOffset;
import gov.nysenate.openleg.model.hearing.PublicHearingFile;
import gov.nysenate.openleg.model.hearing.PublicHearingId;

import java.text.ParseException;
import java.util.List;

public interface PublicHearingProcessService
{

    /**
     * Looks for Public Hearing Files in the incoming directory, moves them
     * into an archive directory and saves them to the backing store as pending processing.
     * @return
     */
    public int collatePublicHearingFiles();

    /**
     * Retrieves a list of Public Hearing Files that are awaiting processing.
     * @param limitOffset Restricts the number retrieved.
     * @return
     */
    public List<PublicHearingFile> getPendingPublicHearingFiles(LimitOffset limitOffset);

    /**
     * Reads the content of a Public Hearing File and generates a PublicHearing object.
     * The PublicHearing object is saved into the backing store and the Public Hearing File
     * is updated to signify it has been processed.
     * @param publicHearingFiles The PublicHearingFile to process.
     * @see gov.nysenate.openleg.model.hearing.PublicHearing
     */
    public void processPublicHearingFiles(List<PublicHearingFile> publicHearingFiles) throws ParseException;

    /**
     * Processes all the Public Hearing Files via calls to
     * {@link #getPendingPublicHearingFiles(gov.nysenate.openleg.dao.base.LimitOffset)}
     * and {@link #processPublicHearingFiles(java.util.List)}.
     */
    public void processPendingPublicHearingFiles() throws ParseException;

    /**
     * Toggle the pending processing status of a Public Hearing File.
     * @param publicHearingId
     * @param pendingProcessing
     */
    public void updatePendingProcessing(PublicHearingId publicHearingId, boolean pendingProcessing);
}
