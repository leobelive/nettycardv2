package domain;

import core.Message;
import net.RequestMessage;
import io.netty.channel.ChannelHandlerContext;

/*
@author YHL
@qq: 1357098586
@email: 1357098586@qq.com

�ͻ���ҵ������
 */

public class GameRequest {
 
	
	//������Ϣ
	private RequestMessage requestmessage=null;
	
	public RequestMessage GetMessage()
	{
		return requestmessage;
	}
	
	public int getRequestId()
	{
		return requestmessage==null?-1:requestmessage.getId();
	}
	
	//�ͻ���ͨ�ž��
	private ChannelHandlerContext channelcontext=null;
	
	public ChannelHandlerContext GetChannelContext()
	{
		return channelcontext;
	}
	
	/*
	 * ctx �ͻ���ͨ�ž��
	 * msg��Ϣ����
	 */
	public GameRequest(ChannelHandlerContext ctx,RequestMessage msg)
	{
		this.channelcontext=ctx;
		this.requestmessage=msg;
	}
	
}
