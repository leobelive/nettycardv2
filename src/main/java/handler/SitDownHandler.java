package handler;

import logic.User;
import logic.Enums.SitDownAndUp;
import logic.Manager.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.GameRequest;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��2��8�� ����4:35:45 

����

 */

public class SitDownHandler  implements GameHandler  {

	private Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public void execute(GameRequest paramGameRequest) {
		
		logger.info("SitDownHandler is startprocess!");
	    
		User user=UserManager.getInstance().getUser(paramGameRequest.GetChannelContext());
		user.setSitDownState(SitDownAndUp.down);
		
	}
	
}
