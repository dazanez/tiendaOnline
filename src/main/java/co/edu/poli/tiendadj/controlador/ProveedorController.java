package co.edu.poli.tiendadj.controlador;

import co.edu.poli.tiendadj.modelo.Proveedor;
import co.edu.poli.tiendadj.modelo.Evaluacion;

import java.io.IOException;

import co.edu.poli.tiendadj.MainView;
import co.edu.poli.tiendadj.modelo.Certificacion;
import co.edu.poli.tiendadj.modelo.PoliticaEntrega;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class ProveedorController extends ControladorBase {

	@FXML
	private TextField evaluacionField;
	@FXML
	private TextField certificacionField;
	@FXML
	private TextField politicaEntregaField;
	@FXML
	private TextArea resultadoArea;

	@FXML
	private void crearProveedor() {
		if (evaluacionField == null || certificacionField == null || politicaEntregaField == null) {
			System.out.println("Error: Un campo no está inicializado correctamente en FXML.");
			return;
		}

		Evaluacion evaluacion = new Evaluacion(evaluacionField.getText());
		Certificacion certificacion = new Certificacion(certificacionField.getText());
		PoliticaEntrega politicaEntrega = new PoliticaEntrega(politicaEntregaField.getText());

		Proveedor proveedor = new Proveedor.Builder().setEvaluacion(evaluacion).setCertificacion(certificacion)
				.setPoliticaEntrega(politicaEntrega).build();

		resultadoArea.setText(proveedor.toString());
	}
}
