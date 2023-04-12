/*
 * Auteur: Bilal Z. 
 * Description: Cela est le controller de l'application. C'est ou on détient tous les méthodes pour les actions que chaque élément sur sceneBuilder va effectuer. 
 */

package application;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;
import application.converters.FuelEconomy.FuelEconomyConverter;
import application.converters.frequency.FrequencyConverter;
import application.converters.length.LengthConverter;
import application.converters.mass.MassConverter;
import application.converters.plane_angle.PlaneAngleConverter;
import application.converters.volume.VolumeConverter;

public class SampleController implements Initializable  // Nous voulons initialiser tous les différents contrôles que nous avons sur notre créateur de scène. C'est une interface d'initialisation du contrôleur. Initializable et la méthode qu'il ajoute sont utilisés lorsque vous souhaitez interagir avec des éléments injectés avec @FXML. Pendant la construction, ces variables ne sont pas remplies, vous ne pouvez donc pas interagir avec elles. JavaFX appellera donc l'interface Initializable une fois que tout sera configuré. À ce stade, ces variables sont disponibles et peuvent être manipulées.
{

    @FXML // Utilisé pour marquer les champs de membre de contrôleur non publics et les méthodes de gestionnaire à utiliser par le balisage FXML. Ceci est requis pour les champs de membre privés de la classe de contrôleur ; sinon, l'injection de champ échouerait. Des exemples de champs de membre privés sont les zones de liste déroulante, les zones de texte et les boutons.
    private ComboBox<UnitTypeConverter> unitTypeMenu; // Initialisation du champ combobox principal. ComboBox de UnitTypeConverter. C'est la grande combobox en haut de la construction de SceneBuilder. C'est la liste déroulante qui changera les types de quantités que les unités que nous convertirons désigneront. Ainsi, dans cette liste déroulante, nous verrons des options telles que "longueur, masse, fréquence, etc".

    @FXML // Utilisé pour marquer les champs de membre de contrôleur non publics et les méthodes de gestionnaire à utiliser par le balisage FXML. Ceci est requis pour les champs de membre privés de la classe de contrôleur ; sinon, l'injection de champ échouerait. Des exemples de champs de membre privés sont les zones de liste déroulante, les zones de texte et les boutons.
    private ComboBox<BaseUnitConverter> rightUnitMenu; // Initialisation du champ combobox secondaire à droite. ComboBox de BaseUnitConverter. C'est la liste déroulante qui nous permettra de changer toutes les différentes unités pour notre conversion. Il s'agit de la plus petite zone de liste déroulante sur le côté droit de l'application SceneBuilder. Ici, nous pourrons changer d'unités comme "mètre en kilomètre". Cette combobox sera entièrement dépendante de la combobox principale.

    @FXML // Utilisé pour marquer les champs de membre de contrôleur non publics et les méthodes de gestionnaire à utiliser par le balisage FXML. Ceci est requis pour les champs de membre privés de la classe de contrôleur ; sinon, l'injection de champ échouerait. Des exemples de champs de membre privés sont les zones de liste déroulante, les zones de texte et les boutons.
    private ComboBox<BaseUnitConverter> leftUnitMenu; // Initialisation du champ combobox secondaire à gauche. ComboBox de BaseUnitConverter. C'est la liste déroulante qui nous permettra de changer toutes les différentes unités pour notre conversion. Il s'agit de la petite liste déroulante sur le côté gauche de l'application SceneBuilder. Ici, nous pourrons changer d'unités comme "mètre en kilomètre". Cette combobox sera entièrement dépendante de la combobox principale.

    @FXML // Utilisé pour marquer les champs de membre de contrôleur non publics et les méthodes de gestionnaire à utiliser par le balisage FXML. Ceci est requis pour les champs de membre privés de la classe de contrôleur ; sinon, l'injection de champ échouerait. Des exemples de champs de membre privés sont les zones de liste déroulante, les zones de texte et les boutons.
    private TextArea leftTextField; // Initialisation de la zone de texte de gauche. Cela n'acceptera que des valeurs numériques et vous pouvez soit saisir une valeur, soit afficher une valeur, selon que vous choisissez d'écrire dans la zone de texte de gauche ou de droite. Cette zone de texte de gauche se trouve juste au-dessus de la zone de liste déroulante de gauche.

    @FXML // Utilisé pour marquer les champs de membre de contrôleur non publics et les méthodes de gestionnaire à utiliser par le balisage FXML. Ceci est requis pour les champs de membre privés de la classe de contrôleur ; sinon, l'injection de champ échouerait. Des exemples de champs de membre privés sont les zones de liste déroulante, les zones de texte et les boutons.
    private TextArea rightTextField; // Initialisation de la zone de texte de droite. Cela n'acceptera que des valeurs numériques et vous pouvez soit saisir une valeur, soit afficher une valeur, selon que vous choisissez d'écrire dans la zone de texte de gauche ou de droite. Cette zone de texte de droite se trouve juste au-dessus de la zone de liste déroulante de droite.
    
