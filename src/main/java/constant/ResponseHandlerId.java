package constant;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��2��6�� ����3:51:13 

�ط����ͻ��˵���Ϣ

 */

public enum ResponseHandlerId {

     _createroom(128),//��������ɹ�
	 _nofindroom(129),//û�д˷���
     _addtoroom(130),//��ӵ�����
     _leavetoroom(131), //�뿪����
     _roomfull(132),//����������
     _beforegame(133);//��Ϸδ��ʼ��Ϣ
     
     private final int value;
     
     private ResponseHandlerId(int value)
     {
    	 this.value=value;
     }
     
     public int getValue()
     {
    	 return value;
     }
}
