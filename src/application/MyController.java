package application;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextField;

public class MyController {
	@FXML
	private Button btnSorpresa;
	

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private LocalDate primavera = LocalDate.parse("20-03-2019", formatter);
	private LocalDate verano = LocalDate.parse("21-06-2019", formatter);
	private LocalDate otono = LocalDate.parse("22-09-2019", formatter);
	private LocalDate invierno = LocalDate.parse("21-11-2019", formatter);
	private Alert alert;
	private Month mes = LocalDate.now().getMonth();
	private int dia = LocalDate.now().getDayOfMonth();

	@FXML
	public void initialize() {

	}

	// When user click on myButton this method will be called.
	public void showDateTime(ActionEvent event) {
		createChoiceBox();

	}

	private void createInfoBox(String respuesta) {

		if (respuesta.equals("error")) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR EN LA ELECCION");
			alert.setHeaderText("No eligio ninguna opcion");

		} else {
			alert = new Alert(AlertType.INFORMATION);
			
			switch (respuesta) {
			case "spring":
				if (esEstacion(respuesta)) {
					alert.setTitle("PRIMAVERA");
					alert.setHeaderText("¡¡¡Estamos en primavera!!!");
					alert.setContentText("Estamos en tu estación favorita, corre a la calle y celebralo");
				} else {
					alert.setAlertType(AlertType.WARNING);
					alert.setTitle("PRIMAVERA");
					alert.setHeaderText("Una pena que no estemos en primavera");
					alert.setContentText("Te toca esperar hasta el 20 de Marzo");
				}
				break;
			case "summer":
				if (esEstacion(respuesta)) {
					alert.setTitle("VERANO");
					alert.setHeaderText("¡¡¡Estamos en verano!!!");
					alert.setContentText("Estamos en tu estación favorita, corre a la calle y celebralo");
				} else {
					alert.setAlertType(AlertType.WARNING);
					alert.setTitle("VERANO");
					alert.setHeaderText("Una pena que no estemos en verano");
					alert.setContentText("Te toca esperar hasta el 21 de Junio");
				}
				break;
			case "autumn":
				if (esEstacion(respuesta)) {
					alert.setTitle("OTONO");
					alert.setHeaderText("¡¡¡Estamos en otono!!!");
					alert.setContentText("Estamos en tu estación favorita, corre a la calle y celebralo");
				} else {
					alert.setAlertType(AlertType.WARNING);
					alert.setTitle("OTONO");
					alert.setHeaderText("Una pena que no estemos en otono");
					alert.setContentText("Te toca esperar hasta el 22 de Septiembre");
				}
				break;
			case "winter":
				if (esEstacion(respuesta)) {
					alert.setTitle("INVIERNO");
					alert.setHeaderText("¡¡¡Estamos en invierno!!!");
					alert.setContentText("Estamos en tu estación favorita, corre a la calle y celebralo");
				} else {
					alert.setAlertType(AlertType.WARNING);
					alert.setTitle("INVIERNO");
					alert.setHeaderText("Una pena que no estemos en invierno");
					alert.setContentText("Te toca esperar hasta el 21 de Diciembre");
				}
				break;

			}
		}

		alert.showAndWait();
	}

	private void createChoiceBox() {
		List<String> choices = new ArrayList<>();
		choices.add("Spring");
		choices.add("Summer");
		choices.add("Autumn");
		choices.add("Winter");

		ChoiceDialog<String> dialog = new ChoiceDialog<>("Spring", choices);
		dialog.setTitle("Eleccion de Estacion");
		dialog.setHeaderText("Piense en todas las estaciones");
		dialog.setContentText("¿Cual es tu favorita?:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			createInfoBox(result.get().toLowerCase());
		} else {
			createInfoBox("error");
		}

	}

	private boolean esEstacion(String respuesta) {
		boolean value = false;
		switch (respuesta) {
		case "spring":
			if (mes.compareTo(primavera.getMonth()) > 0 && mes.compareTo(verano.getMonth()) < 0) {
				value = true;
			} else if (mes.compareTo(primavera.getMonth()) == 0 && dia >= primavera.getDayOfMonth()) {
				value = true;
			} else if (mes.compareTo(verano.getMonth()) == 0 && dia < verano.getDayOfMonth()) {
				value = true;
			}
			break;
		case "summer":
			if (mes.compareTo(verano.getMonth()) > 0 && mes.compareTo(otono.getMonth()) < 0) {
				value = true;
			} else if (mes.compareTo(verano.getMonth()) == 0 && dia >= verano.getDayOfMonth()) {
				value = true;
			} else if (mes.compareTo(otono.getMonth()) == 0 && dia < otono.getDayOfMonth()) {
				value = true;
			}

			break;
		case "autumn":
			if (mes.compareTo(otono.getMonth()) > 0 && mes.compareTo(invierno.getMonth()) < 0) {
				value = true;
			} else if (mes.compareTo(otono.getMonth()) == 0 && dia >= otono.getDayOfMonth()) {
				value = true;
			} else if (mes.compareTo(invierno.getMonth()) == 0 && dia < invierno.getDayOfMonth()) {
				value = true;
			}
			break;
		case "winter":
			if (mes.compareTo(invierno.getMonth()) > 0 && mes.compareTo(primavera.getMonth()) < 0) {
				value = true;
			} else if (mes.compareTo(invierno.getMonth()) == 0 && dia >= invierno.getDayOfMonth()) {
				value = true;
			} else if (mes.compareTo(primavera.getMonth()) == 0 && dia < primavera.getDayOfMonth()) {
				value = true;
			}
			break;
		}
		return value;
	}
}