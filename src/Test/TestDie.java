/**
 * @date Feb 24, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package Test;

import com.spaceRPG.utils.Die;

/**
 * @author AidanTheGreat
 *
 */
public class TestDie {
	public static void main(String[] args){
		for(int i = 0; i < 10; i ++){
			System.out.println(Die.roll(10));
		}
	}
}
