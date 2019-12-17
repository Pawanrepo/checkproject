/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.snmp4j.*;
import org.snmp4j.mp.*;
import org.snmp4j.security.*;
import org.snmp4j.smi.*;
import org.snmp4j.transport.*;
import org.snmp4j.util.*;


public class MultiThreadedTrapReceiver implements CommandResponder {

    private Address address = GenericAddress.parse("127.0.0.1/162");
    private int numDispatcherThreads = 2;
    private OID authProtocol = AuthMD5.ID;
    private OID privProtocol = PrivDES.ID;
    private OctetString securityName = new OctetString("MD5DES");
    private OctetString privPassphrase = new OctetString("MD5DESUserPrivPassword");
    private OctetString authPassphrase = new OctetString("MD5DESUserAuthPassword");

    public MultiThreadedTrapReceiver() {
        try {
            listen();
        } catch (IOException ex) {
            Logger.getLogger(MultiThreadedTrapReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void listen() throws IOException {
        AbstractTransportMapping transport;
        if (address instanceof TcpAddress) {
            transport = new DefaultTcpTransportMapping((TcpAddress) address);
        } else {
            transport = new DefaultUdpTransportMapping((UdpAddress) address);
        }
        ThreadPool threadPool =
                ThreadPool.create("DispatcherPool", numDispatcherThreads);
        MessageDispatcher mtDispatcher =
                new MultiThreadedMessageDispatcher(threadPool, new MessageDispatcherImpl());

        // add message processing models
        mtDispatcher.addMessageProcessingModel(new MPv1());
        mtDispatcher.addMessageProcessingModel(new MPv2c());
        mtDispatcher.addMessageProcessingModel(new MPv3(new OctetString(MPv3.createLocalEngineID()).getValue()));

        // add all security protocols
        SecurityProtocols.getInstance().addDefaultProtocols();
        SecurityProtocols.getInstance().addPrivacyProtocol(new Priv3DES());

        Snmp snmp = new Snmp(mtDispatcher, transport);
        USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(MPv3.createLocalEngineID()), 0);
        SecurityModels.getInstance().addSecurityModel(usm);
        // Add the configured user to the USM
        addUsmUser(snmp);

        snmp.addCommandResponder(this);

        transport.listen();

        try {
            this.wait();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void addUsmUser(Snmp snmp) {
        snmp.getUSM().addUser(securityName, new UsmUser(securityName,
                authProtocol,
                authPassphrase,
                privProtocol,
                privPassphrase));
    }

    @Override
    public void processPdu(CommandResponderEvent respEvnt) {
        System.out.println(respEvnt.getPDU());
        InetAddress pduAgentAddress = null;
        //System.out.println(respEvnt.getPDU() + " recieved;");
        //this.setPdu(respEvnt.getPDU());
     //   OctetString community = new OctetString(respEvnt.getSecurityName());
     //   System.out.println("community: " + community.toString());

        //handle the SNMP v1
        if (respEvnt.getPDU().getType() == PDU.V1TRAP) {
        	
            Address address = respEvnt.getPeerAddress();
            
            String hostName = address.toString().split("/")[0];
            int nPort = Integer.parseInt(address.toString().split("/")[1]);
            try {
                pduAgentAddress = InetAddress.getByName(hostName);
            } catch (UnknownHostException ex) {
                System.out.println("Exceptionname"+ex);
            }
            System.out.println("hostname: " + pduAgentAddress.getHostAddress() + "; port: " + nPort);
        } else {
        	
            Address address = respEvnt.getPeerAddress();
            String hostName = address.toString().split("/")[0];
            int nPort = Integer.parseInt(address.toString().split("/")[1]);
            try {
                pduAgentAddress = InetAddress.getByName(hostName);
            } catch (UnknownHostException ex) {
               System.out.println("exceptionnamepawan"+ex);
            }
            System.out.println("hostname: " + pduAgentAddress.getHostAddress() + "; port: " + nPort);
        }
    }

    public static void main(String[] args) {
        MultiThreadedTrapReceiver trap = new MultiThreadedTrapReceiver();
    }
}