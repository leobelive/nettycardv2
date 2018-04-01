package handler;

import logic.User;
import logic.Enums.SitDownAndUp;
import logic.Manager.RoomManager;
import logic.Manager.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.BytesToObject;
import domain.GameRequest;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��2��8�� ����5:28:39 

��ʼ��Ϸ

 */

public class StartGameHandler implements GameHandler {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Override
	public void execute(GameRequest paramGameRequest) {
	    
		logger.info("StartGameHandler is startprocess!");
	    
		User user=UserManager.getInstance().getUser(paramGameRequest.GetChannelContext());
		user.setSitDownState(SitDownAndUp.down);
	  
	}
}