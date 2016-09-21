package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;
import br.com.caelum.estoque.modelo.usuario.Usuario;

@WebService //servico web soap
@SOAPBinding(style=Style.DOCUMENT, 
		use=Use.LITERAL, 
		parameterStyle=ParameterStyle.WRAPPED)
public class EstoqueWS {

	private ItemDao dao = new ItemDao();

	//customização do wsdl / response / request
	@WebMethod(operationName="TodosOsItens") //nome da operacao no response
	@ResponseWrapper(localName="itens") //substituiu o wrappper ListaItens
	@WebResult(name="itens") //retorno do processamento do metodo	
	public List<Item> getItens( @WebParam(name="filtros") Filtros filtros) {
		//public ListaItens getItens( @WebParam(name="filtros") Filtros filtros)
		System.out.println("Call method todosItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado  = dao.todosItens(lista);
		//return new ListaItens(itensResultado );
		return itensResultado;
	}
	
	@WebMethod(operationName = "CadastrarItem")
	// @ResponseWrapper(localName="item") usa apenas quando retorna uma lista
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		System.out.println("Call method cadastrarItem(Item)" + item);

		boolean valido = new TokenDao().ehValido(token);
		if (!valido) {
			throw new AutorizacaoException("Autorização falhou. Token Inválido");
		}

		dao.cadastrar(item);
		return item;
	}

	@WebMethod(action="CadastrarItem2", operationName = "CadastrarItem2")
	// param action caso o parameterStyle seja ParameterStyle.BARE
	// o response nao passa o nome do método
	// @ResponseWrapper(localName="item") usa apenas quando retorna uma lista
	@WebResult(name = "item")
	public Item cadastrarItem2(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token,
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		System.out.println("Call method cadastrarItem(Item)" + item);

		boolean valido = new TokenDao().ehValido(token);
		if (!valido) {
			throw new AutorizacaoException("Autorização falhou. Token Inválido");
		}

		dao.cadastrar(item);
		return item;
	}
}