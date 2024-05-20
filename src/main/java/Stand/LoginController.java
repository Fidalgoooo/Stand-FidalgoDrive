package Stand;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
    public Button btnlogin;
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void buttonLogin(ActionEvent actionEvent) throws Exception{
        // Verifica se o nome e a palavra-passe correspondem
        if(txtUsername.getText().equals("Afonso") && txtPassword.getText().equals("admin")){

            // Carrega a próxima janela (Principal.fxml)
            Parent scene = FXMLLoader.load(getClass().getResource("Principal.fxml"));
            //primaryStage.initStyle(StageStyle.UNDECORATED);
            Stage back = new Stage();

            //Definições da Stage
            back.setTitle("");
            back.setResizable(false);
            back.initModality(Modality.WINDOW_MODAL);
            back.setScene(new Scene(scene));

            // Esconde a janela de login e mostra a próxima janela
            Window window = btnlogin.getScene().getWindow();
            window.hide();
            back.show();
        }
        else {

            // Mostra uma mensagem de erro se o login falhar
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText("Nome ou palavra passe incorretos,tente novamente!");
            alert.setContentText("clique no botao para continuar.");
            alert.show();
        }

    }
}