package cz.ucl.jee.lec08;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class Zoo {
	

	public static void main(String[] args) {
		
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Lion());
		animals.add(new Monkey());
		
		for (Animal animal : animals){
			Annotation a = animal.getClass().getAnnotation(Predator.class);
			if (a != null){
				System.out.println(((Predator)a).dangerLevel());
			} else {
				System.out.println("Safe animal");
			}
			
		}

	}

}
