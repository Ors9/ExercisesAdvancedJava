import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ClientController {

    @FXML
    private TextField binary;

    @FXML
    private TextField decimal;

    @FXML
    void sendBtn(ActionEvent event) {
    	Data2 d = new Data2(Integer.parseInt(decimal.getText()),"");
    	new ClientThread(this, "127.0.0.1", d).start();
    }
    
    public void setBinaryNum(String bNum) {
    	binary.setText(bNum);
    }
}