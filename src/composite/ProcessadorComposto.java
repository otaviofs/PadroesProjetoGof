package composite;

import java.io.IOException;
import java.util.List;

public class ProcessadorComposto implements Processador {

	private List<Processador> processadores;
	
	public ProcessadorComposto(List<Processador> processadores) {
		super();
		this.processadores = processadores;
	}

	@Override
	public byte[] processaConteudo(byte[] bytes) throws IOException {
		for (Processador processador: processadores) {
			bytes = processador.processaConteudo(bytes);
		}
		return bytes;
	}

}
