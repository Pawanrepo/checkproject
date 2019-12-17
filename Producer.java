
import com.webmethods.jms.WmConnection;
import com.webmethods.jms.WmConnectionFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class Producer {
	public Producer(String username, String password) {
		System.out.println("running Producer.");

		Properties jndiProperties = null;
		Context jndiContext = null;

		ConnectionFactory cf = null;
		Connection connection = null;
	//	Destination destination = null;

		try {
			// load the jndi.properties file
			try {
				jndiProperties = new Properties();
				File file = new File("jndi.properties");
				jndiProperties.load(new FileInputStream(file));
				System.out.println("loaded " + file.getAbsolutePath());
			} catch (IOException ex) {
				System.out.println("ERROR: jndi.properties not loaded");
				ex.printStackTrace();
				System.exit(0);
			}

			// connect to JNDI using jndi.properties
			try {
				jndiContext = new InitialContext(jndiProperties);
				System.out.println("connected to JNDI provider");
			} catch (NamingException ex) {
				System.out.println("ERROR: failed to connect to JNDI provider");
				ex.printStackTrace();
				System.exit(0);
			}

			// lookup the administered objects
			try {
				cf = (ConnectionFactory) jndiContext.lookup("SampleConnectionFactory");
				System.out.println("found ConnectionFactory in JNDI");

			//	destination = (Destination) jndiContext						.lookup("SampleDestination");
				System.out.println("found SampleDestiation in JNDI");
			} catch (NamingException ex) {
				System.out.println("ERROR: JNDI lookup failed");
				ex.printStackTrace();
				System.exit(0);
			}

			// create a connection to the Broker
			try {
				connection = cf.createConnection(username, password);
				System.out.println("connected to Broker \""
						+ ((WmConnection) connection).getBroker() + "\"");
			} catch (JMSException ex) {
				String broker = ((WmConnectionFactory) cf).getBrokerList();
				System.out.println("ERROR: unable to connect to Broker \""
						+ broker + "\"");
				ex.printStackTrace();
				System.exit(0);
			}

			// deliver the message(s)
			try {
				Session session = connection.createSession(false,
						Session.AUTO_ACKNOWLEDGE);
				Queue queue = session.createQueue("OSSJTT1_2_PT4_CHE_AWE_VFI_REQUESTS");
				MessageProducer producer = session.createProducer(queue);
				/*for (int i = 0; i < messageText.size(); i++) {
					TextMessage msg = session
							.createTextMessage((String) messageText.get(i));
					producer.send(msg);
					System.out.println("delivered message \""
							+ messageText.get(i) + "\"");
				} */
				TextMessage msg = session
						.createTextMessage("Text Creation");
				System.out.println("delivered " 
						+ " message(s)");
			} catch (Exception ex) {
				System.out.println("ERROR: unable to deliver message(s)");
				ex.printStackTrace();
				System.exit(0);
			}

			// close the connection
			connection.close();
			System.out.println("connection closed");
		} catch (Exception ex) {
			System.out.println("ERROR: unexpected error");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String username = null;
		String password = null;
		

	

		new Producer("UFM_c1_test", "eL7%#sBj");
	}

	static void printUsage() {
		System.out.println();
		System.out
				.println("Usage: java Producer [arguments] <message text> ...");
		System.out.println("  arguments:");
		System.out
				.println("    -username <username>    The username if using SSL");
		System.out
				.println("    -password <password>    The password if using SSL");
		System.out.println();
		System.out.println("Example: java Producer \"Hello, World!\"");

		System.exit(0);
	}
}
