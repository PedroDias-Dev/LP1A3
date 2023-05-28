package sistemaMedico;

import java.io.*;

public class FichaMedica {
  private static final String FOLDER_PATH = "fichas/";
  
  public static void criarFichaMedica() {
        try {
            // Solicita ao usuário que digite os dados do paciente
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite o nome do paciente: ");
            String nome = reader.readLine();
            System.out.println("Digite a idade do paciente: ");
            int idade = Integer.parseInt(reader.readLine());
            System.out.println("Digite o gênero do paciente: ");
            String genero = reader.readLine();
            System.out.println("Digite a altura do paciente: ");
            double altura = Double.parseDouble(reader.readLine());
            System.out.println("Digite o peso do paciente: ");
            double peso = Double.parseDouble(reader.readLine());

            // Cria o arquivo com os dados do paciente
            String nomeArquivo = FOLDER_PATH + nome + ".txt";
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Escreve os dados no arquivo
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("Idade: " + idade + " anos");
            writer.newLine();
            writer.write("Gênero: " + genero);
            writer.newLine();
            writer.write("Altura: " + altura + " metros");
            writer.newLine();
            writer.write("Peso: " + peso + " kg");

            // Fecha o escritor de arquivo
            writer.close();

            System.out.println("Ficha médica criada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar a ficha médica: " + e.getMessage());
        }
    }

    public static void atualizarFichaMedica() {
        try {
            // Solicita ao usuário o nome do paciente cujos dados serão atualizados
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite o nome do paciente para atualizar os dados: ");
            String nome = reader.readLine();

            // Verifica se o arquivo de prontuário existe
            String nomeArquivo = FOLDER_PATH + nome + ".txt";
            File arquivo = new File(nomeArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de prontuário não encontrado.");
                return;
            }

            // Lê os dados atuais do arquivo
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader fileBufferedReader = new BufferedReader(fileReader);

            String conteudo = "";
            String linha;
            while ((linha = fileBufferedReader.readLine()) != null) {
                conteudo += linha + "\n";
            }

            fileBufferedReader.close();

            // Exibe os dados atuais do paciente
            System.out.println("Dados atuais do paciente:\n" + conteudo);

            // Solicita ao usuário que escolha qual dado atualizar
            System.out.println("Escolha o dado a ser atualizado: ");
            System.out.println("1. Idade");
            System.out.println("2. Gênero");
            System.out.println("3. Altura");
            System.out.println("4. Peso");
            int opcao = Integer.parseInt(reader.readLine());

            // Solicita ao usuário o novo valor para o dado escolhido
            String novoValor = "";
            switch (opcao) {
                case 1:
                    System.out.println("Digite a nova idade: ");
                    novoValor = reader.readLine();
                    break;
                case 2:
                    System.out.println("Digite o novo gênero: ");
                    novoValor = reader.readLine();
                    break;
                case 3:
                    System.out.println("Digite a nova altura: ");
                    novoValor = reader.readLine();
                    break;
                case 4:
                    System.out.println("Digite o novo peso: ");
                    novoValor = reader.readLine();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            // Atualiza o dado escolhido no conteúdo
            String[] linhas = conteudo.split("\n");
            String novoConteudo = "";
            for (String l : linhas) {
                if (l.contains(":")) {
                    String[] partes = l.split(":");
                    String chave = partes[0].trim();
                    if (chave.equalsIgnoreCase(getChave(opcao))) {
                        novoConteudo += chave + ": " + novoValor + "\n";
                    } else {
                        novoConteudo += l + "\n";
                    }
                } else {
                    novoConteudo += l + "\n";
                }
            }

            // Sobrescreve o arquivo com os dados atualizados
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(novoConteudo);
            writer.close();

            System.out.println("Ficha médica atualizada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao atualizar a ficha médica: " + e.getMessage());
        }
    }

    public static void exibirFichaMedica() {
        try {
            // Solicita ao usuário o nome do paciente cujos dados serão exibidos
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite o nome do paciente para exibir os dados: ");
            String nome = reader.readLine();

            // Verifica se o arquivo de prontuário existe
            String nomeArquivo = FOLDER_PATH + nome + ".txt";
            File arquivo = new File(nomeArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo de prontuário não encontrado.");
                return;
            }

            // Lê os dados do arquivo e exibe no console
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader fileBufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = fileBufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

            fileBufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao exibir a ficha médica: " + e.getMessage());
        }
    }

    private static String getChave(int opcao) {
        switch (opcao) {
            case 1:
                return "Idade";
            case 2:
                return "Gênero";
            case 3:
                return "Altura";
            case 4:
                return "Peso";
            default:
                return "";
        }
    }
}