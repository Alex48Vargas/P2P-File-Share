import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class PeerProcess {

    static final String COMMON_FILENAME = "/Common.cfg";

    static final String PEER_INFO_FILENAME = "/PeerInfo.cfg";

    String peerId;
    Server peerServer;
    Client peerClient;
    int numPreferredNeighbors;
    int unchokingInterval;
    int optimisticUnchokingInterval;
    String fileName;
    int fileSize;
    int pieceSize;
    int numPieces;

    ArrayList<String[]> peers;


    public PeerProcess() {
        //fix the port number after the config file has been parsed
        peerServer = new Server(8000);
        peerClient = new Client(8000);
    }



     private void readCommonConfig() {
        String filePath = System.getProperty("user.dir") + "/" + COMMON_FILENAME;

        System.out.println("Attempting to read file: " + filePath); // Debug information

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    switch (key) {
                        case "NumberOfPreferredNeighbors":
                            numPreferredNeighbors = Integer.parseInt(value);
                            break;

                        case "UnchokingInterval":
                            unchokingInterval = Integer.parseInt(value);
                            break;

                        case "OptimisticUnchokingInterval":
                            optimisticUnchokingInterval = Integer.parseInt(value);
                            break;

                        case "FileName":
                            fileName = value;
                            break;

                        case "FileSize":
                            fileSize = Integer.parseInt(value);
                            break;

                        case "PieceSize":
                            pieceSize = Integer.parseInt(value);
                            break;

                        default:
                            // Handle unknown keys or invalid configurations
                            break;
                    }
                }
            }
            System.out.println("Successful");
        } catch (IOException e) {
            // Handle file read error
            e.printStackTrace();
        }
    }



    private void readPeerInfoConfig() {
        String filePath = System.getProperty("user.dir") + "/" + PEER_INFO_FILENAME;
        System.out.println("Attempting to read file: " + filePath); // Debug information
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 4) {
                    peers.add(parts);
                }
            }
            System.out.println("Successful");
        } catch (IOException e) {
            // Handle file read error
            e.printStackTrace();
        }
    }




    private void start() {
        readCommonConfig();
        numPieces = Math.ceilDiv(fileSize, pieceSize);
        readPeerInfoConfig();
    }



    public static void main(String args[]) {

    
        PeerProcess peerProcess = new PeerProcess();
        peerProcess.start();

        peerProcess.peerId = args[0];
        System.out.println("Peer_" + peerProcess.peerId + " is running");
    
    }
}