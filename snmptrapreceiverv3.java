import java.io.IOException;
import java.net.UnknownHostException;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommunityTarget;
import org.snmp4j.MessageDispatcher;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.AuthMD5;
import org.snmp4j.security.Priv3DES;
import org.snmp4j.security.PrivDES;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.security.UsmUser;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

public class snmptrapreceiverv3 {
	public static void main(String args[]) {
		snmptrapreceiverv3 snm = new snmptrapreceiverv3();
		try {
			snm.startTrapReceiver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private synchronized void startTrapReceiver() throws UnknownHostException,
    IOException {
ThreadPool threadPool = ThreadPool.create("DispatcherPool", 10);

Address listenAddress = new UdpAddress("localhost/162");
TransportMapping transport;

transport = new DefaultUdpTransportMapping(        (UdpAddress) listenAddress);

USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(MPv3.createLocalEngineID()), 0);
usm.setEngineDiscoveryEnabled(true);

MessageDispatcher mDispathcher = new MultiThreadedMessageDispatcher(
    threadPool, new MessageDispatcherImpl());

// add message processing models
mDispathcher.addMessageProcessingModel(new MPv1());
mDispathcher.addMessageProcessingModel(new MPv2c());
mDispathcher.addMessageProcessingModel(new MPv3(usm));
// add all security protocols
SecurityProtocols.getInstance().addDefaultProtocols();
SecurityProtocols.getInstance().addPrivacyProtocol(new Priv3DES());

SecurityModels.getInstance().addSecurityModel(usm);

CommunityTarget target = new CommunityTarget();

target.setCommunity(new OctetString("public"));

Snmp snmp = new Snmp(mDispathcher, transport);

snmp.getUSM().addUser(
    new OctetString("MD5DES"),
    new UsmUser(new OctetString("MD5DES"), null, null, null,
			null));
//snmp.addCommandResponder((CommandResponder) this);


transport.listen();
System.out.println("listening");
try {
this.wait();
} catch (InterruptedException ex) {
Thread.currentThread().interrupt();
}
	
	}
}

