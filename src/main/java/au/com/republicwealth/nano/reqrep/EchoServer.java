package au.com.republicwealth.nano.reqrep;

import nanomsg.exceptions.IOException;
import nanomsg.reqrep.RepSocket;

import java.nio.ByteBuffer;

public class EchoServer {
    public static void main(String[] args) {
        RepSocket sock = new RepSocket();
        sock.bind("tcp://*:6789");

        do {
            try {
                byte[] receivedData = sock.recvBytes();
                sock.send(receivedData);
            } catch (IOException iox) {
                System.err.println("no message");
            }
//            byte [] receivedData = sock.recvBytes();
//            sock.send(receivedData);
        } while (true);
    }
}