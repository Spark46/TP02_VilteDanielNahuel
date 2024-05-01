package ejercicio03.Constantes;

public enum Provincias {
	JUJUY(672260, 53219), 
    SALTA(1333365, 155488),
    TUCUMAN(1690382, 22524),
    CATAMARCA(367828, 102602),
    LA_RIOJA(398648, 89680),
    SANTIAGO_DEL_ESTERO(874006, 136351);

	private int poblacion;
	private int superficie;
	
	private Provincias(int poblacion, int superficie) {
        this.poblacion = poblacion;
        this.superficie = superficie;
    }

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double Densidad() {
        return (double) poblacion / superficie;
    }
	
}
