package handler;

import domain.GameRequest;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��1��22�� ����9:48:46 

����ִ�е�handler

 */

public abstract interface GameHandler {

	
	//����ִ��handler�ķ���
	public abstract void execute(GameRequest paramGameRequest);
	
}
