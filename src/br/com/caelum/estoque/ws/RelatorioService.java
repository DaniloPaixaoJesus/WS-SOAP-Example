package br.com.caelum.estoque.ws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RelatorioService {

	@Oneway //método nao terá response //apenas retorno http 200 ok
    @WebMethod(operationName="GerarRelatorio")
    public void gerarRelatorio() { 
        // código omitido
    }

}