package java01.ex2;

public class RemoteController {
	
		int channel;
		int volume;
		boolean power;	

	   public RemoteController() {	
		   this.power =true ;
	    }

		public RemoteController(int channel, int volume, boolean power){
			this.channel = channel;
			this.volume = volume;
			this.power = power;
			
		}
		void channelUp(){ 	++this.channel;	}
		void channelDown(){ 	--this.channel;	}
		void volumeUp(){  	++this.volume;	}
		void volumeDown(){ 	--this.volume;	}
		void volume(int num){
			this.volume = num;
		}
		void power() { this.power = !this.power; }
		String OnorOff(){
			if(this.power == true) return "ON";
			else return "OFF";
		}
}