public class UpdateHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("Update node: " + node.name);
    }
}
