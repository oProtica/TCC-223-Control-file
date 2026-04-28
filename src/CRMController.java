public class CRMController {
    private String DBFileName;
    private CRMState state;
    private CRMParser parser;
    private boolean traceEnabled = false;

    public CRMController() {
        this.parser = new CRMParser(this);
    }

    // state related methods
    public CRMState getState() {
        return state;
    }

    public void setState(CRMState newState) {
        state = newState;
    }

    public void initState(String fileName) {
        if (state == null) {
            DBFileName = fileName;

            CRMState loadedState = CRMStorage.load(fileName);
            if (loadedState != null) {
                state = loadedState; // set state to state loaded from file if it loads successfully.
                System.out.println("Controller: Loaded CRM state from file: " + fileName);
            } else {
                state = new CRMState();
                System.out.println("Controller: Initialized new CRM state. Failed to load from file: " + fileName);
            }
        } else {
            System.out.println("Controller: CRM state is already initialized. Ignoring init command: ");
        }
    }

    public String getDBFileName() {
        return DBFileName;
    }

    public void setDBFileName(String fileName) {
        DBFileName = fileName;
    }

    public boolean toggleTrace() {
        traceEnabled = !traceEnabled;
        return traceEnabled;
    }

    public void trace(String message) {
        if (traceEnabled) {
            System.out.println(message);
        }
    }

    // execution related methods
    public void run(String controlFileName) {
        parser.parse(controlFileName);
    }

}
