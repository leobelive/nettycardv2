package core;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
@author YHL
@qq: 1357098586
@version ����ʱ�䣺2018��2��6�� ����4:52:33 

 */

public class ObjectToBytes {

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	 ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream();
     DataOutputStream dataOutputStream = new DataOutputStream( bOutputStream );
     
   /**
    * д��int����
    * @param data д����������
    */
     public boolean writeInt(int data)
     {
    	 try {
			dataOutputStream.writeInt(data);
			return true;
		} catch (IOException e) {
		    logger.info("�쳣��Ϣ:"+e);
		    return false;
		}
     }
     
     /**
      * д�������
      * @param data 
      */
     public boolean writeShort(short data)
     {
    	 try
    	 {
    		 dataOutputStream.writeShort(data);
    		 return true;
    	 } catch (IOException e) {
 		    logger.info("�쳣��Ϣ:"+e);
 		    return false;
 		 }
     }
     
     /**
      * д��һ���ֽ�
      * @param data
      * @return
      */
     public boolean writeByte(byte data)
     {
    	 try
    	 {
    		 dataOutputStream.write(new byte[]{data});
    		 return true;
    	 }catch (IOException e) {
  		    logger.info("�쳣��Ϣ:"+e);
  		    return false;
  		 }
     }
     
     /**
      * д�����ֽ�
      * @param data
      * @return
      */
     public boolean writeByte(byte[] data)
     {
    	 try
    	 {
    		 dataOutputStream.write(data);
    		 return true;
    	 } catch (IOException e) {
  		    logger.info("�쳣��Ϣ:"+e);
  		    return false;
  		 }
     }
     
     /**
      * д���ַ���
      * @param data
      * @return
      */
     public boolean writeString(String data)
     {
    	 try
    	 {
    		 byte[] bytes=data.getBytes();
    		 dataOutputStream.writeInt(data.length());
    		 dataOutputStream.write(bytes);
    		 return true;
    	 }catch(IOException e){
    		 logger.info("�쳣��Ϣ:"+e);
    		 return false;
    	 }
     }
     
     /**
      * 
      * @return
      */
     public byte[] getBytes()
     {
    	 return bOutputStream.toByteArray();
     }
     
}
