package dad.javafx.checkpalindrome;

import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {
	
	private Label palindLabel;
	private Button saludarButton;
	private TextField nombreText;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		nombreText=new TextField();
		nombreText.setMaxWidth(150);
		nombreText.setPromptText("Introduce una palabra: ");
		
		saludarButton = new Button("Comprobar");
		saludarButton.setDefaultButton(true);
		saludarButton.setOnAction(e -> onSaludarButtonAction(e));
		
		palindLabel=new Label("Es palíndromo / No es palíndromo");
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreText,saludarButton,palindLabel);
		
		
		
		Scene scene = new Scene(root, 320,200);
		
		primaryStage.setTitle("Comprobador de palíndromos");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onSaludarButtonAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String palabra = nombreText.getText();
		int i;
		int j = palabra.length()-1;
		boolean esPalind=true;
		if (palabra.length()==1) {
			palindLabel.setText("Es palíndromo.");
		} else {
			for (i=0; i!=j && esPalind; i++) {
				if (palabra.charAt(i) != palabra.charAt(palabra.length()-1-i)) {
					esPalind=false;
				}
			}
			if (esPalind) {
				palindLabel.setText("Es palíndromo.");
				palindLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 12 sans-serif;");
			} else {
				palindLabel.setText("No es palíndromo.");
				palindLabel.setStyle("-fx-text-fill: red; -fx-font: italic bold 12 sans-serif;");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	

}
