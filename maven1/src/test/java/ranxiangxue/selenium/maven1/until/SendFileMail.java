package ranxiangxue.selenium.maven1.until;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;


public class SendFileMail {
	private static Logger logger = Logger.getLogger(SendFileMail.class);
	public void SendMail() {
		HtmlEmail mail = new HtmlEmail();
		mail.setHostName("smtp.qq.com");
		mail.setAuthentication("1475460310@qq.com", "dyvppkviinsmfjfh");
		try {
			mail.setFrom("1475460310@qq.com");
			mail.addTo("ranxiangxue@cqliving.com");
			mail.setSubject("selenium subject");
			mail.setCharset("UTF-8");
			mail.setHtmlMsg("<a href=\"\">测试报告");
			EmailAttachment emailAttachment=new EmailAttachment();
			emailAttachment.setPath("C:\\Users\\Administrator\\eclipse-workspace\\maven1\\report.html");
			emailAttachment.setName("测试报告.html");
			emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
			mail.attach(emailAttachment);
			mail.send();
			logger.debug("发送成功");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
