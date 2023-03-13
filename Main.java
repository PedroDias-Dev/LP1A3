package zoo;

public class Main {

	public static void main(String[] args) {
		Ave pombo = new Ave("birco", 12, "passaro", true, "bico 1");
		Mamifero gato = new Mamifero("savro", 12, "felino", true, 2);
		Reptil jacare = new Reptil("care", 12, "sei la", true, 15);
		
		Zoologico zoo = new Zoologico();
		
		zoo.adicionarAnimal(jacare);
		zoo.adicionarAnimal(gato);
		zoo.adicionarAnimal(pombo);
		
		zoo.alimentarAnimais();
		
		zoo.listarAnimais();
	}

}
