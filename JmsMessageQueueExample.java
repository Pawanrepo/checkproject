import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.logging.Logger;
import com.webmethods.jms.WmConnection;
import com.webmethods.jms.WmConnectionFactory;
import com.webmethods.jms.WmTopicConnection;  
import com.webmethods.jms.WmTopicConnectionFactory;
import com.webmethods.jms.impl.WmConnectionConsumerImpl;
import com.webmethods.jms.impl.WmConnectionFactoryImpl;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class JmsMessageQueueExample implements MessageListener {
	private static String receivedmessage  = null;
	public static void main(String[] args) throws URISyntaxException, Exception {

	//	Connection connection = null;
		WmConnectionFactory wcf = new WmConnectionFactoryImpl();
		WmConnection wmc = null;
		
		
		try {
			wcf.setBrokerHost("qabroker9Ext@jms-qa-in.access.nokiasiemensnetworks.com:8206");
			wcf.setClientGroup("AWE-VFI-JMS");
			wcf.setClientID("NAIP_JMS_AWE_VFI_Connection");
		wmc =	(WmConnection)wcf.createConnection("UFM_c1_test", "eL7%#sBj");
		
			System.out.println("connected to Broker \"" + ((WmConnection) wmc).getBroker() + "\"");
			 Session session = wmc.createSession(false,  Session.AUTO_ACKNOWLEDGE);
			
			Queue queue = session.createQueue("OSSJTT1_2_PT4_CHE_AWE_VFI_REQUESTS");
			
	//		String payload="<?xml version=\"1.0\" encoding=\"UTF-8\"?> <tt-v1-2:createTroubleTicketByValueRequest xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:co-v1-5=\"http://ossj.org/xml/Common/v1-5\" xmlns:cbetrouble-v1-2=\"http://ossj.org/xml/TroubleTicket-CBETrouble/v1-2\" xmlns:tt-v1-2=\"http://ossj.org/xml/TroubleTicket/v1-2\" xmlns:sharedalarm-v1-5=\"http://ossj.org/xml/Common-SharedAlarm/v1-5\" xmlns:tt-x790-v1-0=\"http://ossj.org/xml/TroubleTicket-X790/v1-0\" xmlns:tt-pt4-v1-0=\"http://ossj.isuitehub.digia.com/xml/TroubleTicket_PT4/PT4/v1-0\"> <tt-v1-2:troubleTicketValue xsi:type=\"tt-pt4-v1-0:PT4TroubleTicketValue\"> <tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState>openactive.created</tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState> <cbetrouble-v1-2:troubleDescription>BCCH MISSING</cbetrouble-v1-2:troubleDescription> <tt-x790-v1-0:additionalTroubleInfoList> <co-v1-5:item>Additional info</co-v1-5:item> </tt-x790-v1-0:additionalTroubleInfoList> <tt-x790-v1-0:originator>amtxn</tt-x790-v1-0:originator> <tt-x790-v1-0:relatedAlarmList> <co-v1-5:modifier>ADD</co-v1-5:modifier> <tt-x790-v1-0:relatedAlarms> <sharedalarm-v1-5:item xsi:type=\"tt-pt4-v1-0:PT4AlarmValue\"> <sharedalarm-v1-5:alarmRaisedTime>2018-08-27T12:19:27+05:30</sharedalarm-v1-5:alarmRaisedTime> <sharedalarm-v1-5:perceivedSeverity_BaseAlarm>3</sharedalarm-v1-5:perceivedSeverity_BaseAlarm> <sharedalarm-v1-5:specificProblem>BCCH MISSING</sharedalarm-v1-5:specificProblem> <sharedalarm-v1-5:originatingManagedEntityKey> <co-v1-5:type>tt-pt4-v1-0:PT4TroubleTicketValue</co-v1-5:type> <co-v1-5:primaryKey>426304444</co-v1-5:primaryKey> </sharedalarm-v1-5:originatingManagedEntityKey> <tt-pt4-v1-0:acknowledgedBy>amtxn</tt-pt4-v1-0:acknowledgedBy> <tt-pt4-v1-0:acknowledgedTime>1900-01-01T00:00:00+05:30</tt-pt4-v1-0:acknowledgedTime> <tt-pt4-v1-0:alarmNumber>7767</tt-pt4-v1-0:alarmNumber> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:consecutiveNumbers>426304444</tt-pt4-v1-0:consecutiveNumbers> <tt-pt4-v1-0:creator>amtxn</tt-pt4-v1-0:creator> <tt-pt4-v1-0:ctrlNEAddress>test</tt-pt4-v1-0:ctrlNEAddress> <tt-pt4-v1-0:ctrlNEMaintenanceRegion>test</tt-pt4-v1-0:ctrlNEMaintenanceRegion> <tt-pt4-v1-0:ctrlNEName>JamalprHC</tt-pt4-v1-0:ctrlNEName> <tt-pt4-v1-0:diagnosticText>test</tt-pt4-v1-0:diagnosticText> <tt-pt4-v1-0:distinguishedName>PLMN-PLMN/BSC-229614/BCF-161/BTS-277</tt-pt4-v1-0:distinguishedName> <tt-pt4-v1-0:eventType>Quality_of_Service</tt-pt4-v1-0:eventType> <tt-pt4-v1-0:objectName>BADERI00232</tt-pt4-v1-0:objectName> <tt-pt4-v1-0:primary>Yes</tt-pt4-v1-0:primary> <tt-pt4-v1-0:siteAddress>3JNPR0023_IND_BADERI</tt-pt4-v1-0:siteAddress> </sharedalarm-v1-5:item> </tt-x790-v1-0:relatedAlarms> </tt-x790-v1-0:relatedAlarmList> <tt-x790-v1-0:serviceUnavailableBeginTime>2018-08-27T12:19:27+05:30</tt-x790-v1-0:serviceUnavailableBeginTime> <tt-x790-v1-0:troubleLocation>JamalprHC</tt-x790-v1-0:troubleLocation> <tt-pt4-v1-0:alarmAlarmCtrlNEName>JamalprHC</tt-pt4-v1-0:alarmAlarmCtrlNEName> <tt-pt4-v1-0:alarmAlarmNumber>7767</tt-pt4-v1-0:alarmAlarmNumber> <tt-pt4-v1-0:category>Service</tt-pt4-v1-0:category> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:creatorGroupList>VFI_AWE_AM_BSS-SD_GDC</tt-pt4-v1-0:creatorGroupList> <tt-pt4-v1-0:customerRegion>VF_UPE2</tt-pt4-v1-0:customerRegion> <tt-pt4-v1-0:equipment>Flexi BSC</tt-pt4-v1-0:equipment> <tt-pt4-v1-0:faultType>BSS</tt-pt4-v1-0:faultType> <tt-pt4-v1-0:networkElement>Radio</tt-pt4-v1-0:networkElement> <tt-pt4-v1-0:networkElementType>BSS/RAN-BCF</tt-pt4-v1-0:networkElementType> <tt-pt4-v1-0:parentCompany>Vodafone</tt-pt4-v1-0:parentCompany> <tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket>Service Outage</tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket> <tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket>P4</tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket> <tt-pt4-v1-0:sendIntimationSMS>false</tt-pt4-v1-0:sendIntimationSMS> <tt-pt4-v1-0:siteName>BADERI00232</tt-pt4-v1-0:siteName> <tt-pt4-v1-0:sitePriority>High</tt-pt4-v1-0:sitePriority> <tt-pt4-v1-0:technology>2G BSS</tt-pt4-v1-0:technology> <tt-pt4-v1-0:totalSitesAffected>1</tt-pt4-v1-0:totalSitesAffected> <tt-pt4-v1-0:troubleTitle>JamalprHC-BADERI00232 BCCH MISSING</tt-pt4-v1-0:troubleTitle> <tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket>Alarm</tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket> <tt-pt4-v1-0:vendor>NSN</tt-pt4-v1-0:vendor> </tt-v1-2:troubleTicketValue> </tt-v1-2:createTroubleTicketByValueRequest>";
	//		String payload="<?xml version=\"1.0\"?><tt-v1-2:TroubleTicketAttributeValueChangeEvent xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:co-v1-5=\"http://ossj.org/xml/Common/v1-5\" xmlns:cbeparty-v1-5=\"http://ossj.org/xml/Common-CBEParty/v1-5\" xmlns:cbetrouble-v1-2=\"http://ossj.org/xml/TroubleTicket-CBETrouble/v1-2\" xmlns:tt-v1-2=\"http://ossj.org/xml/TroubleTicket/v1-2\" xmlns:sharedalarm-v1-5=\"http://ossj.org/xml/Common-SharedAlarm/v1-5\" xmlns:tt-x790-v1-0=\"http://ossj.org/xml/TroubleTicket-X790/v1-0\" xmlns:tt-pt4-v1-0=\"http://ossj.isuitehub.digia.com/xml/TroubleTicket_PT4/PT4/v1-0\"><tt-v1-2:event><co-v1-5:applicationDN>System/NSN/India/Chennai/GNOC/ApplicationType/TroubleTicket/Application/1-2;1-0;PT4-AMS</co-v1-5:applicationDN><co-v1-5:eventTime>2018-07-10T10:34:52+05:30</co-v1-5:eventTime><tt-v1-2:newTroubleTicketValue xsi:type=\"tt-pt4-v1-0:PT4TroubleTicketValue\"><co-v1-5:key xsi:type=\"tt-pt4-v1-0:PT4TroubleTicketKey\"><co-v1-5:applicationDN>System/NSN/India/Chennai/GNOC/ApplicationType/TroubleTicket/Application/1-2;1-0;PT4-AMS</co-v1-5:applicationDN><co-v1-5:type>tt-pt4-v1-0:PT4TroubleTicketValue</co-v1-5:type><co-v1-5:primaryKey>TT-000027258601</co-v1-5:primaryKey></co-v1-5:key><tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState>openactive.assigned</tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState><cbetrouble-v1-2:troubleDescription>RAN | 7604 | BTS OPERATION DEGRADED | 2G SAA</cbetrouble-v1-2:troubleDescription><cbetrouble-v1-2:roleAssignments><cbetrouble-v1-2:item><cbetrouble-v1-2:assignedParty><cbeparty-v1-5:organizationPartyNames><cbeparty-v1-5:item><cbeparty-v1-5:tradingName>Vodafone_FM-AC_BSS_GNSC</cbeparty-v1-5:tradingName></cbeparty-v1-5:item></cbeparty-v1-5:organizationPartyNames></cbetrouble-v1-2:assignedParty></cbetrouble-v1-2:item></cbetrouble-v1-2:roleAssignments><tt-x790-v1-0:additionalTroubleInfoList><co-v1-5:item>1531199037amsuserIn Rura 3KNPD0065_GTL_TISTI TISTI00651 PLMN-PLMN/BSC-220213/BCF-36/BTS-106 7604 BTS OPERATION DEGRADED Rx levels differ too much between main and diversity antennas. 02 01 07 96 00 001) Check TX -RX cabling connected to trx. 2) Swap the trx with non problematic one and observe the case 3) Check antenna cable connection it should be tight  4) Check VSWR reading .and rectify if found high#|#|#1531199092amsuserIn Rura 3KNPD0065_GTL_TISTI TISTI00651 PLMN-PLMN/BSC-220213/BCF-36/BTS-106 7604 BTS OPERATION DEGRADED Rx levels differ too much between main and diversity antennas. 02 01 07 96 00 001) Check TX -RX cabling connected to trx. 2) Swap the trx with non problematic one and observe the case 3) Check antenna cable connection it should be tight  4) Check VSWR reading .and rectify if found high#|#|#</co-v1-5:item></tt-x790-v1-0:additionalTroubleInfoList><tt-x790-v1-0:originator>amtxn</tt-x790-v1-0:originator><tt-x790-v1-0:relatedAlarmList><co-v1-5:modifier>NONE</co-v1-5:modifier><tt-x790-v1-0:relatedAlarms><sharedalarm-v1-5:item xsi:type=\"tt-pt4-v1-0:PT4AlarmValue\"><sharedalarm-v1-5:alarmRaisedTime>2018-07-10T09:31:25+05:30</sharedalarm-v1-5:alarmRaisedTime><sharedalarm-v1-5:perceivedSeverity_BaseAlarm>3</sharedalarm-v1-5:perceivedSeverity_BaseAlarm><sharedalarm-v1-5:specificProblem>RAN | 7604 | BTS OPERATION DEGRADED | 2G SAA</sharedalarm-v1-5:specificProblem><sharedalarm-v1-5:originatingManagedEntityKey><co-v1-5:type>tt-pt4-v1-0:PT4TroubleTicketValue</co-v1-5:type><co-v1-5:primaryKey>557294550</co-v1-5:primaryKey></sharedalarm-v1-5:originatingManagedEntityKey><tt-pt4-v1-0:acknowledgedBy>AUTOACK</tt-pt4-v1-0:acknowledgedBy><tt-pt4-v1-0:acknowledgedTime>2018-07-10T09:31:25+05:30</tt-pt4-v1-0:acknowledgedTime><tt-pt4-v1-0:alarmClearedTime></tt-pt4-v1-0:alarmClearedTime><tt-pt4-v1-0:alarmNumber>7604</tt-pt4-v1-0:alarmNumber><tt-pt4-v1-0:clusterName>UPE1</tt-pt4-v1-0:clusterName><tt-pt4-v1-0:consecutiveNumbers>557294550</tt-pt4-v1-0:consecutiveNumbers><tt-pt4-v1-0:creator>amtxn</tt-pt4-v1-0:creator><tt-pt4-v1-0:ctrlNEAddress></tt-pt4-v1-0:ctrlNEAddress><tt-pt4-v1-0:ctrlNEMaintenanceRegion></tt-pt4-v1-0:ctrlNEMaintenanceRegion><tt-pt4-v1-0:ctrlNEName>Rura</tt-pt4-v1-0:ctrlNEName><tt-pt4-v1-0:diagnosticText>In Rura 3KNPD0065_GTL_TISTI TISTI00651 PLMN-PLMN/BSC-220213/BCF-36/BTS-106 7604</tt-pt4-v1-0:diagnosticText><tt-pt4-v1-0:distinguishedName>PLMN-PLMN/BSC-220213/BCF-36/BTS-106</tt-pt4-v1-0:distinguishedName><tt-pt4-v1-0:eventType>COMMUNICATION</tt-pt4-v1-0:eventType><tt-pt4-v1-0:objectName>3KNPD0065_GTL_TISTI</tt-pt4-v1-0:objectName><tt-pt4-v1-0:primary>Yes</tt-pt4-v1-0:primary><tt-pt4-v1-0:siteAddress>3KNPD0065_GTL_TISTI</tt-pt4-v1-0:siteAddress><tt-pt4-v1-0:siteName></tt-pt4-v1-0:siteName></sharedalarm-v1-5:item></tt-x790-v1-0:relatedAlarms></tt-x790-v1-0:relatedAlarmList><tt-x790-v1-0:serviceUnavailableBeginTime>2018-07-10T09:31:25+05:30</tt-x790-v1-0:serviceUnavailableBeginTime><tt-x790-v1-0:serviceUnavailableEndTime></tt-x790-v1-0:serviceUnavailableEndTime><tt-x790-v1-0:troubleLocation>RURA</tt-x790-v1-0:troubleLocation><tt-pt4-v1-0:actualCause></tt-pt4-v1-0:actualCause><tt-pt4-v1-0:alarmAlarmCtrlNEName>Rura</tt-pt4-v1-0:alarmAlarmCtrlNEName><tt-pt4-v1-0:alarmAlarmNumber>7604</tt-pt4-v1-0:alarmAlarmNumber><tt-pt4-v1-0:category>Service</tt-pt4-v1-0:category><tt-pt4-v1-0:clusterName>UPE1</tt-pt4-v1-0:clusterName><tt-pt4-v1-0:creatorGroupList>Vodafone_FM-AC_BSS_GNSC</tt-pt4-v1-0:creatorGroupList><tt-pt4-v1-0:customerRegion>VF_UPE1</tt-pt4-v1-0:customerRegion><tt-pt4-v1-0:disturbedArea></tt-pt4-v1-0:disturbedArea><tt-pt4-v1-0:equipment>Others</tt-pt4-v1-0:equipment><tt-pt4-v1-0:faultType>BSS</tt-pt4-v1-0:faultType><tt-pt4-v1-0:intimationImpactHistory>1531199092amsuserVoice and data calls are affected.</tt-pt4-v1-0:intimationImpactHistory><tt-pt4-v1-0:networkElement>Radio</tt-pt4-v1-0:networkElement><tt-pt4-v1-0:networkElementType>BSS/RAN-BCF</tt-pt4-v1-0:networkElementType><tt-pt4-v1-0:NSNID>ams</tt-pt4-v1-0:NSNID><tt-pt4-v1-0:onHoldUntilDate></tt-pt4-v1-0:onHoldUntilDate><tt-pt4-v1-0:parentCompany>Vodafone</tt-pt4-v1-0:parentCompany><tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket>Service Disturbance</tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket><tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket>P5</tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket><tt-pt4-v1-0:requestPendingReason></tt-pt4-v1-0:requestPendingReason><tt-pt4-v1-0:resolutionRealImpactOnQOS></tt-pt4-v1-0:resolutionRealImpactOnQOS><tt-pt4-v1-0:resolutionResolvedGroup></tt-pt4-v1-0:resolutionResolvedGroup><tt-pt4-v1-0:sendIntimationSMS>false</tt-pt4-v1-0:sendIntimationSMS><tt-pt4-v1-0:intimationSMSImpact>None</tt-pt4-v1-0:intimationSMSImpact><tt-pt4-v1-0:intimationType>BSS</tt-pt4-v1-0:intimationType><tt-pt4-v1-0:siteName>3KNPD0065_GTL_TISTI</tt-pt4-v1-0:siteName><tt-pt4-v1-0:sitePriority>Low</tt-pt4-v1-0:sitePriority><tt-pt4-v1-0:taskList><co-v1-5:modifier>NONE</co-v1-5:modifier></tt-pt4-v1-0:taskList><tt-pt4-v1-0:technology>2G BSS</tt-pt4-v1-0:technology><tt-pt4-v1-0:ticketCreationTime>2018-07-10T10:33:56+05:30</tt-pt4-v1-0:ticketCreationTime><tt-pt4-v1-0:totalSitesAffected>1</tt-pt4-v1-0:totalSitesAffected><tt-pt4-v1-0:troubleTitle>RAN | 7604 | BTS OPERATION DEGRADED | 2G SAA</tt-pt4-v1-0:troubleTitle><tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket>BSS | SA Alarm | 7604 (VSWR Alarm)</tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket><tt-pt4-v1-0:vendor>NSN</tt-pt4-v1-0:vendor><tt-pt4-v1-0:withdrawnReasonForWithdrawal></tt-pt4-v1-0:withdrawnReasonForWithdrawal><tt-pt4-v1-0:wmXD></tt-pt4-v1-0:wmXD></tt-v1-2:newTroubleTicketValue></tt-v1-2:event></tt-v1-2:TroubleTicketAttributeValueChangeEvent>";	
	//	String payload = "<?xml version="1.0" encoding="UTF-8"?> <tt-v1-2:createTroubleTicketByValueRequest xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:co-v1-5="http://ossj.org/xml/Common/v1-5" xmlns:cbetrouble-v1-2="http://ossj.org/xml/TroubleTicket-CBETrouble/v1-2" xmlns:tt-v1-2="http://ossj.org/xml/TroubleTicket/v1-2" xmlns:sharedalarm-v1-5="http://ossj.org/xml/Common-SharedAlarm/v1-5" xmlns:tt-x790-v1-0="http://ossj.org/xml/TroubleTicket-X790/v1-0" xmlns:tt-pt4-v1-0="http://ossj.isuitehub.digia.com/xml/TroubleTicket_PT4/PT4/v1-0"> <tt-v1-2:troubleTicketValue xsi:type="tt-pt4-v1-0:PT4TroubleTicketValue"> <tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState>openactive.created</tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState> <cbetrouble-v1-2:troubleDescription>BCCH MISSING</cbetrouble-v1-2:troubleDescription> <tt-x790-v1-0:additionalTroubleInfoList> <co-v1-5:item>Additional info</co-v1-5:item> </tt-x790-v1-0:additionalTroubleInfoList> <tt-x790-v1-0:originator>amtxn</tt-x790-v1-0:originator> <tt-x790-v1-0:relatedAlarmList> <co-v1-5:modifier>ADD</co-v1-5:modifier> <tt-x790-v1-0:relatedAlarms> <sharedalarm-v1-5:item xsi:type="tt-pt4-v1-0:PT4AlarmValue"> <sharedalarm-v1-5:alarmRaisedTime>2018-08-27T12:19:27+05:30</sharedalarm-v1-5:alarmRaisedTime> <sharedalarm-v1-5:perceivedSeverity_BaseAlarm>3</sharedalarm-v1-5:perceivedSeverity_BaseAlarm> <sharedalarm-v1-5:specificProblem>BCCH MISSING</sharedalarm-v1-5:specificProblem> <sharedalarm-v1-5:originatingManagedEntityKey> <co-v1-5:type>tt-pt4-v1-0:PT4TroubleTicketValue</co-v1-5:type> <co-v1-5:primaryKey>426304444</co-v1-5:primaryKey> </sharedalarm-v1-5:originatingManagedEntityKey> <tt-pt4-v1-0:acknowledgedBy>amtxn</tt-pt4-v1-0:acknowledgedBy> <tt-pt4-v1-0:acknowledgedTime>1900-01-01T00:00:00+05:30</tt-pt4-v1-0:acknowledgedTime> <tt-pt4-v1-0:alarmNumber>7767</tt-pt4-v1-0:alarmNumber> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:consecutiveNumbers>426304444</tt-pt4-v1-0:consecutiveNumbers> <tt-pt4-v1-0:creator>amtxn</tt-pt4-v1-0:creator> <tt-pt4-v1-0:ctrlNEAddress>test</tt-pt4-v1-0:ctrlNEAddress> <tt-pt4-v1-0:ctrlNEMaintenanceRegion>test</tt-pt4-v1-0:ctrlNEMaintenanceRegion> <tt-pt4-v1-0:ctrlNEName>JamalprHC</tt-pt4-v1-0:ctrlNEName> <tt-pt4-v1-0:diagnosticText>test</tt-pt4-v1-0:diagnosticText> <tt-pt4-v1-0:distinguishedName>PLMN-PLMN/BSC-229614/BCF-161/BTS-277</tt-pt4-v1-0:distinguishedName> <tt-pt4-v1-0:eventType>Quality_of_Service</tt-pt4-v1-0:eventType> <tt-pt4-v1-0:objectName>BADERI00232</tt-pt4-v1-0:objectName> <tt-pt4-v1-0:primary>Yes</tt-pt4-v1-0:primary> <tt-pt4-v1-0:siteAddress>3JNPR0023_IND_BADERI</tt-pt4-v1-0:siteAddress> </sharedalarm-v1-5:item> </tt-x790-v1-0:relatedAlarms> </tt-x790-v1-0:relatedAlarmList> <tt-x790-v1-0:serviceUnavailableBeginTime>2018-08-27T12:19:27+05:30</tt-x790-v1-0:serviceUnavailableBeginTime> <tt-x790-v1-0:troubleLocation>JamalprHC</tt-x790-v1-0:troubleLocation> <tt-pt4-v1-0:alarmAlarmCtrlNEName>JamalprHC</tt-pt4-v1-0:alarmAlarmCtrlNEName> <tt-pt4-v1-0:alarmAlarmNumber>7767</tt-pt4-v1-0:alarmAlarmNumber> <tt-pt4-v1-0:category>Service</tt-pt4-v1-0:category> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:creatorGroupList>VFI_AWE_AM_BSS-SD_GDC</tt-pt4-v1-0:creatorGroupList> <tt-pt4-v1-0:customerRegion>VF_UPE2</tt-pt4-v1-0:customerRegion> <tt-pt4-v1-0:equipment>Flexi BSC</tt-pt4-v1-0:equipment> <tt-pt4-v1-0:faultType>BSS</tt-pt4-v1-0:faultType> <tt-pt4-v1-0:networkElement>Radio</tt-pt4-v1-0:networkElement> <tt-pt4-v1-0:networkElementType>BSS/RAN-BCF</tt-pt4-v1-0:networkElementType> <tt-pt4-v1-0:parentCompany>Vodafone</tt-pt4-v1-0:parentCompany> <tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket>Service Outage</tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket> <tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket>P4</tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket> <tt-pt4-v1-0:sendIntimationSMS>false</tt-pt4-v1-0:sendIntimationSMS> <tt-pt4-v1-0:siteName>BADERI00232</tt-pt4-v1-0:siteName> <tt-pt4-v1-0:sitePriority>High</tt-pt4-v1-0:sitePriority> <tt-pt4-v1-0:technology>2G BSS</tt-pt4-v1-0:technology> <tt-pt4-v1-0:totalSitesAffected>1</tt-pt4-v1-0:totalSitesAffected> <tt-pt4-v1-0:troubleTitle>JamalprHC-BADERI00232 BCCH MISSING</tt-pt4-v1-0:troubleTitle> <tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket>Alarm</tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket> <tt-pt4-v1-0:vendor>NSN</tt-pt4-v1-0:vendor> </tt-v1-2:troubleTicketValue> </tt-v1-2:createTroubleTicketByValueRequest>";
			String payload="<?xml version=\"1.0\" encoding=\"UTF-8\"?> <tt-v1-2:createTroubleTicketByValueRequest xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:co-v1-5=\"http://ossj.org/xml/Common/v1-5\" xmlns:cbetrouble-v1-2=\"http://ossj.org/xml/TroubleTicket-CBETrouble/v1-2\" xmlns:tt-v1-2=\"http://ossj.org/xml/TroubleTicket/v1-2\" xmlns:sharedalarm-v1-5=\"http://ossj.org/xml/Common-SharedAlarm/v1-5\" xmlns:tt-x790-v1-0=\"http://ossj.org/xml/TroubleTicket-X790/v1-0\" xmlns:tt-pt4-v1-0=\"http://ossj.isuitehub.digia.com/xml/TroubleTicket_PT4/PT4/v1-0\"> <tt-v1-2:troubleTicketValue xsi:type=\"tt-pt4-v1-0:PT4TroubleTicketValue\"> <tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState>openactive.created</tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState> <cbetrouble-v1-2:troubleDescription>BCCH MISSING</cbetrouble-v1-2:troubleDescription> <tt-x790-v1-0:additionalTroubleInfoList> <co-v1-5:item>Additional info</co-v1-5:item> </tt-x790-v1-0:additionalTroubleInfoList> <tt-x790-v1-0:originator>amtxn</tt-x790-v1-0:originator> <tt-x790-v1-0:relatedAlarmList> <co-v1-5:modifier>ADD</co-v1-5:modifier> <tt-x790-v1-0:relatedAlarms> <sharedalarm-v1-5:item xsi:type=\"tt-pt4-v1-0:PT4AlarmValue\"> <sharedalarm-v1-5:alarmRaisedTime>2018-08-27T12:19:27+05:30</sharedalarm-v1-5:alarmRaisedTime> <sharedalarm-v1-5:perceivedSeverity_BaseAlarm>3</sharedalarm-v1-5:perceivedSeverity_BaseAlarm> <sharedalarm-v1-5:specificProblem>BCCH MISSING</sharedalarm-v1-5:specificProblem> <sharedalarm-v1-5:originatingManagedEntityKey> <co-v1-5:type>tt-pt4-v1-0:PT4TroubleTicketValue</co-v1-5:type> <co-v1-5:primaryKey>426304444</co-v1-5:primaryKey> </sharedalarm-v1-5:originatingManagedEntityKey> <tt-pt4-v1-0:acknowledgedBy>amtxn</tt-pt4-v1-0:acknowledgedBy> <tt-pt4-v1-0:acknowledgedTime>1900-01-01T00:00:00+05:30</tt-pt4-v1-0:acknowledgedTime> <tt-pt4-v1-0:alarmNumber>7767</tt-pt4-v1-0:alarmNumber> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:consecutiveNumbers>426304444</tt-pt4-v1-0:consecutiveNumbers> <tt-pt4-v1-0:creator>amtxn</tt-pt4-v1-0:creator> <tt-pt4-v1-0:ctrlNEAddress>test</tt-pt4-v1-0:ctrlNEAddress> <tt-pt4-v1-0:ctrlNEMaintenanceRegion>test</tt-pt4-v1-0:ctrlNEMaintenanceRegion> <tt-pt4-v1-0:ctrlNEName>JamalprHC</tt-pt4-v1-0:ctrlNEName> <tt-pt4-v1-0:diagnosticText>test</tt-pt4-v1-0:diagnosticText> <tt-pt4-v1-0:distinguishedName>PLMN-PLMN/BSC-229614/BCF-161/BTS-277</tt-pt4-v1-0:distinguishedName> <tt-pt4-v1-0:eventType>Quality_of_Service</tt-pt4-v1-0:eventType> <tt-pt4-v1-0:objectName>BADERI00232</tt-pt4-v1-0:objectName> <tt-pt4-v1-0:primary>Yes</tt-pt4-v1-0:primary> <tt-pt4-v1-0:siteAddress>3JNPR0023_IND_BADERI</tt-pt4-v1-0:siteAddress> </sharedalarm-v1-5:item> </tt-x790-v1-0:relatedAlarms> </tt-x790-v1-0:relatedAlarmList> <tt-x790-v1-0:serviceUnavailableBeginTime>2018-08-27T12:19:27+05:30</tt-x790-v1-0:serviceUnavailableBeginTime> <tt-x790-v1-0:troubleLocation>JamalprHC</tt-x790-v1-0:troubleLocation> <tt-pt4-v1-0:alarmAlarmCtrlNEName>JamalprHC</tt-pt4-v1-0:alarmAlarmCtrlNEName> <tt-pt4-v1-0:alarmAlarmNumber>7767</tt-pt4-v1-0:alarmAlarmNumber> <tt-pt4-v1-0:category>Service</tt-pt4-v1-0:category> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:creatorGroupList>VFI_AWE_AM_BSS-SD_GDC</tt-pt4-v1-0:creatorGroupList> <tt-pt4-v1-0:customerRegion>VF_UPE2</tt-pt4-v1-0:customerRegion> <tt-pt4-v1-0:equipment>Flexi BSC</tt-pt4-v1-0:equipment> <tt-pt4-v1-0:faultType>BSS</tt-pt4-v1-0:faultType> <tt-pt4-v1-0:networkElement>Radio</tt-pt4-v1-0:networkElement> <tt-pt4-v1-0:networkElementType>BSS/RAN-BCF</tt-pt4-v1-0:networkElementType> <tt-pt4-v1-0:parentCompany>Vodafone</tt-pt4-v1-0:parentCompany> <tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket>Service Outage</tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket> <tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket>P4</tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket> <tt-pt4-v1-0:sendIntimationSMS>false</tt-pt4-v1-0:sendIntimationSMS> <tt-pt4-v1-0:siteName>BADERI00232</tt-pt4-v1-0:siteName> <tt-pt4-v1-0:sitePriority>High</tt-pt4-v1-0:sitePriority> <tt-pt4-v1-0:technology>2G BSS</tt-pt4-v1-0:technology> <tt-pt4-v1-0:totalSitesAffected>1</tt-pt4-v1-0:totalSitesAffected> <tt-pt4-v1-0:troubleTitle>JamalprHC-BADERI00232 BCCH MISSING</tt-pt4-v1-0:troubleTitle> <tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket>Alarm</tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket> <tt-pt4-v1-0:vendor>NSN</tt-pt4-v1-0:vendor> </tt-v1-2:troubleTicketValue> </tt-v1-2:createTroubleTicketByValueRequest>";			
	//		String payload="<?xml version=\"1.0\" encoding=\"UTF-8\"?> <tt-v1-2:createTroubleTicketByValueRequest xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:co-v1-5=\"http://ossj.org/xml/Common/v1-5\" xmlns:cbetrouble-v1-2=\"http://ossj.org/xml/TroubleTicket-CBETrouble/v1-2\" xmlns:tt-v1-2=\"http://ossj.org/xml/TroubleTicket/v1-2\" xmlns:sharedalarm-v1-5=\"http://ossj.org/xml/Common-SharedAlarm/v1-5\" xmlns:tt-x790-v1-0=\"http://ossj.org/xml/TroubleTicket-X790/v1-0\" xmlns:tt-pt4-v1-0=\"http://ossj.isuitehub.digia.com/xml/TroubleTicket_PT4/PT4/v1-0\"> <tt-v1-2:troubleTicketValue xsi:type=\"tt-pt4-v1-0:PT4TroubleTicketValue\"> <tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState>openactive.created</tt-pt4-v1-0:troubleTicketState_TroubleTicketPT4TroubleTicketState> <cbetrouble-v1-2:troubleDescription>BCCH MISSING</cbetrouble-v1-2:troubleDescription> <tt-x790-v1-0:additionalTroubleInfoList> <co-v1-5:item>Additional info</co-v1-5:item> </tt-x790-v1-0:additionalTroubleInfoList> <tt-x790-v1-0:originator>ripovfaa</tt-x790-v1-0:originator> <tt-x790-v1-0:relatedAlarmList> <co-v1-5:modifier>ADD</co-v1-5:modifier> <tt-x790-v1-0:relatedAlarms> <sharedalarm-v1-5:item xsi:type=\"tt-pt4-v1-0:PT4AlarmValue\"> <sharedalarm-v1-5:alarmRaisedTime>2018-08-27T12:19:27+05:30</sharedalarm-v1-5:alarmRaisedTime> <sharedalarm-v1-5:perceivedSeverity_BaseAlarm>3</sharedalarm-v1-5:perceivedSeverity_BaseAlarm> <sharedalarm-v1-5:specificProblem>BCCH MISSING</sharedalarm-v1-5:specificProblem> <sharedalarm-v1-5:originatingManagedEntityKey> <co-v1-5:type>tt-pt4-v1-0:PT4TroubleTicketValue</co-v1-5:type> <co-v1-5:primaryKey>426304444</co-v1-5:primaryKey> </sharedalarm-v1-5:originatingManagedEntityKey> <tt-pt4-v1-0:acknowledgedBy>ripovfaa</tt-pt4-v1-0:acknowledgedBy> <tt-pt4-v1-0:acknowledgedTime>1900-01-01T00:00:00+05:30</tt-pt4-v1-0:acknowledgedTime> <tt-pt4-v1-0:alarmNumber>7767</tt-pt4-v1-0:alarmNumber> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:consecutiveNumbers>426304444</tt-pt4-v1-0:consecutiveNumbers> <tt-pt4-v1-0:creator>ripovfaa</tt-pt4-v1-0:creator> <tt-pt4-v1-0:ctrlNEAddress>test</tt-pt4-v1-0:ctrlNEAddress> <tt-pt4-v1-0:ctrlNEMaintenanceRegion>test</tt-pt4-v1-0:ctrlNEMaintenanceRegion><tt-pt4-v1-0:ctrlNEName>JamalprHC</tt-pt4-v1-0:ctrlNEName> <tt-pt4-v1-0:diagnosticText>test</tt-pt4-v1-0:diagnosticText> <tt-pt4-v1-0:distinguishedName>PLMN-PLMN/BSC-229614/BCF-161/BTS-277</tt-pt4-v1-0:distinguishedName> <tt-pt4-v1-0:eventType>Quality_of_Service</tt-pt4-v1-0:eventType> <tt-pt4-v1-0:objectName>BADERI00232</tt-pt4-v1-0:objectName> <tt-pt4-v1-0:primary>Yes</tt-pt4-v1-0:primary> <tt-pt4-v1-0:siteAddress>3JNPR0023_IND_BADERI</tt-pt4-v1-0:siteAddress> </sharedalarm-v1-5:item> </tt-x790-v1-0:relatedAlarms> </tt-x790-v1-0:relatedAlarmList> <tt-x790-v1-0:serviceUnavailableBeginTime>2018-08-27T12:19:27+05:30</tt-x790-v1-0:serviceUnavailableBeginTime> <tt-x790-v1-0:troubleLocation>JamalprHC</tt-x790-v1-0:troubleLocation> <tt-pt4-v1-0:alarmAlarmCtrlNEName>JamalprHC</tt-pt4-v1-0:alarmAlarmCtrlNEName> <tt-pt4-v1-0:alarmAlarmNumber>7767</tt-pt4-v1-0:alarmAlarmNumber> <tt-pt4-v1-0:category>Service</tt-pt4-v1-0:category> <tt-pt4-v1-0:clusterName>UPE2</tt-pt4-v1-0:clusterName> <tt-pt4-v1-0:creatorGroupList>VFI_AWE_AM_BSS-SD_GDC</tt-pt4-v1-0:creatorGroupList> <tt-pt4-v1-0:customerRegion>VF_UPE2</tt-pt4-v1-0:customerRegion> <tt-pt4-v1-0:equipment>Flexi BSC</tt-pt4-v1-0:equipment> <tt-pt4-v1-0:faultType>BSS</tt-pt4-v1-0:faultType> <tt-pt4-v1-0:networkElement>Radio</tt-pt4-v1-0:networkElement> <tt-pt4-v1-0:networkElementType>BSS/RAN-BCF</tt-pt4-v1-0:networkElementType> <tt-pt4-v1-0:parentCompany>Vodafone</tt-pt4-v1-0:parentCompany> <tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket>Service Outage</tt-pt4-v1-0:perceivedTroubleSeverityString_PT4TroubleTicket> <tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket>P4</tt-pt4-v1-0:preferredPriorityString_PT4TroubleTicket> <tt-pt4-v1-0:sendIntimationSMS>false</tt-pt4-v1-0:sendIntimationSMS> <tt-pt4-v1-0:siteName>BADERI00232</tt-pt4-v1-0:siteName> <tt-pt4-v1-0:sitePriority>High</tt-pt4-v1-0:sitePriority> <tt-pt4-v1-0:technology>2G BSS</tt-pt4-v1-0:technology> <tt-pt4-v1-0:totalSitesAffected>1</tt-pt4-v1-0:totalSitesAffected> <tt-pt4-v1-0:troubleTitle>JamalprHC-BADERI00232 BCCH MISSING</tt-pt4-v1-0:troubleTitle> <tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket>Alarm</tt-pt4-v1-0:troubleTypeString_PT4TroubleTicket> <tt-pt4-v1-0:vendor>NSN</tt-pt4-v1-0:vendor> </tt-v1-2:troubleTicketValue> </tt-v1-2:createTroubleTicketByValueRequest>";
			Message msg = session.createTextMessage(payload);
			msg.setJMSCorrelationID("correlationmessage");
			MessageProducer producer = session.createProducer(queue);
			System.out.println("Sending text '" + payload + "'");
			producer.send(msg);
		//	Queue queueresponse = session.createQueue("OSSJTT1_2_PT4_CHE_AWE_VFI_RESPONSES");
			
		//	TopicSession topicConsumerSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			
			
			
			Topic queueresponse = session.createTopic("OSSJTT1_2_PT4_CHE_AWE_VFI_EVENTS");
			
	//	Topic queueresponse = session.createTopic("OSSJTT1_2_PT4_CHE_AWE_VFI_EVENTS");
		//	TopicSubscriber ts = session.creates
			String consumerId = "NAIP_JMS_AWE_VFI_Connection";
		//	String consumerId = "consumer-" + UUID.randomUUID();
			
		TopicSubscriber queueresponse1 = session.createDurableSubscriber(queueresponse, consumerId);
		JmsMessageQueueExample asyncSubscriber = new JmsMessageQueueExample();
		queueresponse1.setMessageListener(asyncSubscriber);
	/*	TextMessage message = (TextMessage) 	queueresponse1.receive();
		
		queueresponse1.setMessageListener(new MessageListener()
		{
			@Override
			public void onMessage(Message message) {
			TextMessage textMessage = (TextMessage) message;
			try{
				
		//	System.out.println(" received " + textMessage.getText());
			receivedmessage = textMessage.getText();
			}
			catch (Exception e) {
			// TODO: handle exception
			}
			       
			}
			});
	//	queueresponse1.getMessageListener();
		
	/*	TextMessage textMsg =	(TextMessage)queueresponse1.receive();
		System.out.println("Received: " + textMsg.getText()); 
	//		MessageConsumer consumer = session.createConsumer(queueresponse1);
		System.out.println("queueresponse1"+queueresponse1);
			*/
		wmc.start();
	/*	System.out.print("waiting for messages");
	     for (int i = 0; i < 5; i++) {
	       Thread.sleep(1000);
	       System.out.print(".");
	      } */
	 //      System.out.println();
			
		//	wmc.start();
			
		/*	TextMessage textMsg = (TextMessage) consumer.receive();
			System.out.println(textMsg);
			System.out.println("Received: " + textMsg.getText()); 
			
			*/
		/*	Topic topic = session.createTopic("OSSJTT1_2_PT4_CHE_AWE_VFI_EVENTS");   
			MessageConsumer messageConsumer = session.createConsumer(topic);
			messageConsumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
			TextMessage textMessage = (TextMessage) message;
			try{
			System.out.println(" received " + textMessage.getText());
			}
			catch (Exception e) {
			// TODO: handle exception
			}
			       
			}
			});
			
		*/	
	//     System.out.println("HELLOINDIA"+receivedmessage);
			
			session.close();
		} finally {
			if (wmc != null) {
				wmc.close();
			}
                     //   broker.stop();
		}
	}
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		
		TextMessage msg = (TextMessage) message;
	     try {
	      System.out.println("received: " + msg.getText());
	       } catch (JMSException ex) {
	      ex.printStackTrace();
	       }
	    }
		
	}



