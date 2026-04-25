import crud.ArrayList;
import crud.List;
import crud.Node;

public class RetrieveHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
    	
    	 System.out.println("Retrieve node: " + node.name);
    	
    	 List<String> ids = new ArrayList<>();

         String givenName = null;
         String surname = null;
         String postCode = null;
         String telephone = null;

         // get values
         for (Node child : node.children) {

             String value = "";
             if (!child.content.isEmpty()) {
                 value = child.content.get(0);
             }

             if (child.name.equals("<CRMID>")) {
                 ids.add(value);
             } else if (child.name.equals("<GivenName>")) {
                 givenName = value;
             } else if (child.name.equals("<Surname>")) {
                 surname = value;
             } else if (child.name.equals("<PostCode>")) {
                 postCode = value;
             } else if (child.name.equals("<Telephone>")) {
                 telephone = value;
             }
         }

         List<Record> database = parser.getState().getDatabase(); // change based on how to get data from CRMState
         List<Record> results = new ArrayList<>();

         // search through each element of array
         for (Record r : database) {

             boolean match = true;

             // check CRMID
             if (!ids.isEmpty()) {
                 boolean idMatch = false;
                 for (String id : ids) {
                     if (r.crmID.equals(id)) {
                         idMatch = true;
                         break;
                     }
                 }
                 if (!idMatch) {
                     match = false;
                 }
             }

             // check every value and make sure they match
             if (match && givenName != null) {
                 if (!r.givenName.equals(givenName)) {
                     match = false;
                 }
             }

             if (match && surname != null) {
                 if (!r.surname.equals(surname)) {
                     match = false;
                 }
             }

             if (match && postCode != null) {
                 if (!r.postCode.equals(postCode)) {
                     match = false;
                 }
             }

             if (match && telephone != null) {
                 if (!r.telephone.equals(telephone)) {
                     match = false;
                 }
             }

             if (match) {
                 results.add(r);
             }
         }

         if (results.size() == 0) {
             System.out.println("No records found.");
         } else {
             for (Record r : results) {
                 System.out.println(r);
             }
         }
     }
 }       