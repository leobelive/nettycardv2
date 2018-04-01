package logic;

import handler.CreateRoomHandler;
import handler.ExitHandler;
import handler.GameHandler;
import handler.LeaverRoomHandler;
import handler.LoginHandler;
import handler.SitDownHandler;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import logic.Manager.UserManager;
import constant.RequestHandlerId;
import dispatcher.HandlerDispatcher;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��1��23�� ����3:08:16 

����������

 */

public class LogicMain {
	
   private HandlerDispatcher handlerdispatcher=new HandlerDispatcher();
	
   public HandlerDispatcher getDispatcher()
   {
	   return handlerdispatcher;
   }
   
   private static LogicMain _instance=new LogicMain();;
	
   private LogicMain()
   {
	   
	   //���ô���handler
	   Map<Integer,GameHandler> handleMap=new LinkedHashMap<Integer,GameHandler>();
	   
	   handleMap.put(RequestHandlerId.login.ordinal(), new LoginHandler());
	   handleMap.put(RequestHandlerId.exit.ordinal(), new ExitHandler());
	   handleMap.put(RequestHandlerId.createroom.ordinal(), new CreateRoomHandler());
	   handleMap.put(RequestHandlerId.leaveroom.ordinal(),new LeaverRoomHandler());
	   handleMap.put(RequestHandlerId.sitdown.ordinal(), new SitDownHandler());
	   
	   handlerdispatcher.setHandlerMap(handleMap);
	  
	   //��Ϣ�ַ�����ʼ����
	   handlerdispatcher.setMessageExecutor(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2));
	  
	   UserManager.getInstance().setHandlerDispatcher(handlerdispatcher);
	   
	   new Thread(handlerdispatcher).start();;
     
   };
   
   public static LogicMain getInstance()
   {
	   return _instance;
   }
   
}
