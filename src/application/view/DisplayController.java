package application.view;

import application.controller.SubstitutionEncoder;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class DisplayController {

	@FXML
	private TextArea taEncode;
	
	@FXML private TextArea taDecode;
	
	@FXML
	public void encodeMessage(){
		String input = taEncode.getText();
		SubstitutionEncoder encoder = new SubstitutionEncoder();
		taDecode.setText(encoder.encodeMessage(input));
	}
	
	@FXML
	public void decodeMessage(){
		String input = taDecode.getText();
		SubstitutionEncoder decoder = new SubstitutionEncoder();
		taEncode.setText(decoder.decodeMessage(input));
	}
}
