package util;

import com.jcraft.jsch.*;
import sun.misc.IOUtils;

import java.io.*;

/**
 * SSH工具类
 */
public class SSHHelper {

    /**
     * 远程 执行命令并返回结果调用过程 是同步的（执行完才会返回）
     * @param host  主机名
     * @param user  用户名
     * @param psw   密码
     * @param port  端口
     * @param command   命令
     * @return
     */
    public static String exec(String host,String user,String psw,int port,String command){
        String result="";
        Session session =null;
        ChannelExec openChannel =null;
        try {
            JSch jsch=new JSch();
            session = jsch.getSession(user, host, port);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(psw);
            session.connect();
            openChannel = (ChannelExec) session.openChannel("exec");
            openChannel.setCommand(command);
            int exitStatus = openChannel.getExitStatus();
            System.out.println(exitStatus);
            openChannel.connect();
            InputStream in = openChannel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String buf = null;
            while ((buf = reader.readLine()) != null) {
                result+= new String(buf.getBytes("gbk"),"UTF-8")+"    <br>\r\n";
            }
        } catch (Exception e) {
            result+=e.getMessage();
        }finally{
            if(openChannel!=null&&!openChannel.isClosed()){
                openChannel.disconnect();
            }
            if(session!=null&&session.isConnected()){
                session.disconnect();
            }
        }
        return result;
    }

    public static String execCommandByJSch(Session session, String command, String  resultEncoding) throws IOException,JSchException{
        String result="";
        //1.默认方式，执行单句命令
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand(command);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        int exitStatus = channelExec.getExitStatus();
        System.out.println(exitStatus);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String buf = null;
        while ((buf = reader.readLine()) != null) {
            result+= new String(buf.getBytes("gbk"),"UTF-8")+"    <br>\r\n";
        }
        channelExec.disconnect();
        session.disconnect();
        System.out.println("DONE");

        return result;

    }


    public static String execCommandByShell(Session session)throws IOException, JSchException {
        String result = "";

    //2.尝试解决 远程ssh只能执行一句命令的情况
        ChannelShell channelShell = (ChannelShell) session.openChannel("shell");
        InputStream inputStream = channelShell.getInputStream();//从远端到达的数据  都能从这个流读取到

        channelShell.setPty(true);
        channelShell.connect();

        OutputStream outputStream = channelShell.getOutputStream();//写入该流的数据  都将发送到远程端
        //使用PrintWriter 就是为了使用println 这个方法
        //好处就是不需要每次手动给字符加\n
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("cd /home/fasdev/javaApp/appserver");
        printWriter.println("appserver restart");

        /*printWriter.println("cd /home/fasdev/javaApp/appserver");
        printWriter.println("ls");
        printWriter.println("appserver restart");*/
        //printWriter.println("tail -f  nohup.out");
        printWriter.println("exit");//为了结束本次交互
        printWriter.flush();//把缓冲区的数据强行输出

        /**
         shell管道本身就是交互模式的。要想停止，有两种方式：
         一、人为的发送一个exit命令，告诉程序本次交互结束
         二、使用字节流中的available方法，来获取数据的总大小，然后循环去读。
         为了避免阻塞
         */
        byte[] tmp = new byte[1024];
        while(true){

            while(inputStream.available() > 0){
                int i = inputStream.read(tmp, 0, 1024);
                if(i < 0) break;
                String s = new String(tmp, 0, i);
                if(s.indexOf("--More--") >= 0){
                    outputStream.write((" ").getBytes());
                    outputStream.flush();
                }
                System.out.println(s);
            }
            if(channelShell.isClosed()){
                System.out.println("exit-status:"+channelShell.getExitStatus());
                break;
            }
            try{Thread.sleep(1000);}catch(Exception e){}

        }
        outputStream.close();
        inputStream.close();
        channelShell.disconnect();
        session.disconnect();
        System.out.println("DONE");

        return result;
    }

    public static Session getJSchSession(String host, String username, String password)  {
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(username, host, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");//第一次访问服务器不用输入yes
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }

        return session;
    }

    public static void main(String args[]){
        try {
            Session session = SSHHelper.getJSchSession("192.168.1.31", "fasdev", "1qaz@31");
            System.out.println(SSHHelper.execCommandByShell(session));
            //System.out.println(SSHHelper.execCommandByJSch(session,"cd /home/fasdev/javaApp","UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
}