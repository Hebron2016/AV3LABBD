package com.crud.carro.controler;
import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.http.HttpHeaders;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReparoControlerRelatorio {

	@Autowired
	private DataSource ds;
	
	@SuppressWarnings({"rawtypes","unchecked"})
	@RequestMapping(name="projetorelatorio", value = "/projetorelatorio", method = RequestMethod.POST)
	public ResponseEntity geraRelatorio(@RequestParam Map<String, String> params) {
		String erro = "";
		String diaReparo  = params.get("diaReparo");
		
		//Inicializar Elementos
		Map<String, Object> relatorioParams = new HashMap<String, Object>();
		relatorioParams.put("diaReparo", diaReparo);
		
		byte[] bytes = null;
		
		//Inicializar elementos para o Browser
		InputStreamResource resource = null;
		HttpStatus status = null;
		HttpHeaders header = new HttpHeaders();
		
		//Trabalhar com o jasper
		Connection conn = DataSourceUtils.getConnection(ds);
		try{
			File arquivo = ResourceUtils.getFile("classpath:reports/Reparos.jasper");
			JasperReport report = (JasperReport) JRLoader.LoadObjectFromFile(arquivo.getAbsolutePath());
			bytes = JasperRunManager.runReportToPdf(report, relatorioParams, conn);
			
		} catch (Exception e) {
			erro = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}finally {
			if(erro.equals("")) {
				ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
				resource = new InputStreamResource(stream);
				header.setContentLength(bytes.length);
				header.setContentType(MediaType.APPLICATION_PDF);
				status = HttpStatus.OK;
			}
		}
		return new ReponseEntity(resource, header, status);
	}
}
