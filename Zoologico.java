package zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoologico {
	private List<Animal> animais = new ArrayList<Animal>();
	
	public void adicionarAnimal(Animal animal) {
		System.out.println(animal);
		this.animais.add(animal);
	}
	
	public void listarAnimais() {
		this.animais.forEach((animal) -> System.out.println(animal.getNome()));
	}
	
	public void alimentarAnimais() {
		this.animais.forEach((animal) -> animal.alimentar());
	}
}
