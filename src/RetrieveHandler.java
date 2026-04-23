public class RetrieveHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("Retrieve node: " + node.name);
        for (Node child : node.children) {
            System.out.println("\tRetrieve Child node: " + child.name + " with content: " + child.content);
            // System.out.println("Decoded: " + Base64Helper.decode(child.content.get(0)));
            // // test decoding content
        }
    }
}
