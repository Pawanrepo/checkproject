import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;

import org.snmp4j.PDUv1;

import org.snmp4j.Snmp;

import org.snmp4j.TransportMapping;

import org.snmp4j.mp.SnmpConstants;

import org.snmp4j.smi.IpAddress;

import org.snmp4j.smi.OID;

import org.snmp4j.smi.OctetString;

import org.snmp4j.smi.UdpAddress;

import org.snmp4j.transport.DefaultUdpTransportMapping;



import java.io.IOException;

import org.snmp4j.CommandResponder;

import org.snmp4j.CommandResponderEvent;

import org.snmp4j.CommunityTarget;

import org.snmp4j.MessageDispatcher;

import org.snmp4j.MessageDispatcherImpl;

import org.snmp4j.MessageException;

import org.snmp4j.PDU;

import org.snmp4j.Snmp;

import org.snmp4j.mp.MPv1;

import org.snmp4j.mp.MPv2c;

import org.snmp4j.mp.StateReference;

import org.snmp4j.mp.StatusInformation;

import org.snmp4j.security.Priv3DES;

import org.snmp4j.security.SecurityProtocols;

import org.snmp4j.smi.OctetString;

import org.snmp4j.smi.TcpAddress;

import org.snmp4j.smi.TransportIpAddress;

import org.snmp4j.smi.UdpAddress;

import org.snmp4j.transport.AbstractTransportMapping;

import org.snmp4j.transport.DefaultTcpTransportMapping;

import org.snmp4j.transport.DefaultUdpTransportMapping;

import org.snmp4j.util.MultiThreadedMessageDispatcher;

import org.snmp4j.util.ThreadPool;





 

public class TrapSenderVersion1  {

 

    public static final String community = "public";

    // Sending Trap for sysLocation of RFC1213

    public static final String Oid = ".1.3.6.1.2.1.1.8";

    //IP of Local Host

    public static final String ipAddress = "127.0.0.1";

    //Ideally Port 162 should be used to send receive Trap, any other available Port can be used

    public static final int port = 162;

 

    public static void main(String[] args) {

        TrapSenderVersion1 trapV1 = new TrapSenderVersion1();
        TrapReceiver trp = new TrapReceiver();
        trapV1.sendTrap_Version1();
        
     /*   try {

        trapV1.listen(new UdpAddress("localhost/162"));
        } catch (IOException e) {
        	
        	            e.printStackTrace();
        	
        	        }
*/

    }

    /**
33
     * This methods sends the V1 trap to the Localhost in port 162
34
     */

    public void sendTrap_Version1() {

        try {

            // Create Transport Mapping

            TransportMapping transport = new DefaultUdpTransportMapping();

            transport.listen();

 

            // Create Target

            CommunityTarget cTarget = new CommunityTarget();

            cTarget.setCommunity(new OctetString(community));

            cTarget.setVersion(SnmpConstants.version1);

            cTarget.setAddress(new UdpAddress(ipAddress + "/" + port));

            cTarget.setTimeout(5000);

            cTarget.setRetries(2);

 

            PDUv1 pdu = new PDUv1();

            pdu.setType(PDU.V1TRAP);

            pdu.setEnterprise(new OID(Oid));
            
            

            pdu.setGenericTrap(PDUv1.ENTERPRISE_SPECIFIC);

            pdu.setSpecificTrap(1);

            pdu.setAgentAddress(new IpAddress(ipAddress));

 
            // Send the PDU

            Snmp snmp = new Snmp(transport);

            System.out.println("Sending V1 Trap... Check Wheather NMS is Listening or not? ");

            snmp.send(pdu, cTarget);

            snmp.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

 /*
    
    /**
    40
         * Trap Listner
    41
         */
    
   /*     public synchronized void listen(TransportIpAddress address)
    
                throws IOException {
    
            AbstractTransportMapping transport;
    
            if (address instanceof TcpAddress) {
    
                transport = new DefaultTcpTransportMapping((TcpAddress) address);
    
            } else {
    
                transport = new DefaultUdpTransportMapping((UdpAddress) address);
    
            }
    
     
    
            ThreadPool threadPool = ThreadPool.create("DispatcherPool", 10);
    
            MessageDispatcher mDispathcher = new MultiThreadedMessageDispatcher(
    
                    threadPool, new MessageDispatcherImpl());
    
     
    
            // add message processing models
    
            mDispathcher.addMessageProcessingModel(new MPv1());
    
            mDispathcher.addMessageProcessingModel(new MPv2c());
    
     
    
            // add all security protocols
    
            SecurityProtocols.getInstance().addDefaultProtocols();
    
            SecurityProtocols.getInstance().addPrivacyProtocol(new Priv3DES());
    
     
    
            // Create Target
    
            CommunityTarget target = new CommunityTarget();
    
            target.setCommunity(new OctetString("public"));
    
     
    
            Snmp snmp = new Snmp(mDispathcher, transport);
    
            snmp.addCommandResponder(this);
    
     
    
            transport.listen();
    
            System.out.println("Listening on " + address);
    
     
    
            try {
    
                this.wait();
    
            } catch (InterruptedException ex) {
    
                Thread.currentThread().interrupt();
    
            }
    
        }
    
     
   
    
        public synchronized void processPdu(CommandResponderEvent cmdRespEvent) {
    
            System.out.println("Received PDU...");
    
            PDU pdu = cmdRespEvent.getPDU();
    
            if (pdu != null) {
    
                System.out.println("Trap Type = " + pdu.getType());
    
                System.out.println("Variables = " + pdu.getVariableBindings());
                
                System.out.println("Error Status= " + pdu.getErrorStatus());
                System.out.println("Error Index= " + pdu.getErrorIndex());
                System.out.println("ErrorText=" + pdu.getErrorStatusText());
    
                }
    
            } */
    
        }
   


