import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Sender {
  public static void main(String[] args) throws Exception {
    try {
      Context context = new InitialContext(); 

      ConnectionFactory factory = (ConnectionFactory) context.lookup("myFactoryLookup");
      Destination destination = (Destination) context.lookup("myDestinationLookup"); 

      Connection connection = factory.createConnection("UFM_c1_test", "eL7%#sBj");
      connection.setExceptionListener(new MyExceptionListener());
      connection.start(); 

      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 

      MessageProducer messageProducer = session.createProducer(destination); 

      TextMessage message = session.createTextMessage("Message Text!"); 
      messageProducer.send(message, DeliveryMode.NON_PERSISTENT,
                           Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE); 

      connection.close(); 
    } catch (Exception exp) {
      System.out.println("Caught exception, exiting.");
      exp.printStackTrace(System.out);
      System.exit(1);
    }
  }

  private static class MyExceptionListener implements ExceptionListener {
    @Override
    public void onException(JMSException exception) {
      System.out.println("Connection ExceptionListener fired, exiting.");
      exception.printStackTrace(System.out);
      System.exit(1);
    }
  }
}
