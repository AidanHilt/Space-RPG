package com.spaceRPG.overworld.managment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

import com.spaceRPG.overworld.Map;
import com.spaceRPG.utils.Constants;

public class MapIO {
	public static void saveMap(Map m){
		FileOutputStream o = null;
		ObjectOutputStream out = null;
		m.m.cleanEntityText();
		
		try{
			
			o = new FileOutputStream(m.getData() + ".dat");
			out = new ObjectOutputStream(o);
			out.writeObject(m);
			
		} catch(FileNotFoundException e){
				try {
					Files.createFile(m.getData().toPath());
					out.writeObject(m);
				}catch(NoSuchFileException e2){
					Constants.initialSaveDirectory.mkdirs();
					try {
						Files.createFile(m.getData().toPath());
						out.writeObject(m);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			
		
		}catch(FileAlreadyExistsException e){
			
		
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(Constants.MAP_SAVE_FAILURE);
		}
	}
	
public static void loadMap(Map m){
	try(FileInputStream i = new FileInputStream(m.getData() + ".dat"); ObjectInputStream in = new ObjectInputStream(i);){
		m = (Map) in.readObject();
		Constants.setCurrentMap(m);
	} catch (IOException e) {
		e.printStackTrace();
		System.exit(Constants.MAP_LOAD_FAILURE);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.exit(Constants.MAP_LOAD_FAILURE);
		}
	}
}