    private static UnitTypeConverter lengthConverter = new LengthConverter(); // Passing in our actual length converter. Private static field et cela sera un type de UnitTypeConverter. We will call it "lengthConverter" but will implement it as our new LengthConverter, 
    private static UnitTypeConverter volumeConverter = new VolumeConverter();
    private static UnitTypeConverter plane_angleConverter = new PlaneAngleConverter();
    private static UnitTypeConverter fuel_ecoonomyConverter = new FuelEconomyConverter();
    private static UnitTypeConverter frequencyConverter = new FrequencyConverter();
    private static UnitTypeConverter massConverter = new MassConverter();

    private List<UnitTypeConverter> allUnitTypeConverters = Arrays.asList(lengthConverter, volumeConverter, plane_angleConverter, fuel_ecoonomyConverter, frequencyConverter, massConverter); // Creation of a list of all the different types of UnitTypeConverters we have. This is the list of unit types one will seee when they click on the top ComboBox. 
    

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		unitTypeMenu.getItems().addAll(allUnitTypeConverters); // This line of code will allow us to click on the ComboBox and be able to see and choose from all the different unit types we stated at the top. 
		unitTypeMenu.getSelectionModel().selectFirst(); // To make it more user friendly, this will automatically select the first item in our list when we start the application so that the user can see that the top ComboBox changes unit type. 
		unitTypeMenu.setConverter(new StringConverter<UnitTypeConverter>() // We want to convert this UnitTypeConverter to a string. The reason we want to do it is because whenever we select on one of the UnitTypeConverters, we want a very quick and easy way to tell which Unit type it is. This is why we had the "getUnitType" method. We need to set some sort of converter on this ComboBox and create a new String converter which is of a type of UnitTypeConverter. 
		{

			@Override // unimplemented method of the new StringConverter
			public String toString(UnitTypeConverter converter)  // argument is called converter here
			{
				return converter.getUnitType(); // we will return the Unit type 
			}

			@Override // unimplemented method of the new StringConverter
			public UnitTypeConverter fromString(String string)
			{
				return null; // doesn't need to really return anything. 
			}

		
			
		});
		
		List<BaseUnitConverter> baseUnitConverters = unitTypeMenu.getValue().getBaseUnitConvertersList(); // This is to get the list of unit converters for the unit type we select. So when we choose length we only get the list of units for length. This list is of type BaseUnitConverters. 
		leftUnitMenu.getItems().addAll(baseUnitConverters); // This adds the whole list of units for the specific unit type on the left ComboBox.
		rightUnitMenu.getItems().addAll(baseUnitConverters); // This adds the whole list of units for the specific unit type on the right ComboBox.
		
		leftUnitMenu.getSelectionModel().select(0); // Pour le premier ComboBox au gauche, on prend le premier index dans le liste de standardbaseunits. 
		rightUnitMenu.getSelectionModel().select(1); // Pour le deuxieme ComboBox a la droite, on prend le deuxieme index dans le liste de standardbaseunits. 
		
		StringConverter<BaseUnitConverter> baseUnitStringConverter = new StringConverter<BaseUnitConverter>() // We want to convert this baseUnitConverter to a string. The reason we want to do it is because whenever we select on one of the baseUnitConverters, we want a very quick and easy way to tell which Unit type it is. This is similar to the method specified above this time only it is the type BaseUnit and not Unit type. This is because at first we were talking about the main combo box with all the unit types, now we are talking about the secondary ComboBoxes with all the base unit types that are in function of the main Unit Type. 
		
