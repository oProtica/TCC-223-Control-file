public class UpdateHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        String id = null;
        String givenName = null;
        String surname = null;
        String postCode = null;
        String telephone = null;

        for (Node child : node.children) {
            // convert all child content (except <CRMID>) from base64 if it exists and make
            // it referencable by value.
            String value = child.content.isEmpty() ? null : child.content.get(0);
            if (value != null && !child.name.equals("<CRMID>")) {
                value = Base64Helper.decode(value);
            }
            switch (child.name) {
                case "<CRMID>":
                    id = value;
                    break;
                case "<Comment>":
                    if (!child.content.isEmpty()) {
                        String comment = child.content.get(0);
                        System.out.println(comment);
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
        CRMRecord updatedRecord = new CRMRecord(givenName, surname, telephone, postCode);
        CRMState state = parser.getController().getState();
        state.update(id, updatedRecord);
        System.out.println("Updated record with CRMID: " + id);
    }
}
