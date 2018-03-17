package array;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class NIO_test {
	@Test
	public void testFileChannel(){
		try {
			RandomAccessFile aFile = new RandomAccessFile("NIO_txt/nio.txt", "rw");
			FileChannel channel = aFile.getChannel();
			ByteBuffer bf = ByteBuffer.allocate(48);
			int read = channel.read(bf);
			while(read != -1){
				System.out.println("Read"+read);
				bf.flip();
				while(bf.hasRemaining()){
					System.out.println((char)bf.get());
				}
				bf.clear();
			read = channel.read(bf);
			}
			String str = "higklmn";
			bf.clear();
			bf.put(str.getBytes());
			bf.flip();
			while(bf.hasRemaining()){
				channel.write(bf);
			}
			aFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
	@Test
	public void testSocketChannel(){
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));
			ByteBuffer buf = ByteBuffer.allocate(48);
			int read = socketChannel.read(buf);
			while(read != -1){
				System.out.println("Read"+read);
				buf.flip();
				while(buf.hasRemaining()){
					System.out.println(buf.get());
				}
				buf.clear();
				read = socketChannel.read(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}
}
