import sistemaMedico.FichaMedica;
import java.io.*;

class Main {
    public static void main(String[] args) {
        exibirMenu();
    }

    public static void exibirMenu() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("1. Criar uma nova ficha médica");
                System.out.println("2. Atualizar uma ficha médica");
                System.out.println("3. Visualizar os dados de uma ficha médica");
                System.out.println("4. Sair");
                System.out.println("");
                System.out.print("Escolha uma opção: ");
                int option = Integer.parseInt(reader.readLine());

                switch (option) {
                    case 1:
                        FichaMedica.criarFichaMedica();
                        break;
                    case 2:
                        FichaMedica.atualizarFichaMedica();
                        break;
                    case 3:
                        FichaMedica.exibirFichaMedica();
                        break;
                    case 4:
                        System.out.println("Saindo do programa...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }    
}