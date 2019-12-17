import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.UserTarget;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.MPv3;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.PrivAES128;
import org.snmp4j.security.PrivAES192;
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
import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;

public class SnmpV3Sets {
	
	private static final String community = "public";
	private static final String trapOid = ".1.3.6.1.2.1.1.6";
	private static final String ipAddress = "127.0.0.1";
	private static final int port = 162;


  public static void main(String[] args) throws Exception {
	  try {
			Address targetAddress = GenericAddress.parse("udp:" + ipAddress
					+ "/" + port);
			TransportMapping<?> transport = new DefaultUdpTransportMapping();
			Snmp snmp = new Snmp(transport);
			
			
			OctetString localEngineId = new OctetString(MPv3.createLocalEngineID());
		   
		   
			USM usm = new USM(SecurityProtocols.getInstance(), localEngineId, 0);
			SecurityProtocols.getInstance().addPrivacyProtocol(new PrivAES192());
			SecurityModels.getInstance().addSecurityModel(usm);
			transport.listen();

			snmp.getUSM().addUser(
					new OctetString("MD5DES"),
					new UsmUser(new OctetString("MD5DES"), AuthMD5.ID,
							new OctetString("UserName"), PrivAES128.ID,
							new OctetString("UserName")));

			// Create Target
			UserTarget target = new UserTarget();
			target.setAddress(targetAddress);
			target.setRetries(1);
			target.setTimeout(5000);
			target.setVersion(SnmpConstants.version3);
			target.setSecurityLevel(SecurityLevel.AUTH_PRIV);
			target.setSecurityName(new OctetString("MD5DES"));

			// Create PDU for V3
			ScopedPDU pdu = new ScopedPDU();
			pdu.setType(ScopedPDU.NOTIFICATION);
			pdu.add(new VariableBinding(SnmpConstants.sysUpTime));
			pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID,
					SnmpConstants.linkDown));
			pdu.add(new VariableBinding(new OID(trapOid), new OctetString(
					"Major")));

			// Send the PDU
			snmp.send(pdu, target);
			System.out.println("Sending Trap to (IP:Port)=> " + ipAddress + ":"
					+ port);
			
			ResponseEvent event = snmp.send(pdu, target);
		    System.out.println("event"+ event);
		 
		    if (event != null) {
		    	PDU pdu1 = new ScopedPDU();
		        pdu1 = event.getResponse();
		        System.out.println("pdu1"+  pdu);
		        if (pdu1.getErrorStatus() == PDU.noError) {
		          System.out.println("SNMPv3 SET Successful!");
		        } else {
		          System.out.println("SNMPv3 SET Unsuccessful.");
		        } 
		    } else {
		      System.out.println("SNMP send unsuccessful.");
		    }
			snmp.close();
		} catch (Exception e) {
			System.err.println("Error in Sending Trap to (IP:Port)=> "
					+ ipAddress + ":" + port);
			System.err.println("Exception Message = " + e.getMessage());
		}
	  
	  
	  
	  
	  
	  
  }
}
