public class RetrieveHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("Retrieve node: " + node.name);
    }
}
