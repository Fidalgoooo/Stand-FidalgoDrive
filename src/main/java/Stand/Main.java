package Stand;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    /**
     * Este método limita-se a lançar o array de argumentos para a super classe Application
     * No lançamento de qualquer aplicação podemos associar n Argumentos, que são
     * recebidos neste array e assim disponibilizados para a aplicação.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Este método carrega (load) a classe MainApp e serve para escrevermos o nosso código.
     * É o ponto de entrada principal de uma aplicação JavaFX.
     * Neste caso, executa a janela principal (primaryStage), associada à cena (scene) principal do ficheiro FXML
     * @param primaryStage é inicializado a janela (stage) da nossa aplicação.
     * @throws Exception serve para ignorar todos o warnings de exceções. Caso contrário temos qe usar o try...catch
     */
    @Override
    public void start(Stage primaryStage) throws Exception {


        // Aquisição do controlo de uma Scene baseada em XML (FXML) e associação à primaryStage
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        Settings.Listacarro();
        Settings.ListaVenda();
        Settings.ListaVendedor();
        primaryStage.setTitle("Stand");

        Settings.setPrimaryStage(primaryStage);


        //Abertura da stage
        primaryStage.show();
    }
}
