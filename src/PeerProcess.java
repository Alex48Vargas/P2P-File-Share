public class PeerProcess {
    static final String COMMON_FILENAME = "/Common.cfg";
    static final String PEER_INFO_FILENAME = "/PeerInfo.cfg";

    int numPreferredNeighbors;
    int unchokingInterval;
    int optimisticUnchokingInterval;
    String filename;
    int filesize;
    int pieceSize;
    int numPieces;

    public PeerProcess() {
    }

    private void readCommonConfig() {
        // Method code here
    }

    private void readPeerInfoConfig() {
        // Method code here
    }

    private void start() {
        readCommonConfig();
        readPeerInfoConfig();
    }

    public static void main(String args[]) {
        PeerProcess peerProcess = new PeerProcess();
        peerProcess.start();
    }
}
