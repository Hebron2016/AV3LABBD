package com.crud.carro.controler;


import java.time.LocalDate;
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

import com.crud.carro.model.Devolucao;
import com.crud.carro.model.Aluguel;
import com.crud.carro.repository.IDevolucaoRepository;
import com.crud.carro.repository.IAluguelRepository;


@Controller
public class DevolucaoControler {

	@Autowired
	private IDevolucaoRepository dRep;
	
	@Autowired
	private IAluguelRepository aRep;
	
	@RequestMapping(name="devolucao", value = "/devolucao", method = RequestMethod.GET)
	public ModelAndView devolucaoGet(ModelMap model) {
		return new ModelAndView("devolucao");
	}
	
	@RequestMapping(name="devolucao", value = "/devolucao", method = RequestMethod.POST)
	public ModelAndView devolucaoPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		
		String codigoDevolucao = params.get("codigoDevolucao");
		String diaDevolucao = params.get("diaDevolucao");
		String valorTotal = params.get("valorTotal");
		String valorExtra = params.get("valorExtra");
		String codigoAluguel = params.get("codgioAluguel");

		
		String botao = params.get("botao");

		Devolucao devolucao = new Devolucao();
		if (!botao.equals("Listar")) {
			devolucao.setCodigoDevolucao(Integer.parseInt(codigoDevolucao));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			devolucao.setDiaDevolucao(LocalDate.parse(diaDevolucao));
			devolucao.setValorTotal(Double.parseDouble(valorTotal));
			devolucao.setValorExtra(Double.parseDouble(valorExtra));
			Aluguel aluguel = new Aluguel();
			aluguel = aRep.findById(Integer.parseInt(codigoAluguel)).get();
			devolucao.setAluguel(aluguel);
		}
		
		String saida = "";
		String erro = "";
		List<Devolucao> devolucaos = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				dRep.save(devolucao);
				saida = "Devolucao inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				dRep.save(devolucao);
				saida = "Devolucao atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				dRep.delete(devolucao);
				saida = "Devolucao excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				devolucao = dRep.findById(devolucao.getCodigoDevolucao()).get();
			}
			if (botao.equals("Listar")) {
				devolucaos = dRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("devolucao", devolucao);
			model.addAttribute("devolucaos", devolucaos);
		}
		return new ModelAndView("devolucao");
	}
}
