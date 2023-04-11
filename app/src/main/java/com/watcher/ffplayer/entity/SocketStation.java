package com.watcher.ffplayer.entity;
import android.app.Activity;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SocketStation {
    public static Socket connfdData,connfdWarn,connfdOther;
    //这个地方不用byte是因为我们不希望中间字节做类型提升，java是没有无符号型的
    public static int byteToInt(int []a)
    {
        int res = 0;
        for (int i=0; i<4; i++) {
            res <<= 8;
            //这个运算和野生c的运算是不同的，会在符号位和数据间填0
            res |= a[i];
        }
        return res;
    }
    public static byte[] intToByte(int a) {
        byte [] data = new byte[4];
        data[0] = (byte)((a>>24)&0xff);
        data[1] = (byte)((a>>16)&0xff);
        data[2] = (byte)((a>>8)&0xff);
        data[3] = (byte)((a)&0xff);
        return data;
    }
    static
    {
        try {
            LocalDateTime now = LocalDateTime.now();
            client_name = "anonymous "+now.toString();
        }
        catch (Exception e)
        {
            Log.e("SocketStation",Log.getStackTraceString(e));
            System.exit(1);
        }
    }
    public static int vCode;
    public static int numWarn = 0;
    public static int LOGIN_SUCCESS = 0,LOGIN_FAILURE=1;
    public static List<Alarm> alarms = new ArrayList<Alarm>();
    public static String client_name;
//    public static List<Alarm> arrTmp;//消除卡顿，点一次警告消息拉一次
    public static void  exit()
    {
        Log.e("exit","use exit interface");
        System.exit(0);
    }
}
