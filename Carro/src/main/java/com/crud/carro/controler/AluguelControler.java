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

import com.crud.carro.model.Aluguel;
import com.crud.carro.model.Carro;
import com.crud.carro.model.Locatario;

import com.crud.carro.repository.IAluguelRepository;
import com.crud.carro.repository.ICarroRepository;
import com.crud.carro.repository.ILocatarioRepository;



@Controller
public class AluguelControler {

	@Autowired
	private IAluguelRepository gRep;
	
	@Autowired
	private ICarroRepository cRep;
	
	@Autowired
	private ILocatarioRepository lRep;
	
	@RequestMapping(name="aluguel", value = "/aluguel", method = RequestMethod.GET)
	public ModelAndView aluguelGet(ModelMap model) {
		return new ModelAndView("aluguel");
	}
	
	@RequestMapping(name="aluguel", value = "/aluguel", method = RequestMethod.POST)
	public ModelAndView aluguelPost(
			@RequestParam Map<String, String> params,
			ModelMap model) {
		
		String codigoAluguel = params.get("codigoAluguel");
		String dataRetirada = params.get("dataRetirada");
		String carroPlaca = params.get("carroPlaca");
		String locatarioCpf = params.get("locatarioCpf");	
		String botao = params.get("botao");

		Aluguel aluguel = new Aluguel();
		if (!botao.equals("Listar")) {
			aluguel.setCodigoAluguel(Integer.parseInt(codigoAluguel));
		}
		if (botao.equals("Inserir") || botao.equals("Atualizar")){
			aluguel.setDataRetirada(LocalDate.parse(dataRetirada));
			Carro carro = new Carro();
			carro = cRep.findById(carroPlaca).get();
			aluguel.setCarroPlaca(carro);
			Locatario locatario = new Locatario();
			locatario = lRep.findById(locatarioCpf).get();
			aluguel.setLocatarioCpf(locatario);
		}
		
		String saida = "";
		String erro = "";
		List<Aluguel> aluguels = new ArrayList<>();
		
		try {
			if (botao.equals("Inserir")) {
				gRep.save(aluguel);
				saida = "Aluguel inserido com sucesso";
			}
			if (botao.equals("Atualizar")) {
				gRep.save(aluguel);
				saida = "Aluguel atualizado com sucesso";
			}
			if (botao.equals("Excluir")) {
				gRep.delete(aluguel);
				saida = "Aluguel excluido com sucesso";
			}
			if (botao.equals("Buscar")) {
				aluguel = gRep.findById(aluguel.getCodigoAluguel()).get();
			}
			if (botao.equals("Listar")) {
				aluguels = gRep.findAll();
			}
		}catch(Exception e) {
			erro = e.getMessage();
		} finally{
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("aluguel", aluguel);
			model.addAttribute("aluguels", aluguels);
		}
		return new ModelAndView("aluguel");
	}
}
