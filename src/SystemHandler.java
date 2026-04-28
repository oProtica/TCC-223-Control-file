public class SystemHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        CRMController controller = parser.getController();

        for (Node child : node.children) {
            String value = null;
            if (!child.content.isEmpty()) {
                value = String.join("", child.content);
            }
            switch (child.name) {
                case "<Comment>":
                    if (value != null) {
                        System.out.println(value);
                    }
                    break;

                case "<DBFileName>":
                    // Initializes CRM state from a specified file and sets the DBFIleName in
                    // the controller.
                    // If content is empty, it will initialize the state (which will not be saved to
                    // a file until a Save command.)
                    if (!child.content.isEmpty()) {
                        controller.initState(value);
                    }
                    break;
                case "<Delete>":
                    if (value != null) {
                        if (CRMStorage.delete(value)) {
                            System.out.println("Deleted file: " + value);
                        } else {
                            System.out.println("Failed to delete file: " + value);
                        }
                    }
                    break;
                case "<Exit>":
                    if (!child.content.isEmpty()) {
                        System.out.println(value);
                        System.exit(0);
                    } else {
                        System.exit(0);
                    }
                    break;
                case "<Output>":
                    // TODO: Output retrieved CRM records, default to all records.
                    System.out.println("<Output> command is not yet implemented.");
                    break;
                case "<Save>":
                    System.out.println("Saving CRM State...");
                    // if content is provided use it as the filename, otherwise use current DB
                    // filename.
                    String fileName = child.content.isEmpty() ? controller.getDBFileName() : child.content.get(0);
                    CRMStorage.save(fileName, controller.getState());
                    break;
                case "<Sort>":
                    // TODO: There may be more than one Sort directive. All sorts are cumulative.
                    System.out.println("<Sort> command is not yet implemented.");
                    break;
                case "<Trace>":
                    // TODO: Turn trace commands “ON” or “OFF” to track CRM operations.
                    // I am not sure what this means exactly.
                    System.out.println("<Trace> command is not yet implemented.");
                    break;
            }
        }
    }
}
