package zoo;

public class Main {

	public static void main(String[] args) {
		Ave pombo = new Ave("Bird", 12, "Passaro", true, "bico 1");
		Mamifero gato = new Mamifero("Cat", 12, "Felino", true, 2);
		Reptil jacare = new Reptil("Croc", 12, "Jacare", true, 15);
		
		Zoologico zoo = new Zoologico();
		
		zoo.adicionarAnimal(jacare);
		zoo.adicionarAnimal(gato);
		zoo.adicionarAnimal(pombo);
		
		zoo.alimentarAnimais();
		
		zoo.listarAnimais();
	}

}
