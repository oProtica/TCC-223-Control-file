public class CreateHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("Create node: " + node.name);
        for (Node child : node.children) {
            System.out.println("\tCreate Child node: " + child.name + " with content: " + child.content);
            // System.out.println("Decoded: " + Base64Helper.decode(child.content.get(0)));
            // // test decoding content
        }
    }
}
