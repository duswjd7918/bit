package java01.test44;

public class Tank extends Vehicle{
	int range;
	boolean siegeMode;


    @Override
    public void move(int direction){
    	if(siegeMode) return;
    	int distance = 3;
    	switch(direction){
    		case NORTH : y += distance;//북쪽
    		case EAST : x += distance;//동쪽
    		case SOUTH : y -= distance;//남쪽
    		case WEST : x -= distance;//서쪽
    	}
    	
    	System.out.println("땡크땡크끼리리릭...철컼ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ:"+x+","+y);
    
    }
}