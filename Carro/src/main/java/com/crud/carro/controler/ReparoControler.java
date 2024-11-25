package com.crud.carro.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crud.carro.model.Reparo;
import com.crud.carro.model.Carro;
import com.crud.carro.repository.ICarroRepository;
import com.crud.carro.repository.IReparoRepository;


@Controller
public class ReparoControler {

	@Autowired
	private IReparoRepository rRep;
	@Autowired
	private ICarroRepository cRep;
	
	@RequestMapping(name="reparo", value = "/reparo", method = RequestMethod.GET)
	public ModelAndView reparoGet(ModelMap model) {
		return new ModelAndView("reparo");
	}
	
	@RequestMapping(name="reparo", value = "/reparo", method = RequestMethod.POST)
	public ModelAndView reparoPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		
		String codigoReparo = params.get("codigoReparo");
		String diaEntrada = params.get("diaEntrada");
		String qtdDiasReparo = params.get("qtdDiasReparo");
		String descricao = params.get("descricao");
		String valorReparo = params.get("valorReparo");
		String carroPlaca = params.get("carroPlaca");

		String botao = params.get("botao");

		Reparo reparo = new Reparo();
		if (!botao.equals("Listar")) {
			reparo.setCodigoReparo(Integer.parseInt(codigoReparo));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			reparo.setDiaEntrada(LocalDate.parse(diaEntrada));
			reparo.setQtdDiasReparo(Integer.parseInt(qtdDiasReparo));
			reparo.setDescricao(descricao);
			reparo.setValorReparo(Double.parseDouble(valorReparo));
			Carro carro = new Carro();
			carro = cRep.findById(carroPlaca).get();
			reparo.setCarro(carro);

		}
		
		String saida = "";
		String erro = "";
		List<Reparo> reparos = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				rRep.save(reparo);
				saida = "Reparo inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				rRep.save(reparo);
				saida = "Reparo atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				rRep.delete(reparo);
				saida = "Reparo excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				reparo = rRep.findById(reparo.getCodigoReparo()).get();
			}
			if (botao.equals("Listar")) {
				reparos = rRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("reparo", reparo);
			model.addAttribute("reparos", reparos);
		}
		return new ModelAndView("reparo");
	}
}
