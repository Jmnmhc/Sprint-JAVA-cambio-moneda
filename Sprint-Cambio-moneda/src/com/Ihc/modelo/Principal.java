package com.Ihc.modelo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Monedas moneda1 = new Monedas("Dólares", 0.0083);
		Monedas moneda2 = new Monedas("Euros", 0.0077);
		Monedas moneda3 = new Monedas("Libras Esterlinas", 0.0066);
		Monedas moneda4 = new Monedas("Yenes (Japon)", 0.1000);
		Monedas moneda5 = new Monedas("Won (Corea del Sur)", 10.3800);
		Monedas moneda6 = new Monedas("Peso (Argentina)", 1.0000);

		List<Monedas> listaMonedas = new ArrayList<>();

		listaMonedas.add(moneda1);
		listaMonedas.add(moneda2);
		listaMonedas.add(moneda3);
		listaMonedas.add(moneda4);
		listaMonedas.add(moneda5);
		listaMonedas.add(moneda6);

		String[] botones = { "Comprar moneda extranjera", "vender moneda extranjera", "alguna otra opcion" };

		Object[] aElegirMonedas = { "Dólares", "Euros", "Libras Esterlinas", "Yenes (Japon)", "Won (Corea del Sur)" };


		int opciones = JOptionPane.showOptionDialog(null, "Elija por favor una opción", "Programa en Java",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

		String[] compraVenta = { "Comprar", "Vender", "Otra Cosa" };

//		String valor = (String) JOptionPane.showInputDialog(null, "Elija la moneda con la que desea operar",
//				"Cambio de Monedas", 3, null, aElegirMonedas, "Dólares");
		
		String ingresado = "";
		
		String seleccion = "";
		
		boolean esValido = false;
		
		if ( opciones < 2 ) {
			
			seleccion = (String) JOptionPane.showInputDialog(null, "Elija la moneda con la que desea operar",
			"Cambio de Monedas", 3, null, aElegirMonedas, "Dólares");
			
			 ingresado = (JOptionPane.showInputDialog("Cuantos " + seleccion + " desea " + compraVenta[opciones] + " ?"));
		}
		else {
			JOptionPane.showMessageDialog(null, "Opcion todavia sin implementar, disculpe las molestias");
			esValido = true;
		}

		String valor = seleccion;
		
		
		double revisado = 0;

		byte queOperacion = 0;
		
			while (!esValido) {
	
				if (funcionParaCambiarGuita(ingresado)) {
	
					revisado = Double.parseDouble(ingresado);
					esValido = true;
					} 
				else {
					revisado = 0;
					esValido = false;
	
					queOperacion = (byte) JOptionPane.showConfirmDialog(null,
							"el numero ingresado es incorrecto, desea intentarlo nuevamente?");
					
					if (queOperacion == 0) {
	
						ingresado = (JOptionPane
								.showInputDialog("Cuantos " + valor + " desea " + compraVenta[opciones] + " ?"));
					}
					else {
						JOptionPane.showMessageDialog(null, "adios");
						esValido=true;
					}

					System.out.println("tengo que mostrar el mensaje y pedir de nuevo ");
				}
	
			}

		double dineroACambiar = revisado;

		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();

		if (opciones == 0 && esValido) {
			listaMonedas.forEach(moneda -> {
				if (moneda.getMoneda() == valor) {
					JOptionPane.showMessageDialog(null, "eso significa que para " + compraVenta[opciones] + " "
							+ (formatoMoneda.format(dineroACambiar)) + " " + valor + " usted necesitará "
							+ (formatoMoneda.format(dineroACambiar / moneda.getTipoCambio())) + " Pesos Argentinos.");
				}
			});
		}

		else if (opciones == 1 && esValido) {
			listaMonedas.forEach(moneda -> {
				if (moneda.getMoneda() == valor) {
					JOptionPane.showMessageDialog(null, "eso significa que por " + compraVenta[opciones] + " "
							+ (formatoMoneda.format(dineroACambiar)) + " " + valor + " usted recibirá "
							+ (formatoMoneda.format(dineroACambiar / moneda.getTipoCambio())) + " Pesos Argentinos");
				}
			});
		}

		else {
			// ACA IRIA EL TEXTOD DE LA FUNCIONALIDAD EXTRA
//			System.out.println("FUNCIONALIDAD EXTRA");
		}

		queOperacion = (byte) JOptionPane.showConfirmDialog(null, "Desea Realizar otra operación?");

		if (queOperacion == 0) {
			main(args);
		} else {
			JOptionPane.showMessageDialog(null, "adios");
		}

	}

	private static boolean funcionParaCambiarGuita(String valor) {

		if (valor.matches(("-?\\d+"))) {

			return true;

		} else {
			return false;
		}

	}

}