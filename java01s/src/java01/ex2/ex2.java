package java01.ex2;

public class ex2 {

	public static void main(String[] args) {
		RemoteController tv1 = new RemoteController(7, 10, true);//KBS		
		RemoteController tv2 = new RemoteController(10, 0, false);//EBS
		
		tv1.channelDown();
		tv1.volumeDown();
		tv1.volumeDown();
		tv1.power();
		
		tv2.power();
		tv2.channelUp();
		tv2.volume(15);
		
		System.out.println("tv1의 "
				+ "채널은 " + tv1.channel
				+ " 음량은 " + tv1.volume
				+ " 전원은 " + tv1.OnorOff()
		);
		System.out.println("tv2의 "
				+ "채널은 " + tv2.channel
				+ " 음량은 " + tv2.volume
				+ " 전원은 " + tv2.OnorOff()
		);
	}

}
