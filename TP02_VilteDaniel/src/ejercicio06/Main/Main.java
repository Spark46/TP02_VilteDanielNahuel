package ejercicio06.Main;

import ejercicio06.Interfaces.Funcionales.Converter;
import ejercicio06.Model.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);
		
		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		if(Converter.isNotNull(gato2)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			FelinoDomestico felino2 = converter2.convert(gato2);
			converter2.mostrarObjeto(felino2); 
		}
	}

}
