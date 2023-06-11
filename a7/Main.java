import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private List<Animal> animais = new ArrayList<>();
    private ComboBox<String> comboBox;
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        animais.add(new Animal(1, "Leão", 5));
        animais.add(new Animal(2, "Elefante", 10));
        animais.add(new Animal(3, "Tigre", 3));

        comboBox = new ComboBox<>();
        comboBox.setItems(FXCollections.observableArrayList(getNomes()));
        Button button = new Button("Exibir");
        textArea = new TextArea();
        textArea.setEditable(false);

        button.setOnAction(event -> exibirDadosCompletos());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(comboBox, button, textArea);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Animal App");
        primaryStage.show();
    }

    private List<String> getNomes() {
        List<String> nomes = new ArrayList<>();
        for (Animal animal : animais) {
            nomes.add(animal.getNome());
        }
        return nomes;
    }

    private void exibirDadosCompletos() {
        String nomeSelecionado = comboBox.getSelectionModel().getSelectedItem();
        if (nomeSelecionado != null) {
            for (Animal animal : animais) {
                if (animal.getNome().equals(nomeSelecionado)) {
                    textArea.setText("ID: " + animal.getId() + "\n" +
                            "Nome: " + animal.getNome() + "\n" +
                            "Idade: " + animal.getIdade());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Animal {
    private int id;
    private String nome;
    private int idade;

    public Animal(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
