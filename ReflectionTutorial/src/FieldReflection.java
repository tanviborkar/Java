import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import pojo.Student;

public class FieldReflection {

	public static void main(String[] args) {
		Class intClass = Integer.class;
		
		//code to obtain all public fields contained in the class
		Field[] fieldsArray = intClass.getFields();
		System.out.println(fieldsArray.length);
		for(int i=0; i<fieldsArray.length; i++){
			System.out.println("Field Name: "+fieldsArray[i].getName());
			System.out.println("Field Type: "+fieldsArray[i].getType());
			int modifiers = fieldsArray[i].getModifiers();
			System.out.println("Is field static ? "+Modifier.isStatic(modifiers));
		}
		
		try {
			//code to get specific fields of the class
			Field field1 = intClass.getField("MIN_VALUE");
			//code to get and set values of fields of the class
			//field1.set(null, 10);
			//System.out.println("Value set for MIN_VALUE: "+field1.get(null));	
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fields of the Student Class");
		Class studentClass = Student.class;
		//code to obtain all public fields contained in the class
		Field[] studentFields = studentClass.getFields();
		for(int i=0; i<studentFields.length; i++){
			System.out.println("Field Name: "+studentFields[i].getName());
			System.out.println("Field Type: "+studentFields[i].getType());
		}
		try {
			Field field = studentClass.getField("studentName");
			System.out.println("Field Type of Student Name: "+field.getType());
			//code to get and set values of fields of the class
			List<String> courseList1 = new ArrayList<String>();
			courseList1.add("AI");
			courseList1.add("Internet Services");
			courseList1.add("Computer Graphics");
			Student student1 = new Student();
			Field field1 = studentClass.getField("courses");
			field1.set(student1, courseList1);
			
			List<String> courseList2 = new ArrayList<String>();
			courseList2.add("Datastructures");
			courseList2.add("Computer Vision");
			courseList2.add("Game Science");
			Student student2 = new Student();
			Field field2 = studentClass.getField("courses");
			field2.set(student2, courseList2);
			
			System.out.println("Courses enrolled by student 1: "+field1.get(student1));
			System.out.println("Courses enrolled by student 2: "+field2.get(student2));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
