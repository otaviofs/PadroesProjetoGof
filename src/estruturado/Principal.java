package estruturado;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		Map<String,Object> mapa = new HashMap<>();
		mapa.put("nome", "Carlos");
		mapa.put("idade", 32);
		

		GeradorArquivo gerador = new GeradorArquivo();
		gerador.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\Repositorio\\Cripto.txt", mapa, "PROPRIEDADES_CRIPTOGRAFADO");
		
		GeradorArquivo gerador1 = new GeradorArquivo();
		gerador1.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\Repositorio\\XML.zip", mapa, "XML_COMPACTADO");
	}
}
