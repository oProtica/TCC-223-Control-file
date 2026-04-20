public class DeleteHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("Delete node: " + node.name);
    }
}
