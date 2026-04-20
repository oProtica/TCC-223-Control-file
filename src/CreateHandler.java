public class CreateHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("Create node: " + node.name);
    }
}
