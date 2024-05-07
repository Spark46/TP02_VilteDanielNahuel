package ejercicio07.Main;

public class Producto {
	private String Codigo;
	private String Descripcion;
	private int PrecioUnitario;
	
    public enum OrigenFabricacion {
        ARGENTINA,
        CHINA,
        BRASIL,
        URUGUAY
    }
    
    public enum Categoria {
        TELEFONIA,
        INFORMATICA,
        ELECTROHOGAR,
        HERRAMIENTAS
    }
	
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;
    private boolean Disp;
    
	public Producto(String codigo, String descripcion, int precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean dispon) {
		super();
		Codigo = codigo;
		Descripcion = descripcion;
		PrecioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		Disp = dispon;
	}
    
    public void MostrarDatos() {
    	System.out.println("Codigo: "+Codigo);
    	System.out.println("Descripcion: "+Descripcion);
    	System.out.println("Precio Unitario: "+PrecioUnitario);
    	System.out.println("Origen de Fabricacion: "+this.origenFabricacion);
    	System.out.println("Categoria: "+this.categoria);
    }

	public String getCodigo() {
		return Codigo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getPrecioUnitario() {
		return PrecioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		PrecioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isDisp() {
		return Disp;
	}

	public void setDisp(boolean disp) {
		Disp = disp;
	}

	@Override
	public String toString() {
		return "Producto [Codigo=" + Codigo + ", Descripcion=" + Descripcion + ", PrecioUnitario=" + PrecioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + ", Disp=" + Disp + "]";
	}
    
	
	
}