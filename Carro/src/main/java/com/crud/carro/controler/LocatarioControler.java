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

import com.crud.carro.model.Locatario;
import com.crud.carro.repository.ILocatarioRepository;


@Controller
public class LocatarioControler {

	@Autowired
	private ILocatarioRepository lRep;
	
	@RequestMapping(name="locatario", value = "/locatario", method = RequestMethod.GET)
	public ModelAndView locatarioGet(ModelMap model) {
		return new ModelAndView("locatario");
	}
	
	@RequestMapping(name="locatario", value = "/locatario", method = RequestMethod.POST)
	public ModelAndView locatarioPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		
		String cpf = params.get("cpf");
		String nome = params.get("nome");
		String numHabilitacao = params.get("numHabilitacao");
		String dataNasc = params.get("dataNasc");
		String endLogradouro = params.get("endLogradouro");
		String endNum = params.get("endNum");
		String endCep = params.get("endCep");
		String endCidade = params.get("endCidade");

		String botao = params.get("botao");

		Locatario locatario = new Locatario();
		if (!botao.equals("Listar")) {
			locatario.setCpf(cpf);
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			locatario.setNome(nome);
			locatario.setNumHabilitacao(numHabilitacao);
			locatario.setDataNasc(LocalDate.parse(dataNasc));
			locatario.setEndLogradouro(endLogradouro);
			locatario.setEndNum(Integer.parseInt(endNum));
			locatario.setEndCep(endCep);
			locatario.setEndCidade(endCidade);
		}
		
		String saida = "";
		String erro = "";
		List<Locatario> locatarios = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				lRep.save(locatario);
				saida = "Locatario inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				lRep.save(locatario);
				saida = "Locatario atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				lRep.delete(locatario);
				saida = "Locatario excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				locatario = lRep.findById(locatario.getCpf()).get();
			}
			if (botao.equals("Listar")) {
				locatarios = lRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("locatario", locatario);
			model.addAttribute("locatarios", locatarios);
		}
		return new ModelAndView("locatario");
	}
}
