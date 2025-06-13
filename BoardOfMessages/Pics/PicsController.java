package Pics;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PicsController {

    @FXML
    private ImageView img;

    @FXML
    private Label title;
    
    @FXML
    private VBox vbox;

    private String [] pics = { "Toy" , "Scot" , "Toy2" , "Scot2" };
    
    private int currPic;
    
    public void initialize() {
    	currPic = 0;
  
        bindImageSizeToVBox();
    	setPic();
    	setTitle();
    }
    
    private void bindImageSizeToVBox() {
        img.setPreserveRatio(true);
        VBox.setVgrow(img, Priority.ALWAYS);
        img.fitWidthProperty().bind(
            javafx.beans.binding.Bindings.subtract(
                vbox.widthProperty(),
                javafx.beans.binding.Bindings.add(title.widthProperty(), 45)
            )
        );

        img.fitHeightProperty().bind(
            javafx.beans.binding.Bindings.subtract(
                vbox.heightProperty(),
                javafx.beans.binding.Bindings.add(title.heightProperty(), 45)
            )
        );
    }

    
    private void setPic() {
    	Image image = new Image(getClass().getResource(pics[currPic]+".jpg").toExternalForm());
    	img.setImage(image);	
    }
    private void setTitle() {
        title.setText("~"+pics[currPic].toUpperCase()+"~"); 
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #3366cc; -fx-font-family: 'Arial';");
    }

    
    @FXML
    void onJumpPressed(ActionEvent event) {
    	String inputVal = JOptionPane.showInputDialog("Please enter picture number:");
    	try {
    		int inputNum = Integer.parseInt(inputVal);
    		if(inputNum >= 0  && inputNum <= pics.length-1) {
    			currPic = inputNum;
    			setPic();
    			setTitle();
    		}
    	}
    	catch(NumberFormatException e){
    		//Do nothing.
    	}
    }

    @FXML
    void onNextPressed(ActionEvent event) {
    	if(currPic == pics.length - 1) {
    		currPic = 0;
    	}else {
    		currPic++;
    	}
    	setPic();
    	setTitle();
    	
    }

}
