package au.com.republicwealth.spike.nano.reqrep;

import nanomsg.Nanomsg;
import nanomsg.Nanomsg.Domain;
import nanomsg.Nanomsg.SocketType;
import nanomsg.Socket;
import nanomsg.exceptions.IOException;
import nanomsg.reqrep.RepSocket;

public class EchoServer {
    public static void main(String[] args) {
//        Socket repSocket = new Socket(Domain.AF_SP, SocketType.NN_REP);
        Socket repSocket = new RepSocket();
        repSocket.bind("tcp://*:6789");

        do {
            try {
                byte[] receivedData = repSocket.recvBytes();
                repSocket.send(receivedData);
            } catch (IOException iox) {
                System.err.println("no message");
            }
//            byte [] receivedData = sock.recvBytes();
//            sock.send(receivedData);
        } while (true);
    }
}