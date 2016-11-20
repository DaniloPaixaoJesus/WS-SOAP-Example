package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizacaoException extends Exception {
	// esse numero eh relacionado com a serializacao do java.io mas nao importa
	// nesse contexto
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String mensagem) {
		// TODO Auto-generated constructor stub
		super(mensagem);
	}

	// metodo especifico para tratar o retorno do WSDL - fault 
	public InfoFault getFaultInfo() {
		return new InfoFault("Token Inválido", new Date());
	}

}
