package logic.Manager;

import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dispatcher.HandlerDispatcher;
import domain.GameRequest;
import domain.MessageQueue;
import net.ResponseMessage;
import logic.User;

/*
 *  �û�������
 */

public class UserManager {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	private static UserManager _instance=new UserManager();//��ֹ������������������ֱ��new
	
	private ConcurrentHashMap<Integer,User> players=new ConcurrentHashMap<Integer,User>();//�������
	
	private ConcurrentHashMap<ChannelHandlerContext,User> cus=new ConcurrentHashMap<ChannelHandlerContext,User>();//��ҵ�channelcontext,user
	
	private HandlerDispatcher handlerDispatcher;
	
	private UserManager()
	{
	
	}
	
	public static UserManager getInstance()
	{
		return _instance;
	}
	
	/**
	 * ��ȡ���е��û�
	 * @return
	 */
	public Map<Integer,User> getUser(){
		return players;
	}
	
	//������Ϣ��ָ�����
	public void sendMessage(User user,ResponseMessage message)
	{
		user.Send(message);
	}
	
	//������Ϣ��������
	public void sendUsers(User[] users,ResponseMessage message)
	{
		for(int i=0;i<users.length;i++)
		{
			users[i].Send(message);
		}
	}
	
	//���͸��������
	public void sendAll(ResponseMessage message)
	{
		for(User user : players.values())
		{
	    	user.Send(message);
	    }
	}
	
	//����û�
	public  void addUser(User user)
	{
		 players.put(user.hashCode(),user);
		 cus.put(user.getHandlerContext(),user);
	}
	
	//ɾ���û�
	public  void removeUser(User user)
	{
		players.remove(user.hashCode());
		cus.remove(user.getHandlerContext());
	}
	
	/**
	 * ������ҵ�ctx
	 * @param ctx
	 * @return
	 */
	public User getUser(ChannelHandlerContext ctx)
	{
		return cus.get(ctx);
	}
	
	//��ȡ�û�����
	public int getUserCount()
	{
		return players.size();
	}
	
	/*
	 * ������Ϣ������
	 */
	public void setHandlerDispatcher(HandlerDispatcher handlerDispatcher){
		this.handlerDispatcher=handlerDispatcher;
	}
	
    /*
     * Ϊ���������Ϣ����
     */
    
    public void addMessageQueue(GameRequest request){
       if(null!=this.handlerDispatcher){
    	   this.handlerDispatcher.addMessage(request);
       }
    }
    
    /*
     * Ϊ����ɾ����Ϣ����
     */
    private void removeMessageQueue(ChannelHandlerContext channel)
    {
    	//TODO�����ӶϿ���ʱ����ն���
    	
    }
    
    /*
     * ɾ������û�
     */
    public void removeUser(ChannelHandlerContext ctx){
    	User user=cus.remove(ctx);
    	if(user!=null){
    		players.remove(user);
    	}
    }
    
}
