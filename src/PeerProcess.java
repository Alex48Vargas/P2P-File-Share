public class PeerProcess {

    static final String COMMON_FILENAME = "/Common.cfg";

    static final String PEER_INFO_FILENAME = "/PeerInfo.cfg";

    String peerId;

    Server peerServer;

    Client peerClient;

    int numPreferredNeighbors;

    int unchokingInterval;

    int optimisticUnchokingInterval;

    String filename;

    int filesize;

    int pieceSize;

    int numPieces;

    


    public PeerProcess() throws Exception{
        //fix the port number after the config file has been parsed
        peerServer = new Server(8000);
        peerClient = new Client(8000);
        peerServer.run();
        peerClient.run();
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

        peerProcess.peerId = args[0];
        System.out.println("Peer_" + peerProcess.peerId + " is running");
        
        
     
    }

}