package chainsOfResponsability;

import java.util.Map;

public class GeradorAquivoPropriedades extends GeradorArquivo{
	
	public GeradorAquivoPropriedades(Processador processador) {
		super(processador);	
	}

	@Override
	protected String gerarConteudo(Map<String,Object> propriedades) {
		//gera propeties
		StringBuilder propFileBuilder = new StringBuilder();
		for (String prop: propriedades.keySet()){
			propFileBuilder.append(prop+"="+propriedades.get(prop)+"\n");
		}
		return propFileBuilder.toString();
	}
	

	
}
