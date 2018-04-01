package dispatcher;

import handler.GameHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import logic.User;
import logic.Manager.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.GameRequest;
import domain.MessageQueue;
import domain.MessageWorker;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��1��23�� ����11:07:38 

��Ϣ����

 */

public class HandlerDispatcher implements Runnable {

	
    private  final Logger logger=LoggerFactory.getLogger(getClass());
	
    //�߳�
    private Executor messageExecutor;
    
    //��Ϣ�ַ�
    private Map<Integer,GameHandler> handleMap=null;
    
    //��Ϣ����
    private MessageQueue messageQueue=new MessageQueue();
    
    //�Ƿ�������
    private boolean running;
    
    //����ʱ��
    private long sleepTime;
    
    public HandlerDispatcher()
    {
    	
    	this.running=true;
    	this.sleepTime=200L;
    	
    }
    
    public void setHandlerMap(Map<Integer,GameHandler> handlerMap)
    {
    	this.handleMap=handlerMap;
    }
    
    public Map<Integer,GameHandler>  getHandlerMap()
    {
    	return this.handleMap;
    }
    
    public void setMessageExecutor(Executor  messageExecutor)
    {
    	this.messageExecutor=messageExecutor;
    }
    
    public void setSleepTime(long sleepTime)
    {
    	this.sleepTime=sleepTime;
    }
    
    /*�����Ϣ
     * 
     */
    public void addMessage(GameRequest request){
    	messageQueue.add(request);
    }
    
	@Override
	public void run() {
	   
		while(this.running)
		{
			try
			{
					if((messageQueue!=null) && (messageQueue.size()>0) && (!messageQueue.isRunning()))
					{
						MessageWorker messageWorker=new MessageWorker(messageQueue);
						if(this.messageExecutor!=null)
						{
						    this.messageExecutor.execute(messageWorker);
						}
						else
						{
							logger.info("messageExecutor is null!");
						}
				}
			}catch(Exception ex)
			{
				logger.error("�쳣��Ϣ��"+ex);
			}
			try
			{
				Thread.sleep(this.sleepTime);
			}
			catch(Exception ex)
			{
			    logger.error("�쳣��Ϣ:"+ex);
			}
		}
		
	}
	
	public void stop()
	{
		running=false;
	}

}
