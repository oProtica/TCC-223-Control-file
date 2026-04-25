import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CRMState implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, CRMRecord> records;

    public CRMState() {
        this.records = new HashMap<>();
    }

    public String create(CRMRecord record) {
        long id = newID();
        String key = String.valueOf(id);

        records.put(key, record);
        System.out.println("Created record with GivenName: " + record.getGivenName());
        return key;
    }

    public CRMRecord retrieve(String id) {
        return records.get(id);
    }

    public void update(String id, CRMRecord newRecord) {
        CRMRecord currentRecord = records.get(id);
        if (currentRecord == null) {
            return; // Dont update anything if the record doesnt exist.
        }
        if (newRecord.getGivenName() != null) {
            currentRecord.setGivenName(newRecord.getGivenName());
        }
        if (newRecord.getSurname() != null) {
            currentRecord.setSurname(newRecord.getSurname());
        }
        if (newRecord.getTelephone() != null) {
            currentRecord.setTelephone(newRecord.getTelephone());
        }
        if (newRecord.getPostcode() != null) {
            currentRecord.setPostcode(newRecord.getPostcode());
        }

        System.out.println("Updated givenname to " + currentRecord.getGivenName());
    }

    public CRMRecord delete(String id) {
        return records.remove(id);
    }

    // TODO: retrieve record, update record, delete record
    // TODO: Ideally optimize newID to not make every create operation O(n).
    private long newID() {
        long max = 0;
        for (String key : records.keySet()) {
            try {
                long id = Long.parseLong(key);
                if (id > max) {
                    max = id;
                }
            } catch (NumberFormatException e) {
                // ignore non-numeric IDs
            }
        }
        return max + 1;
    }
}
