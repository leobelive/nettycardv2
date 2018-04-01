package domain;

import io.netty.channel.ChannelHandlerContext;
import net.RequestMessage;
import net.ResponseMessage;

/*
@author YHL
@qq: 1357098586
@email: 1357098586@qq.com

�������Կͻ���Ӧ��

 */

public class GameResponse {

	    //����Ӧ����Ϣ
		private ResponseMessage responsemessag=null;
		
		public ResponseMessage GetMessage()
		{
			return responsemessag;
		}
		
		//�ͻ���ͨ�ž��
		private ChannelHandlerContext channelcontext=null;
		
		public ChannelHandlerContext GetChannelContext()
		{
			return channelcontext;
		}
		
	
	    public GameResponse(ChannelHandlerContext ctx,ResponseMessage msg)
	    {
	    	this.channelcontext=ctx;
	    	this.responsemessag=msg;
	    }
	
}
