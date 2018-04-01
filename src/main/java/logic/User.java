package logic;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constant.ResponseHandlerId;
import core.ObjectToBytes;
import domain.GameRequest;
import domain.MessageQueue;
import net.ResponseMessage;
import logic.Enums.SitDownAndUp;
import io.netty.channel.ChannelHandlerContext;


/*
 * �û���
 * 
 */

public class User {
   
	 private Logger logger=LoggerFactory.getLogger(getClass());
	
	private int weixinid=-1;//���΢��ID
	 
	 public int getId()
	 {
		 return weixinid;
	 }
	 
	 private String name="";//�������
	 
	 public String getName()
	 {
		 return name;
	 }
	 
	 private int roomindex=0;//����������ϵ����
	 
	 public int getRoomIndex()
	 {
		 return roomindex;
	 }
	 
	 /**
	  * 
	  * @param index
	  */
	 public void setRoomIndex(int index)
	 {
		 roomindex=index;
	 }
	 
	 private SitDownAndUp sitdown;
	 
	 public SitDownAndUp getSitDownState()
	 {
		 return sitdown;
	 }
	 
	 public void setSitDownState(SitDownAndUp state)
	 {
		 this.sitdown=state;
	 }
	 
	 private ChannelHandlerContext ctx;//ͨ�Źܵ� 
	 
	 public ChannelHandlerContext getHandlerContext()
	 {
		 return ctx;
	 }
	 
	 /**
	  * ����ͨ�Źܵ�
	  * @param ctx
	  */
	 public void setChannelHandler(ChannelHandlerContext ctx){
		 this.ctx=ctx;
	 }
	
	 private Room room=null;//������ڷ���
	 
	 public Room getRoom()
	 {
		 return room;
	 }
	 
	 /**
	  * ��ȡ��Ϸ��ʼǰ����
	  */
	 public ResponseMessage getBeforeGameMessage()
	 {
		 ObjectToBytes objecttobytes=new ObjectToBytes();
		 objecttobytes.writeInt(getId());
		 objecttobytes.writeString(getName());
		 objecttobytes.writeInt(getRoomIndex());
		 return new ResponseMessage(ResponseHandlerId._beforegame.ordinal(),objecttobytes.getBytes());
	 }
	 
	 /**
	  * ��������
	  * @param message
	  */
	 public void Send(ResponseMessage message)
	 {
		 ctx.writeAndFlush(message);
	 }
	 
}
