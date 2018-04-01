package handler;

import logic.Manager.RoomManager;
import logic.Manager.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.BytesToObject;
import domain.GameRequest;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��2��6�� ����7:22:49 

���뷿��

 */

public class AddToRoomHandler implements GameHandler {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Override
	public void execute(GameRequest paramGameRequest) {
	    
		logger.info("AddToRoomHandler is startprocess!");
	    byte[] data=paramGameRequest.GetMessage().getData();
		BytesToObject bytestoobject=new BytesToObject(data);
		int roomid=bytestoobject.readInt();
	    RoomManager.getInstance().addToRoom(roomid, UserManager.getInstance().getUser(paramGameRequest.GetChannelContext()));
	    
	}
}
