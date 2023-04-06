package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class SampleController implements Initializable{
	@FXML
	private ComboBox<String> unitTypeMenu;
	@FXML
	private TextField leftTextField;
	@FXML
	private TextField rightTextField;
	@FXML
	private ComboBox<String> leftUnitMenu;
	@FXML
	private ComboBox<String> rightUnitMenu;
	
	
	
	public void onUnitTypeChange(ActionEvent e)
	{
		System.out.println("unit type changed!");
	}
	
	public void onLeftUnitMenuChange(ActionEvent e)
	{
		System.out.println("left menu changed!");
	}
	
	public void onRightUnitMenuChange(ActionEvent e)
	{
		System.out.println("right menu changed!");
	}
	
	public void onLeftTextFieldChange(KeyEvent e)
	{
		System.out.println("left text changed!");
	}
	
	public void onRightTextFieldChange(KeyEvent e)
	{
		System.out.println("right text changed!");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		unitTypeMenu.getItems().addAll("Unit 1", "Unit 2");
		leftUnitMenu.getItems().addAll("Unit 3", "Unit 4");
		rightUnitMenu.getItems().addAll("Unit 5", "Unit 6");
		
	}
}
