package observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;;

public class Principal {
	public static void main(String[] args) throws IOException {
		Map<String,Object> mapa = new HashMap<>();
		mapa.put("nome", "Carlos");
		mapa.put("idade", 32);
		
		List<Processador> processadores = new ArrayList<Processador>();
		processadores.add(new ProcessaCriptografado());
		processadores.add(new ProcessaCompactado());
		
		List<Processador> processadores1 = new ArrayList<Processador>();
		processadores1.add(new ProcessaCompactado());
		processadores1.add(new ProcessaCriptografado());
		
		List<Processador> processadores2 = new ArrayList<Processador>();
		processadores2.add(new ProcessaDefault());
		processadores2.add(new ProcessaCompactado());
		
		GeradorArquivo gerador = new GeradorAquivoPropriedades(new ProcessadorComposto(processadores));
		gerador.addObservador(new LogService());
		gerador.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\Repositorio\\prop1.zip", mapa);
		
		GeradorArquivo gerador1 = new GeradorArquivoXml(new ProcessadorComposto(processadores1));
		gerador1.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\Repositorio\\xml1.txt", mapa);
		
		GeradorArquivo gerador2 = new GeradorAquivoPropriedades(new ProcessadorComposto(processadores2));
		gerador2.gerarArquivo("C:\\Users\\otavi\\Documents\\Pos_Ads_Iftm\\POO\\Repositorio\\default.zip", mapa);
	}
}
