/**
 * @date Jun 11, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package Test.announcements;

/**
 * @author AidanTheGreat
 *
 */
public class TestOfAnnouncement {

	public static void main(String[] args){
		TestPlayer tp1 = new TestPlayer(1);
		TestPlayer tp2 = new TestPlayer(4);
		TestPlayer tp3 = new TestPlayer(10);
		
		new Announcement(TestPlayer.ATTACKED, tp1);
		new Announcement(TestPlayer.ATTACKED_WITH_CAST, tp3);
		new Announcement(0, tp1);
	}
}
