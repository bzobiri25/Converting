package application;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;
import application.converters.length.LengthConverter;

public class SampleController implements Initializable
{

    @FXML
    private ComboBox<UnitTypeConverter> unitTypeMenu;

    @FXML
    private ComboBox<BaseUnitConverter> rightUnitMenu;

    @FXML
    private ComboBox<BaseUnitConverter> leftUnitMenu;

    @FXML
    private TextArea leftTextField;

    @FXML
    private TextArea rightTextField;
    
    private static UnitTypeConverter lengthConverter = new LengthConverter();
    private List<UnitTypeConverter> allUnitTypeConverters = Arrays.asList(lengthConverter);
    

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		unitTypeMenu.getItems().addAll(allUnitTypeConverters);
		unitTypeMenu.getSelectionModel().selectFirst();
		unitTypeMenu.setConverter(new StringConverter<UnitTypeConverter>(){

			@Override
			public String toString(UnitTypeConverter converter) 
			{
				return converter.getUnitType();
			}

			@Override
			public UnitTypeConverter fromString(String string)
			{
				return null;
			}

		
			
		});
		
		List<BaseUnitConverter> baseUnitConverters = unitTypeMenu.getValue().getBaseUnitConvertersList();
		leftUnitMenu.getItems().addAll(baseUnitConverters);
		rightUnitMenu.getItems().addAll(baseUnitConverters);
		
		leftUnitMenu.getSelectionModel().select(0);
		rightUnitMenu.getSelectionModel().select(1);
		
		StringConverter<BaseUnitConverter> baseUnitStringConverter = new StringConverter<BaseUnitConverter>(){

			@Override
			public String toString(BaseUnitConverter converter) 
			{
				return converter.getName();
			}

			@Override
			public BaseUnitConverter fromString(String string)
			{
				return null;
			}
	
	}; 
	leftUnitMenu.setConverter(baseUnitStringConverter);
	rightUnitMenu.setConverter(baseUnitStringConverter);
		
	}
	
	public void onUnitTypeChange(ActionEvent e)
	{
		System.out.println("unit type chnaged!");
	}
	
	public void onLeftUnitMenuChange(ActionEvent e)
	{
		convertRightToLeft();
	}
	
	public void onRightUnitMenuChange(ActionEvent e)
	{
		convertLeftToRight();
	}
	
	public void onLeftTextFieldChange(KeyEvent e)
	{
		convertLeftToRight();
	}
	
	public void onRightTextFieldChange(KeyEvent e)
	{
		convertRightToLeft();
	}
	
	private void convertLeftToRight()
	{
		if(leftTextField.getText().isEmpty())
		{
			rightTextField.setText("");
		}
		else
		{
			UnitTypeConverter unitConverter =  unitTypeMenu.getValue();
			BigDecimal leftUnit = new BigDecimal(Double.parseDouble(leftTextField.getText()));
			BigDecimal rightUnit = unitConverter.convert(leftUnit, leftUnitMenu.getValue(), rightUnitMenu.getValue());
			rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString());
		}
	}
	
	private void convertRightToLeft()
	{
		if(rightTextField.getText().isEmpty())
		{
			leftTextField.setText("");
		}
		else
		{
			UnitTypeConverter unitConverter =  unitTypeMenu.getValue();
			BigDecimal rightUnit = new BigDecimal(Double.parseDouble(rightTextField.getText()));
			BigDecimal leftUnit = unitConverter.convert(rightUnit, rightUnitMenu.getValue(), leftUnitMenu.getValue());
			leftTextField.setText(leftUnit.stripTrailingZeros().toPlainString());
			
		}
	}
}
