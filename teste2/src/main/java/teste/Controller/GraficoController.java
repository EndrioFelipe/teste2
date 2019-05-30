package teste.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import teste.daos.BancoDAO;
import teste.models.Beneficiarios;

@Controller
@RequestMapping("/grafico")
public class GraficoController {
	
	@Autowired
    private BancoDAO bancoDAO;
	
	
	@RequestMapping("/grafico")
    public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("grafico/grafico");
        //modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(String escolha, String elemento, String executada, String listaColuna, String item){
		
		
		System.out.println("item sfsdfsdf"+item);
		System.out.println("escolha sfsdfsdf"+escolha);
		System.out.println("lista col sfsdfsdf"+listaColuna);
		System.out.println("elemento sfsdfsdf"+elemento);
		System.out.println("executada sfsdfsdf"+executada);
		String teste = "teste";
//		bancoDAO.gravar(banco);
        return listar(escolha, elemento, executada, listaColuna, item);
        
	}
	
	@RequestMapping("/teste")
    public @ResponseBody List<Object> gato(String name) {
	  System.out.println(name);
	    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	    List<Object> item = bancoDAO.listar(name);
	
	    return item;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(String escolha, String elemento, String executada, String listaColuna, String item){
		
		List<Object> ano = bancoDAO.listar("Ano_Proposta");
		List<Object> dado = bancoDAO.listar("Codigo_UOR_Cadastradora");
		List<Object> exec = bancoDAO.listar("Unidade_Executada");
		List<Beneficiarios> colunas;
		try {
			colunas = bancoDAO.listarTudo(escolha, elemento, executada, listaColuna, item);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			colunas = bancoDAO.listarTudoD(listaColuna, item);
		}
		
		List<String> lista = new ArrayList<String>();
		lista.add("ID");
		lista.add("Ano_Proposta");
		lista.add("Codigo_UOR_Cadastradora");
		lista.add("Unidade_Executada");
		lista.add("Elemento_Despesa");
		lista.add("Numero_Processo");
		lista.add("Acao_Originaria");
		lista.add("Tipo_Causa");
		lista.add("Cod_Tua");
		lista.add("Vara");
		lista.add("Codigo_Beneficiario");
		lista.add("Nome_Beneficiario");
		lista.add("Data_Autuacao");
		lista.add("Valor_Pago");
		lista.add("Data_Pagamento");
		lista.add("Codigo_Banco");
		lista.add("Codigo_Agencia");
		lista.add("Numero_Conta");
		lista.add("UO_Lotacao");
		lista.add("Condicao_Servidor");
		lista.add("Valor_PSS_Retido");

				
	    ModelAndView modelAndView = new ModelAndView("/grafico/lista");
	    modelAndView.addObject("anos", ano);
	    modelAndView.addObject("dados", dado);
	    modelAndView.addObject("execs", exec);
	    modelAndView.addObject("colunas", colunas);
	    modelAndView.addObject("lista", lista);
	    return modelAndView;
	}
	
}
