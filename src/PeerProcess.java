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

    


    public PeerProcess() {
        //fix the port number after the config file has been parsed
        peerServer = new Server(8000);
        peerClient = new Client(8000);
        try{
            peerServer.run();
            peerClient.run();
        }finally{
            System.out.println("n");
        }
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

        try{
            PeerProcess peerProcess = new PeerProcess();
            peerProcess.start();
    
            peerProcess.peerId = args[0];
            System.out.println("Peer_" + peerProcess.peerId + " is running");
        } finally{
            System.out.println("EXCEPTION ERROR IN CREATING CLIENT/SERVER");
        }
        
        
        
     
    }

}