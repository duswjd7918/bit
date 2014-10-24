package java01.test55;

public class TestA implements Gamer {
  int count;
  
  @Override
  public String who() {
    return "YeonjungBae";
  }

  @Override
  public void init() {
	  
  }

  @Override
  public String play() {
    count++;
    if ((count % 5) == 0) 
      return Gamer.PAPER;
    else if ((count % 3) == 0) 
      return Gamer.ROCK;
    else 
      return Gamer.SCISSORS;
  }

  @Override
  public void sendResult(int result) {
	  if(result == -1) count++;
  }

}