package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//especificacao JAX-B para binding de elementos xml para classe java
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
// por padrao o jax-b nao segue os atributos, 
// ele le o get e set, por isso a necessidade de marcar o FIELD 
public class ListaItens {

	@XmlElement(name="item") //descricao de cada item do resultado
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	//por causa do JAX-B, precisa de um construtor sem argumento
	ListaItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
