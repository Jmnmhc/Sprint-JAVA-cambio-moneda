package com.Ihc.modelo;

	public class Monedas {

		private String moneda;
		private double tipoCambio;
		
		public Monedas(String moneda, double tipoCambio) {
			super();
			this.moneda = moneda;
			this.tipoCambio = tipoCambio;
		}

		public String getMoneda() {
			return moneda;
		}

		public double getTipoCambio() {
			return tipoCambio;
		}

	}
	

