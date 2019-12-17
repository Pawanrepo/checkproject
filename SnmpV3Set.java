import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.UserTarget;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.MPv3;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.PrivDES;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.TSM;
import org.snmp4j.security.USM;
import org.snmp4j.security.UsmUser;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.util.Iterator;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;

public class SnmpV3Set {
	

	private static final String trapOid = ".1.3.6.1.2.1.1.6";
	
	private static final String ipAddress = "127.0.0.1";
	private static final int port = 162;


  public static void main(String[] args) throws Exception {
  
	  
	  try {
		//  Address targetAddress = GenericAddress.parse("udp:127.0.0.1/" + port);
			Address targetAddress = GenericAddress.parse("udp:" + ipAddress+ "/" + port);
			TransportMapping<?> transport = new DefaultUdpTransportMapping();
			
			Snmp snmp = new Snmp(transport);
			USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
					MPv3.createLocalEngineID()), 0);
			SecurityModels.getInstance().addSecurityModel(usm);
			transport.listen();	

			snmp.getUSM().addUser(
					new OctetString("MD5DES"),
					new UsmUser(new OctetString("MD5DES"), null, null, null,
							null));

			// Create Target
			UserTarget target = new UserTarget();
			target.setAddress(targetAddress);
			target.setRetries(2);
			target.setTimeout(100);
			target.setVersion(SnmpConstants.version3);
			target.setSecurityLevel(SecurityLevel.NOAUTH_NOPRIV);
			target.setSecurityName(new OctetString("MD5DES"));

			// Create PDU for V3
		//	ScopedPDU pdu = new ScopedPDU();
			ScopedPDU pdu = new ScopedPDU();

			pdu.setType(PDU.SET);
			System.out.println("JJJJJJJJJ"+SnmpConstants.sysUpTime);
			System.out.println("LLLLLLLLLLLLLLLLLLLL"+SnmpConstants.linkDown);
			pdu.add(new VariableBinding(SnmpConstants.sysUpTime));
			pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID,
					SnmpConstants.linkDown));
			pdu.add(new VariableBinding(new OID(trapOid), new OctetString("Hello Pawan")));

			// Send the PDU
			
		//	snmp.send(pdu, target);
			// Thread.sleep(5000);
			ResponseEvent event = snmp.send(pdu, target);
			System.out.println("Sending Trap to (IP:Port)=> " + ipAddress + ":"
					+ port);
			
		/*	snmp.addCommandResponder(new CommandResponder() {
				public void processPdu(CommandResponderEvent cmdRespEvent) {
					 System.out.println("Received PDU...");

				        PDU pdu1 = cmdRespEvent.getPDU();

				        if (pdu1 != null) {

				            System.out.println("Trap Type = " + pdu1.getType());

				            System.out.println("Variables = " + pdu1.getVariableBindings());
				            
				            System.out.println("Error Status= " + pdu1.getErrorStatus());
				          //  System.out.println("Error Index= " + pdu.getVariableBindings().get(0));

				            }
				}
			});
			*/
			
		  // System.out.println("exception");
			System.out.println("getuser" + event.getRequest());
			System.out.println("userobject"+ event.getUserObject());
		   
		    if (event != null) {
		    	
		    	PDU pdu1 = new PDU();
	/*	 int message   =	event.getResponse().getTypeFromString(trapOid);
		 System.out.println("messageind"+message);
	String message1 =	 event.getResponse().getTypeString(message);
	System.out.println("messageindindidi"+message1); */
		  //      System.out.println("pdu1"+  pdu1);
		        
		        if (pdu1.getErrorStatus() == PDU.noError) {
		          System.out.println("SNMPv3 SET Successful!");
		          System.out.println("Message"+event.getRequest().getVariableBindings().get(2).getVariable());
		        } else {
		          System.out.println("SNMPv3 SET Unsuccessful.");
		        } 
		    } else {
		      System.out.println("SNMP send unsuccessful.");
		    } 
		   transport.close();
			snmp.close();
		} catch (Exception e) {
			System.err.println("Error in Sending Trap to (IP:Port)=> "
					+ ipAddress + ":" + port);
			System.err.println("error"+ e);
			System.err.println("Exception Message = " + e.getMessage());
		}
	  
  }
}
