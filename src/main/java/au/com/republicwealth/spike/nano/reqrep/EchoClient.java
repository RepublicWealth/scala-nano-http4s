package au.com.republicwealth.spike.nano.reqrep;

import nanomsg.reqrep.ReqSocket;

public class EchoClient {
    public static void main(String[] args) {
        ReqSocket sock = new ReqSocket();
        sock.connect("tcp://localhost:6789");

        for (int i=0; i<5; i++) {
            sock.send("Hello!" + i);
            System.out.println("Received:" + sock.recvString());
        }
        sock.close();
    }
}