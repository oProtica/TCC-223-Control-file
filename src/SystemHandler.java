public class SystemHandler implements SectionHandler {
    @Override
    public void handle(Node node, CRMParser parser) {
        System.out.println("System node: " + node.name);
        for (Node child : node.children) {
            switch (child.name) {
                case "<Comment>":
                    if (!child.content.isEmpty()) {
                        System.out.println(child.content.get(0));
                    }
                    break;
                case "<DBFileName>":
                    System.out.println("System: DBfilename");
                    break;
                case "<Delete>":
                    System.out.println("System: Delete");
                    break;
                case "<Exit>":
                    System.out.println("System: Exit");
                    break;
                case "<Output>":
                    System.out.println("System: Output");
                    break;
                case "<Save>":
                    System.out.println("System: Save");
                    break;
                case "<Sort>":
                    System.out.println("System: Sort");
                    break;
                case "<Trace>":
                    System.out.println("System: Trace");
                    break;
            }

            System.out.println("\tSystem Child node: " + child.name + " with content: " + child.content);
            // System.out.println("Decoded: " + Base64Helper.decode(child.content.get(0)));
            // // test decoding content
        }
    }
}
