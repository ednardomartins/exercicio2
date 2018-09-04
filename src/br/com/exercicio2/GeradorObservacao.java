package br.com.exercicio2;

import java.util.List;

public class GeradorObservacao {

	private static final String SEPARDOR_E = " e ";

	private static final String SEPARDOR_VIRGULA = ", ";

	private static final String TEXTO_FATURA_UMA_NOTA_FISCAL = "Fatura da nota fiscal de simples remessa: %s.";

	private static final String TEXTO_FATURA_N_NOTA_FISCAL = "Fatura das notas fiscais de simples remessa: %s.";

	public String gerarObservacaoNotasFiscais(List<Integer> listaDeCodigosNotasFicais) {
		if (listaDeCodigosNotasFicais.isEmpty()) {
			return "";
		}
		return criarTextoParaObservacao(listaDeCodigosNotasFicais);
	}

	private String criarTextoParaObservacao(List<Integer> listaDeCodigosNotasFicais) {
		if (listaDeCodigosNotasFicais.size() < 2) {
			return String.format(TEXTO_FATURA_UMA_NOTA_FISCAL, listaDeCodigosNotasFicais.get(0));
		}
		String textolistaDeCodigosSeparadosPorVirgula = criarTextolistaDeCodigosSeparadosPorVirgula(
				listaDeCodigosNotasFicais);
		String textoUltimoElementoComSeparadorE = criarTextoUltimoElementoComSeparadorE(listaDeCodigosNotasFicais);
		return agruparTextoObservacao(textolistaDeCodigosSeparadosPorVirgula, textoUltimoElementoComSeparadorE);
	}

	private String criarTextolistaDeCodigosSeparadosPorVirgula(List<Integer> listaDeCodigosNotasFicais) {
		StringBuilder textoCodigosSepardosPorVirgula = new StringBuilder();
		for (int i = 0; i <= listaDeCodigosNotasFicais.size() - 2; i++) {
			textoCodigosSepardosPorVirgula.append(listaDeCodigosNotasFicais.get(i)).append(SEPARDOR_VIRGULA);
		}
		return textoCodigosSepardosPorVirgula.toString().substring(0, textoCodigosSepardosPorVirgula.length() - 2);
	}

	private String criarTextoUltimoElementoComSeparadorE(List<Integer> listaDeCodigosNotasFicais) {
		int tamanholistaDeCodigosNotasFicais = listaDeCodigosNotasFicais.size();
		Integer ultimoCodigoDalista = listaDeCodigosNotasFicais.get(tamanholistaDeCodigosNotasFicais - 1);
		return new StringBuilder().append(SEPARDOR_E).append(ultimoCodigoDalista).toString();
	}

	private String agruparTextoObservacao(String textolistaDeCodigosSeparadosPorVirgula,
			String textoUltimoElementoComSeparadorE) {
		String textoFinal = new StringBuilder().append(textolistaDeCodigosSeparadosPorVirgula)
				.append(textoUltimoElementoComSeparadorE).toString();
		return String.format(TEXTO_FATURA_N_NOTA_FISCAL, textoFinal);
	}
}