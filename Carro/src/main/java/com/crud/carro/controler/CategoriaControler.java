package com.crud.carro.controler;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crud.carro.model.Categoria;
import com.crud.carro.repository.ICategoriaRepository;


@Controller
public class CategoriaControler {

	@Autowired
	private ICategoriaRepository gRep;
	
	@RequestMapping(name="categoria", value = "/categoria", method = RequestMethod.GET)
	public ModelAndView categoriaGet(ModelMap model) {
		return new ModelAndView("categoria");
	}
	
	@RequestMapping(name="categoria", value = "/categoria", method = RequestMethod.POST)
	public ModelAndView categoriaPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		
		String codigoCategoria = params.get("codigoCategoria");
		String valorDiaria = params.get("valorDiaria");
		String botao = params.get("botao");

		Categoria categoria = new Categoria();
		if (!botao.equals("Listar")) {
			categoria.setCodigoCategoria(Integer.parseInt(codigoCategoria));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			categoria.setValorDiaria(Double.parseDouble(valorDiaria));
		}
		
		String saida = "";
		String erro = "";
		List<Categoria> categorias = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				gRep.save(categoria);
				saida = "Categoria inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				gRep.save(categoria);
				saida = "Categoria atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				gRep.delete(categoria);
				saida = "Categoria excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				categoria = gRep.findById(categoria.getCodigoCategoria()).get();
			}
			if (botao.equals("Listar")) {
				categorias = gRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("categoria", categoria);
			model.addAttribute("categorias", categorias);
		}
		return new ModelAndView("categoria");
	}
}
