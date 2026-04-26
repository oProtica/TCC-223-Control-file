public class UpdateHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        String id = null;
        String givenName = null;
        String surname = null;
        String postCode = null;
        String telephone = null;

        for (Node child : node.children) {
            // convert all child content (except <CRMID> & <Comment> which are plain text)
            // from base64 if it exists and make
            // it referencable by value.
            String value = child.content.isEmpty() ? null : child.content.get(0);
            // override value with decoded base64.
            if (value != null && !child.name.equals("<CRMID>") && !child.name.equals("<Comment>")) {
                value = Base64Helper.decode(value);
            }
            switch (child.name) {
                case "<CRMID>":
                    id = value;
                    break;
                case "<Comment>":
                    if (value != null) {
                        System.out.println(value);
                    }
                    break;
                case "<GivenName>":
                    givenName = value;
                    break;
                case "<PostCode>":
                    postCode = value;
                    break;
                case "<Surname>":
                    surname = value;
                    break;
                case "<Telephone>":
                    telephone = value;
                    break;
            }
        }
        // make sure CRMID is provided.
        if (id == null) {
            System.out.println("Error: Missing CRMID; All other fields are optional.");
            return;
        }
        CRMRecord updatedRecord = new CRMRecord(givenName, surname, telephone, postCode);
        CRMState state = parser.getController().getState();
        state.update(id, updatedRecord);

        System.out.println("Updated record with CRMID: " + id);
    }
}
