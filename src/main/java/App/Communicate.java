package App;

interface Communicate {
    String attemptCommunication(Character communicationTarget);
    String testSuccessfulCommunication();
    String testFailedCommunication();
}
