/**
 * @date Jun 13, 2016
 * @author AidanTheGreat
 * @version 
 * @function
 */
package com.spaceRPG.utils;

import com.spaceRPG.overworld.entities.Entity;

/**
 * @author AidanTheGreat
 *
 */
public class Announcement {
	public Announcement(int announcementCode, Entity entity){
		entity.announce(announcementCode);
	}

}
