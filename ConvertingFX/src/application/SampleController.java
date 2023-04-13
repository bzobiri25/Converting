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
    
    private static UnitTypeConverter lengthConverter = new LengthConverter(); // Passez notre convertisseur de longueur réelle. Champ statique privé et ce sera un type de UnitTypeConverter. Nous l'appellerons "lengthConverter" mais implémentez-le comme notre nouveau LengthConverter,
    private static UnitTypeConverter volumeConverter = new VolumeConverter();
    private static UnitTypeConverter plane_angleConverter = new PlaneAngleConverter();
    private static UnitTypeConverter fuel_ecoonomyConverter = new FuelEconomyConverter();
    private static UnitTypeConverter frequencyConverter = new FrequencyConverter();
    private static UnitTypeConverter massConverter = new MassConverter();

    private List<UnitTypeConverter> allUnitTypeConverters = Arrays.asList(lengthConverter, volumeConverter, plane_angleConverter, fuel_ecoonomyConverter, frequencyConverter, massConverter); // Création d'une liste de tous les différents types de UnitTypeConverters que nous avons. Il s'agit de la liste des types d'unités que l'on verra en cliquant sur la ComboBox du haut.
    

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		unitTypeMenu.getItems().addAll(allUnitTypeConverters); // Cette ligne de code nous permettra de cliquer sur le ComboBox et de pouvoir voir et choisir parmi tous les différents types d'unités que nous avons montrés ci-dessus.
		unitTypeMenu.getSelectionModel().selectFirst(); // Pour le rendre plus convivial, cela sélectionnera automatiquement le premier élément de notre liste lorsque nous démarrons l'application afin que l'utilisateur puisse voir que le ComboBox du haut change de type d'unité. 
		unitTypeMenu.setConverter(new StringConverter<UnitTypeConverter>() // Nous voulons convertir ce UnitTypeConverter en une chaîne. La raison pour laquelle nous voulons le faire est que chaque fois que nous sélectionnons l'un des UnitTypeConverters, nous voulons un moyen très rapide et facile de dire de quel type d'unité il s'agit. C'est pourquoi nous avons eu la méthode "getUnitType". Nous devons définir une sorte de convertisseur sur ce ComboBox et créer un nouveau convertisseur de chaîne de type UnitTypeConverter. 
		{

			@Override // méthode non implémentée du nouveau StringConverter
			public String toString(UnitTypeConverter converter)  // l'argument est appelé convertisseur ici
			{
				return converter.getUnitType(); // nous renverrons le type d'unité
			}

			@Override // méthode non implémentée du nouveau StringConverter
			public UnitTypeConverter fromString(String string)
			{
				return null; // n'a pas vraiment besoin de retourner quoi que ce soit.
			}

		
			
		});
		
		List<BaseUnitConverter> baseUnitConverters = unitTypeMenu.getValue().getBaseUnitConvertersList(); // C'est pour obtenir la liste des convertisseurs d'unités pour le type d'unité que nous sélectionnons. Ainsi, lorsque nous choisissons la longueur, nous n'obtenons que la liste des unités de longueur. Cette liste est de type BaseUnitConverters.
		leftUnitMenu.getItems().addAll(baseUnitConverters); // Cela ajoute la liste complète des unités pour le type d'unité spécifique sur le ComboBox de gauche.
		rightUnitMenu.getItems().addAll(baseUnitConverters); // Cela ajoute la liste complète des unités pour le type d'unité spécifique sur le ComboBox droit.
		
		leftUnitMenu.getSelectionModel().select(0); // Pour le premier ComboBox au gauche, on prend le premier index dans le liste de standardbaseunits. 
		rightUnitMenu.getSelectionModel().select(1); // Pour le deuxieme ComboBox a la droite, on prend le deuxieme index dans le liste de standardbaseunits. 
		
		StringConverter<BaseUnitConverter> baseUnitStringConverter = new StringConverter<BaseUnitConverter>() // Nous voulons convertir ce baseUnitConverter en une chaîne. La raison pour laquelle nous voulons le faire est que chaque fois que nous sélectionnons l'un des baseUnitConverters, nous voulons un moyen très rapide et facile de dire de quel type d'unité il s'agit. Ceci est similaire à la méthode spécifiée ci-dessus, mais cette fois-ci, il s'agit du type BaseUnit et non du type Unit. En effet, au début, nous parlions de la zone de liste déroulante principale avec tous les types d'unités, maintenant nous parlons des zones de liste déroulante secondaires avec tous les types d'unités de base qui sont en fonction du type d'unité principal.
		
		{

			@Override
			public String toString(BaseUnitConverter converter) // Renvoie un BaseUnitConverter. Ici, nous allons à une chaîne.
			{
				return converter == null ? null: converter.getName(); // Renvoie la classe getName uniquement implémentée dans notre classe BaseUnitConverter, logique similaire à la classe UnitTypeConverter UnitType.
			}

			@Override
			public BaseUnitConverter fromString(String string) // Accepte un BaseUnitConverter. Ici, nous partons d'une chaîne.
			{
				return null; // Tout comme précédemment, nous n'avons pas vraiment besoin de retourner quoi que ce soit ici
			}
	
	}; 
	leftUnitMenu.setConverter(baseUnitStringConverter); // Nous transmettons toute la liste des convertisseurs d'unités de base, donc toutes les unités que nous pouvons convertir dans le ComboBox de gauche. 
	rightUnitMenu.setConverter(baseUnitStringConverter); // Nous transmettons toute la liste des convertisseurs d'unités de base, donc toutes les unités que nous pouvons convertir dans le bon ComboBox.
		
	}
	
	public void onUnitTypeChange(ActionEvent e) // Accepte un ActionEvent. Un événement représentant un certain type d'action. Ce type d'événement est largement utilisé pour représenter une variété de choses, comme quand un Button a été déclenché, quand un KeyFrame s'est terminé, et d'autres utilisations similaires.
	{
		//Donc quand on choisi un unit type, on prend la liste de tous les base units de ce unit type. 
		ObservableList<BaseUnitConverter> newBaseConverters =  
				FXCollections.observableArrayList(unitTypeMenu.getValue().getBaseUnitConvertersList());
		
		leftTextField.setText(""); // On va set le textfield au gauche a rien
		rightTextField.setText(""); // On va set le textfield au droite a rien

		
		leftUnitMenu.setItems(newBaseConverters); // Nous voulons ajouter toutes les unités pour le type d'unité spécifique, donc la liste complète d'entre elles sur la ComboBox de gauche afin que l'utilisateur puisse les modifier pour la conversion qu'il souhaite.
		rightUnitMenu.setItems(newBaseConverters); // Nous voulons ajouter toutes les unités pour le type d'unité spécifique, donc la liste complète d'entre elles sur la droite ComboBox afin que l'utilisateur puisse les modifier pour la conversion qu'il souhaite.
		
		leftUnitMenu.getSelectionModel().select(0); // Nous pouvons faire en sorte que l'application sélectionne automatiquement la première unité de base de la liste sur la ComboBox de gauche pour la rendre plus conviviale et plus facile à comprendre et à utiliser. Il prendra l'unité de base et l'index 0 de la liste des convertisseurs d'unité de base.
		rightUnitMenu.getSelectionModel().select(1); // Comme le leftComboBox prend le premier index de la liste, le right ComboBox peut prendre le deuxième index, ou sinon l'index 1. Ceci est pour rendre l'application plus conviviale car maintenant l'utilisateur a déjà un type de conversion par défaut avec lequel il peut travailler et cela l'aidera à mieux comprendre comment manipuler les ComboBoxes.

	}
	
	public void onLeftUnitMenuChange(ActionEvent e) // Méthode pour quand nous changeons l'unité dans le ComboBox de gauche. Acceptez un ActionEvent. Un événement représentant un certain type d'action. Ce type d'événement est largement utilisé pour représenter une variété de choses, telles que le déclenchement d'un bouton, la fin d'un KeyFrame et d'autres utilisations similaires.
	{
		convertRightToLeft(); // Parce que lorsque je change le ComboBox gauche, je veux reconvertir le champ de texte gauche, nous devrons donc appliquer la méthode où nous convertissons du champ de texte droit au champ de texte gauche.
	}
	
	public void onRightUnitMenuChange(ActionEvent e) // Méthode pour quand nous changeons l'unité dans le bon ComboBox. Accepte un ActionEvent. Un événement représentant un certain type d'action. Ce type d'événement est largement utilisé pour représenter une variété de choses, telles que le déclenchement d'un bouton, la fin d'un KeyFrame et d'autres utilisations similaires.
	{
		convertLeftToRight();// Parce que lorsque je change le ComboBox droit, je veux reconvertir le champ de texte droit, nous devrons donc appliquer la méthode où nous convertissons du champ de texte droit au champ de texte gauche.
	}
	
	public void onLeftTextFieldChange(KeyEvent e) // Méthode pour quand nous changeons le champ de texte gauche. Un événement qui indique qu'une frappe s'est produite dans un composant. Cet événement de bas niveau est généré par un objet composant (dans notre cas un champ de texte) lorsqu'une touche est enfoncée, relâchée ou tapée.
	{

		if(e.getCharacter().matches("[^\\e\t\r\\d+$]")) // si le char que nous prenons quand on press un key est un char qui n'ést pas un nombre entre 0 a 9
		{
			e.consume(); // on va "consumer" le char ou bien l'effacer
			leftTextField.setStyle("-fx-border-color: red"); // Si on a taper un char qui n'est pas un numéro, on change le contour du textfield a rouge, pour indiquer a l'usager. 
		}
		
		convertLeftToRight(); // Ainsi, lorsque nous modifions le champ de texte gauche, nous appliquerons naturellement la méthode de conversion du champ de texte gauche vers le champ de texte droit.
	}
	
	public void onRightTextFieldChange(KeyEvent e) // Méthode pour quand nous changeons le bon champ de texte. Un événement qui indique qu'une frappe s'est produite dans un composant. Cet événement de bas niveau est généré par un objet composant (dans notre cas un champ de texte) lorsqu'une touche est enfoncée, relâchée ou tapée.
	{
		if(e.getCharacter().matches("[^\\e\t\r\\d+$]"))
		{
			e.consume();
			leftTextField.setStyle("-fx-border-color: red");
		}
		
		convertRightToLeft();  // Ainsi, lorsque nous changeons le champ de texte droit, nous appliquerons naturellement la méthode de conversion du champ de texte droit vers le champ de texte gauche.
	}
	
	private void convertLeftToRight() // Méthode de conversion du ComboBox de droite après saisie d'une valeur dans le ComboBox de gauche
	{
		if(leftTextField.getText().isEmpty()) // si nous tapons quelque chose dans l'un de ces champs de texte, pour cette méthode, le champ de texte gauche, ce qui en fait une chaîne vide
		{
			rightTextField.setText(""); // Si c'est une chaîne vide, nous ne voulons pas faire de conversion, définissez le texte sur un espace, une chaîne vide.
		}
		else // sinon, ce qui signifie qu'il y a un nombre écrit dans le champ de texte de gauche et qu'il n'est pas vide
		{
			UnitTypeConverter unitConverter =  unitTypeMenu.getValue(); // Lors de la conversion, nous devons déterminer quel type d'unité nous avons, comme le volume, la longueur ou la fréquence.
			BigDecimal leftUnit = new BigDecimal(Double.parseDouble(leftTextField.getText())); // Donc, extrayez notre nombre de gauche et ce sera un BigDecimal, nous devons donc utiliser la méthode parseDouble pour que la chaîne soit écrite dans une valeur numérique double.
			BigDecimal rightUnit = unitConverter.convert(leftUnit, leftUnitMenu.getValue(), rightUnitMenu.getValue()); // Maintenant que nous avons l'unité à convertir, convertissez le nombre sur le côté droit. Ainsi, le côté droit sera égal au côté gauche une fois qu'il aura traversé le convertisseur. Pour ce faire, comme le montre la ligne de code, nous devons connaître la valeur numérique, à partir de quoi nous convertissons et en quoi nous convertissons.
			rightTextField.setText(rightUnit.stripTrailingZeros().toPlainString()); // Branchez le nouveau nombre converti dans notre champ de texte droit. Nous supprimerons tous les zéros inutiles après le dernier chiffre significatif et reconvertirons le nombre en chaîne.
			System.out.println("Unit Changed"); // Il suffit d'imprimer sur la console "Unit Changed" pour que nous sachions que cela fonctionne. Entièrement facultatif et n'a pas besoin d'être dans le code
		}
	}
	
	private void convertRightToLeft() // Même logique exacte que la méthode convertLeftToRight mais cette fois nous le faisons depuis le champ de texte droit et allons vers le champ de texte gauche. m
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
