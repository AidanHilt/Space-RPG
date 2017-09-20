package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestOfArrayListSerialization {
static ArrayList<String> stringList = new ArrayList<String>();
static String f = "Ok, ";
static String f2 = "testing ";
static String f3 = "if ";
static String f4 = "this ";
static String f5 = "works.";

public static void main(String[] args) throws IOException, ClassNotFoundException{
	stringList.add(f);
	stringList.add(f2);
	stringList.add(f3);
	stringList.add(f4);
	stringList.add(f5);
	
	FileOutputStream f = new FileOutputStream("string.txt");
	ObjectOutputStream f2 = new ObjectOutputStream(f);
	f2.writeObject(stringList);
	
	f2.close();
	f.close();
	
	FileInputStream f3 = new FileInputStream("string.txt");
	ObjectInputStream f4 = new ObjectInputStream(f3);
	
	@SuppressWarnings("unchecked")
	ArrayList<String> p = (ArrayList<String>) f4.readObject();
	
	f3.close();
	f4.close();
	
	for(String s: p){
		System.out.println(s);
	}
	
}
}
