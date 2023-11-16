package cc.xdev.java7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class ByteBufferUsage {
    public void useByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put((byte)1);
        buffer.put(new byte[3]);
        System.out.println(buffer.remaining());//28
        buffer.putChar('A');
        System.out.println(buffer.remaining());//26
        buffer.putFloat(0.0f);
        //float use4个byte
        //byte	1字节
        //char	2字节
        //short	2字节
        //int	4字节
        //float	4字节
        //long	8字节
        //double	8字节
        //boolean	至少1字节
        System.out.println(buffer.remaining());//22
        buffer.putLong(10, 100L);//上面放置的byte占到第10个了，这里只是替换了。
        System.out.println(buffer.getChar(4));
        System.out.println(buffer.remaining());//值为22  为什么：上面放置的byte占到第10个了，buffer.putLong(10, 100L);这里只是替换了。
    }
    public void byteOrder() {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(1);
        //00000001 00000000 00000000 00000000
//        buffer.putInt(2);
        //00000010 00000000 00000000 00000000//buffer.getInt(0)值为33554432
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(buffer.getInt(0)); //值为16777216
    }
    public void compact() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put(new byte[16]);
        System.out.println("翻转之前的remaining"+buffer.remaining());
        buffer.flip();//翻转
        System.out.println("翻转之后的remaining"+buffer.remaining());

        buffer.getInt();
        buffer.compact();
        int pos = buffer.position();
        System.out.println("pos="+pos);
    }
    public void viewBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.putInt(1);
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(2);
        int value = buffer.getInt(); //值为2
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ByteBufferUsage bbu = new ByteBufferUsage();
        bbu.useByteBuffer();
        bbu.byteOrder();
        bbu.compact();
        bbu.viewBuffer();
    }
}
