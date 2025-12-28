import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Format {
    public static void main(String[] args) throws Exception {
        //Khởi tạo
        SocketChannel socket = SocketChannel.open();
        socket.connect(new InetSocketAddress("203.162.10.109",2206));

        //Gửi code lên server
        String code = "B22DCCN256;qCode";
        ByteBuffer byteBuffer = ByteBuffer.wrap(code.getBytes());
        socket.write(byteBuffer);

        //Nhận chuỗi từ server
        ByteBuffer messBuffer = ByteBuffer.allocate(1000);//
        int index = socket.read(messBuffer);
        messBuffer.flip();// chuyển từ chế độ đọc sang ghi hoặc ngược lại
        byte[] messByte = new byte[index];
        messBuffer.get(messByte);
        String mess = new String(messByte);
        

        //logic

        //Gửi chuỗi lên server
        String result = "result";
        ByteBuffer resBuf =ByteBuffer.wrap(result.getBytes());
        socket.write(resBuf);
        socket.close();
    }
}
