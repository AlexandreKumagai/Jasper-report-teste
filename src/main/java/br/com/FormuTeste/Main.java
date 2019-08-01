package br.com.FormuTeste;

import br.com.FormuTeste.Pessoa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

public class Main {

	public static void main(String[] args) throws JRException, IOException {
		
		
		//Compila e grava o arquivo
		JasperReport teste =  JasperCompileManager.compileReport("Formulario_basico.jrxml");
		Pessoa pessoa = new Pessoa();
		List lista = new ArrayList<Pessoa>();
		lista.add(pessoa);
		JRBeanCollectionDataSource x = new JRBeanCollectionDataSource(lista);
		Map<String,Object> parametros = new HashMap<String,Object>(); 
		JasperPrint print = JasperFillManager.fillReport(teste, parametros,x);
		//JasperViewer.viewReport(print, true);
		JRPdfExporter arquivo = new JRPdfExporter();
		arquivo.setParameter(JRExporterParameter.JASPER_PRINT, print);
		arquivo.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("fomulario_basico.pdf"));
		arquivo.exportReport();
	}

}
