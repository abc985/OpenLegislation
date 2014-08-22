package gov.nysenate.openleg.dao.bill;

import gov.nysenate.openleg.dao.base.LimitOffset;
import gov.nysenate.openleg.model.base.SessionYear;
import gov.nysenate.openleg.model.bill.BaseBillId;
import gov.nysenate.openleg.model.bill.Bill;
import gov.nysenate.openleg.model.bill.BillId;
import gov.nysenate.openleg.model.sobi.SobiFragment;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * DAO interface for retrieving and persisting Bill data.
 */
public interface BillDao
{
    /**
     * Retrieve a Bill via a BillId.
     *
     * @param billId BillId
     * @return Bill
     * @throws DataAccessException - If there was an error while retrieving the Bill.
     */
    public Bill getBill(BillId billId) throws DataAccessException;

    public List<BaseBillId> getBillIds(SessionYear sessionYear, LimitOffset limOff) throws DataAccessException;

    public int getBillCount() throws DataAccessException;

    public int getBillCount(SessionYear sessionYear) throws DataAccessException;

    /**
     * Updates the bill or inserts it if it does not yet exist. Associates
     * the SobiFragment that triggered the update (set null if not applicable).
     *
     * @param bill Bill
     * @param sobiFragment SobiFragment
     * @throws DataAccessException - If there was an error while trying to save the Bill.
     */
    public void updateBill(Bill bill, SobiFragment sobiFragment) throws DataAccessException;

    public void publishBill(Bill bill);

    public void unPublishBill(Bill bill);
}
