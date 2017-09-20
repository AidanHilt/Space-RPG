/**
 * @date Jun 11, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package Test.announcements;
public class TestPlayer {
	
	int fakeLevel;
	
	public TestPlayer(int fakeLevel){
		this.fakeLevel = fakeLevel;
	}
	
	
	
	public void announcement(int announcementCode){
		System.out.println("----------New Event------------");
		System.out.println(announcementCode);
		switch(announcementCode){
		
		case(0):
			if(fakeLevel >= 4){
				System.out.println("Attack response");
			}else{
				System.out.println("Level too low 1");
			}
			break;
		case(1):
			if(fakeLevel >= 1){
				System.out.println("CastResponse");
			}else{
				System.out.println("Level too low 2");
			}
			break;
		case(2):
			if(fakeLevel >= 10){
				System.out.println("CastAttackResponse");
			}else{
				System.out.println("Level too low 3");
			}
			break;
		}
	}

	public static int ATTACKED = 0;
	public static int CAST = 1;
	public static int ATTACKED_WITH_CAST = 2;
}
