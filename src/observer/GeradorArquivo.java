package observer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class GeradorArquivo {
	
	private Processador processador;
	
	private List<Observador> observadores;
	
	public GeradorArquivo(Processador processador) {
		this.processador = processador;
		this.observadores = new ArrayList<Observador>();
	}
	
	public final void gerarArquivo(String nome, Map<String,Object> propriedades) throws IOException {
		String conteudo = gerarConteudo(propriedades);
		byte[] bytes = processador.processaConteudo(conteudo.getBytes());
		FileOutputStream fileout = new FileOutputStream(nome);
			fileout.write(bytes);
			fileout.close();
		notificar(nome, conteudo);
	}
	
	public void notificar(String nomeArquivo, String conteudo) {
		for (Observador observador: observadores) {
			observador.novoAquivoGerado(nomeArquivo, conteudo);
		}
	}
	
	public void addObservador(Observador observador) {
		this.observadores.add(observador);
	}
	
	protected abstract String gerarConteudo(Map<String,Object> propriedades);
	


}
