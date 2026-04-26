public class CreateHandler implements SectionHandler {
    // Done
    @Override
    public void handle(Node node, CRMParser parser) {
        String givenName = null;
        String surname = null;
        String postCode = null;
        String telephone = null;

        for (Node child : node.children) {
            // convert all child content (except <Comment>) from base64 if it exists and
            // make it referencable by value.
            String value = child.content.isEmpty() ? null : child.content.get(0);
            if (value != null && !child.name.equals("<Comment>")) {
                value = Base64Helper.decode(value);
            }
            switch (child.name) {
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
        CRMRecord record = new CRMRecord(givenName, surname, telephone, postCode);
        CRMState state = parser.getController().getState();
        String id = state.create(record);
        System.out.println("Created record with CRMID: " + id);
    }
}
