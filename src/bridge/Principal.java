package bridge;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;;

public class Principal {
	public static void main(String[] args) throws IOException {
		Map<String,Object> mapa = new HashMap<>();
		mapa.put("nome", "Carlos");
		mapa.put("idade", 32);
		
		GeradorArquivo gerador = new GeradorAquivoPropriedades(new ProcessaCriptografado());
		gerador.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\Cripto.txt", mapa);
		
		GeradorArquivo gerador1 = new GeradorArquivoXml(new ProcessaCompactado());
		gerador1.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\XML.zip", mapa);
		
		GeradorArquivo gerador2 = new GeradorAquivoPropriedades(new ProcessaDefault());
		gerador2.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\default.txt", mapa);
	}
}
