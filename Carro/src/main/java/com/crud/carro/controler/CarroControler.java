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

import com.crud.carro.model.Carro;
import com.crud.carro.model.Categoria;
import com.crud.carro.repository.ICarroRepository;
import com.crud.carro.repository.ICategoriaRepository;



@Controller
public class CarroControler {

	@Autowired
	private ICarroRepository cRep;
	
	@Autowired
	private ICategoriaRepository catRep;
	
	@RequestMapping(name="carro", value = "/carro", method = RequestMethod.GET)
	public ModelAndView carroGet(ModelMap model) {
		return new ModelAndView("carro");
	}
	
	@RequestMapping(name="carro", value = "/carro", method = RequestMethod.POST)
	public ModelAndView carroPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		
		String placa = params.get("placa");
		String marca = params.get("marca");
		String modelo = params.get("modelo");
		String cor = params.get("cor");
		String ano = params.get("ano");
		String tipoCombustivel = params.get("tipoCombustivel");
		String kmRodado = params.get("kmRodado");
		String tipoCambio = params.get("tipoCambio");
		String categoria = params.get("categoria");
		String botao = params.get("botao");

		Carro carro = new Carro();
		if (!botao.equals("Listar")) {
			carro.setPlaca(placa);
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			carro.setMarca(marca);
			carro.setModelo(modelo);
			carro.setCor(cor);
			carro.setAno(Integer.parseInt(ano));
			carro.setTipoCombustivel(tipoCombustivel);
			carro.setKmRodado(Integer.parseInt(kmRodado));
			carro.setTipoCambio(tipoCambio);
			Categoria cat = new Categoria();
			cat = catRep.findById(Integer.parseInt(categoria)).get();
			carro.setCategoria(cat);
		}
		
		String saida = "";
		String erro = "";
		List<Carro> carros = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				cRep.save(carro);
				saida = "Carro inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				cRep.save(carro);
				saida = "Carro atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				cRep.delete(carro);
				saida = "Carro excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				carro = cRep.findById(carro.getPlaca()).get();
			}
			if (botao.equals("Listar")) {
				carros = cRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("carro", carro);
			model.addAttribute("carros", carros);
		}
		return new ModelAndView("carro");
	}
}
