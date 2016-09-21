package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {
		
		//server ws is created
		EstoqueWS implementacaoWS = new EstoqueWS();
		String URL = "http://localhost:8080/estoquews";

		System.out.println("EstoqueWS running: " + URL);

		// publish my URL (my url and my annotaded class with @WebService)
		Endpoint.publish(URL, implementacaoWS);
		
		//as chamadas aos serviços SOAP sempre devem ser via POST
		//SOAP (Simple Object Access Protocol)
		/** exemplo da chamada (pacote) do SOAP UI **
		POST http://localhost:8080/estoquews HTTP/1.1
		Accept-Encoding: gzip,deflate
		Content-Type: text/xml;charset=UTF-8
		SOAPAction: ""
		Content-Length: 224
		Host: localhost:8080
		Connection: Keep-Alive
		User-Agent: Apache-HttpClient/4.1.1 (java 1.5)
		*/
		/*
		Estilos de integração:
		Troca de arquivos
		Banco de dados compartilhado
		RPC Remote Procedure Call ( REST, SOAP)  -  modelo cliente-server (síncrono) 
		Mensageria
		*/
		 
	}
}