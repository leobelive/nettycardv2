package handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.GameRequest;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��1��24�� ����6:30:27 

 */

public class ExitHandler implements GameHandler {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	@Override
	public void execute(GameRequest paramGameRequest) {
	    
		logger.info("ExitHandler is startprocess!");
		
	}

}