		{

			@Override
			public String toString(BaseUnitConverter converter) // Returns a BaseUnitConverter. Here we are going to a string. 
			{
				return converter == null ? null: converter.getName(); // Returns the class getName only implemented in our BaseUnitConverter class, similar logic as the UnitTypeConverter UnitType class. 
			}

			@Override
			public BaseUnitConverter fromString(String string) // Accepts a BaseUnitConverter. Here we are going from a string. 
			{
				return null; // Just like previously, we don't really need to return anything here
			}
	
	}; 
	leftUnitMenu.setConverter(baseUnitStringConverter); // We are passing in the whole list of baseunitconverters, so all the units we can convert into the left ComboBox. 
	rightUnitMenu.setConverter(baseUnitStringConverter); // We are passing in the whole list of baseunitconverters, so all the units we can convert into the right ComboBox. 
		
	}
	
	public void onUnitTypeChange(ActionEvent e) // Accepte un ActionEvent. Un événement représentant un certain type d'action. Ce type d'événement est largement utilisé pour représenter une variété de choses, comme quand un Button a été déclenché, quand un KeyFrame s'est terminé, et d'autres utilisations similaires.
	{
		//Donc quand on choisi un unit type, on prend la liste de tous les base units de ce unit type. 
		ObservableList<BaseUnitConverter> newBaseConverters =  
				FXCollections.observableArrayList(unitTypeMenu.getValue().getBaseUnitConvertersList());
		
		leftTextField.setText(""); // On va set le textfield au gauche a rien
		rightTextField.setText(""); // On va set le textfield au droite a rien

		
		leftUnitMenu.setItems(newBaseConverters); // We want to add all the units for the specific unit type, so the whole list of them on the left ComboBox so the user can change them to the conversion he wants.
		rightUnitMenu.setItems(newBaseConverters); // We want to add all the units for the specific unit type, so the whole list of them on the right ComboBox so the user can change them to the conversion he wants.
		
		leftUnitMenu.getSelectionModel().select(0); // We can make the application automatically select the first base unit of the list on the left ComboBox to make it more user friendly and easier to understand and use. It will taker the base unit and index 0 of the baseunitconverters list. 
		rightUnitMenu.getSelectionModel().select(1); // As the leftComboBox takes the first index of the list, the right ComboBox can take the second index, or otherwise index 1. This is to make the application more user friendly as now the user has already a default conversion type he can work with and it will help him better understand how to manipulate the ComboBoxes. 

	}
	
	public void onLeftUnitMenuChange(ActionEvent e) // Method for when we change the unit in the left ComboBox. Accept un ActionEvent. Un événement représentant un certain type d'action. Ce type d'événement est largement utilisé pour représenter une variété de choses, comme quand un Button a été déclenché, quand un KeyFrame s'est terminé, et d'autres utilisations similaires.
	{
		convertRightToLeft(); // Because when I change the left ComboBox, I want to reconvert the left textfield so we will have to apply the method where we convert from the right text field to the left text field. 
	}
	
	public void onRightUnitMenuChange(ActionEvent e) // Method for when we change the unit in the right ComboBox. Accepte un ActionEvent. Un événement représentant un certain type d'action. Ce type d'événement est largement utilisé pour représenter une variété de choses, comme quand un Button a été déclenché, quand un KeyFrame s'est terminé, et d'autres utilisations similaires.
	{
		convertLeftToRight(); // Because when I change the right ComboBox, I want to reconvert the right textfield so we will have to apply the method where we convert from the right text field to the left text field. 
	}
	
	public void onLeftTextFieldChange(KeyEvent e) // Method for when we change the left textfield. Un événement qui indique qu'une frappe s'est produite dans un composant. Cet événement de bas niveau est généré par un objet composant (dans notre cas un champ de texte) lorsqu'une touche est enfoncée, relâchée ou tapée.
	{

		if(e.getCharacter().matches("[^\\e\t\r\\d+$]")) // si le char que nous prenons quand on press un key est un char qui n'ést pas un nombre entre 0 a 9
		{
			e.consume(); // on va "consumer" le char ou bien l'effacer
			leftTextField.setStyle("-fx-border-color: red"); // Si on a taper un char qui n'est pas un numéro, on change le contour du textfield a rouge, pour indiquer a l'usager. 
		}
		
		convertLeftToRight(); // So when we change the left textfield, naturally we will apply the method for converting from the left textfield to the right textfield. 
	}
	
	public void onRightTextFieldChange(KeyEvent e) // Method for when we change the right textfield. Un événement qui indique qu'une frappe s'est produite dans un composant. Cet événement de bas niveau est généré par un objet composant (dans notre cas un champ de texte) lorsqu'une touche est enfoncée, relâchée ou tapée.
	{
		if(e.getCharacter().matches("[^\\e\t\r\\d+$]"))
		{
			e.consume();
			leftTextField.setStyle("-fx-border-color: red");
		}
		
		convertRightToLeft();  // So when we change the right textfield, naturally we will apply the method for converting from the right textfield to the left textfield. 
	}
	
	private void convertLeftToRight() // Method for converting the right ComboBox after typing in a value in the left ComboBox
	{
		if(leftTextField.getText().isEmpty()) // if we type something into one of these text fields, for this method, the left texfield, making it an empty string
		{
			rightTextField.setText(""); // If its an empty string, we don't want to do any conversion, set the text to a blank, an empty string.
		}
		else // else, meaning there is a number written into the left texfield and its not blank
		{
			UnitTypeConverter unitConverter =  unitTypeMenu.getValue(); // When converting, we need to figure out what unit type we have like volume, length or frequency. 
			BigDecimal leftUnit = new BigDecimal(Double.parseDouble(leftTextField.getText())); // So extract our left number and it will be a BigDecimal so we have to use the parseDouble method to make the string written into a double numerical value. 
			BigDecimal rightUnit = unitConverter.convert(leftUnit, leftUnitMenu.getValue(), rightUnitMenu.getValue()); // Now that we have the unit we need to convert, convert the number to the right side. So the right side will equal the left side once it passes through the converter. To do this as the line of code shows, we need to know the numerical value, what we are converting from and what we are converting to. 
			rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString()); // Plug the new converted number into our right textField. We will remove all unnecessary zeros after the last significant digit and will convert the number back to a string. 
			System.out.println("Unit Changed"); // Just print on the console "Unit Changed" so we know it works. Completely optional and doesn't need to be in the code
		}
	}
	
	private void convertRightToLeft() // Same exact logic as the method convertLeftToRight but this time we re doing it from the right textfield and going to the left textfield. m
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
			System.out.println("Unit Changed");

		}
	}
}
