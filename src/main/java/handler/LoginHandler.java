package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.GameRequest;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��1��23�� ����2:19:58 

��¼����� username+password

 */

public class LoginHandler implements GameHandler {

	private Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public void execute(GameRequest paramGameRequest) {
		
		logger.info("LoginHandler is startprocess!");
		byte[] data=paramGameRequest.GetMessage().getData();
		/*
		 * ���ͻ���Ӧ��
		 */
	}
	
}
