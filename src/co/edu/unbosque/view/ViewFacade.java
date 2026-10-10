package co.edu.unbosque.view;

public class ViewFacade {
	
	private VentanaPrincipal v;
	
	public ViewFacade() {
		v = new VentanaPrincipal();
	}
	
	public void recrearVentana() {
		v = new VentanaPrincipal();
	}

	public VentanaPrincipal getV() {
		return v;
	}

	public void setV(VentanaPrincipal v) {
		this.v = v;
	}

	
	
	
	

}
