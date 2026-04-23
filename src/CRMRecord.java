public class CRMRecord {

    private final String id;
    private String givenName;
    private String surname;
    private String telephone;
    private String postcode;

    public CRMRecord(String id, String givenName, String surname,
            String telephone, String postcode) {
        this.id = id;
        this.givenName = givenName;
        this.surname = surname;
        this.telephone = telephone;
        this.postcode = postcode;
    }

    public String getId() {
        return id;
    }

    // get/set
}