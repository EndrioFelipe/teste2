package teste.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import teste.models.Beneficiarios;

@Repository
@Transactional
public class BancoDAO {
	
	@PersistenceContext
    private EntityManager manager;

    public void gravar(Beneficiarios banco){
        manager.persist(banco);
    }
    
    public List<Object> listar(String a){
    	//"select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
		String hql = "select distinct (b."+a+") from Beneficiarios b";
    	TypedQuery<Object> query = manager.createQuery(hql, Object.class);
    	//System.out.println(query.getClass());
    	return query.getResultList();
        
    }
    
    public List<Beneficiarios> listarTudoD(String listaColuna, String item) {
    	return null;
    }

	public List<Beneficiarios> listarTudo(String escolha, String elemento, String executada, String listaColuna, String item) {
		
		
		System.out.println("escolha "+escolha);
		System.out.println("elemento "+elemento);
		System.out.println("executada "+executada);
		System.out.println("listaColulna "+listaColuna);
		System.out.println("item "+item);
		
		escolha = escolha.equals("") ? "Ano_Proposta": "'"+escolha+"'";
		elemento = elemento.equals("") ? "Codigo_UOR_Cadastradora": "'"+elemento+"'";
		executada = executada.equals("") ? "Unidade_Executada": "'"+executada+"'";
		
		if(listaColuna.equals("")) {
			System.out.println("aqui");
			return manager.createQuery("select b from Beneficiarios b where b.Ano_Proposta = "+escolha+" and b.Codigo_UOR_Cadastradora = "+elemento+" and b.Unidade_Executada = "+executada, Beneficiarios.class).getResultList();
		} else {
			item = executada.equals("") ? listaColuna : "'"+item+"'";
		}
		
		
		
		System.out.println("escolha "+escolha);
		System.out.println("elemento "+elemento);
		System.out.println("executada "+executada);
		System.out.println("listaColulna "+listaColuna);
		System.out.println("item "+item);
		
		/*
		 * if (item.equals("")) { System.out.println("equals "+listaColuna);
		 * System.out.println("equals "+item); item = listaColuna; //return
		 * manager.createQuery("select b from Beneficiarios b where b."
		 * +listaColuna+" = '"+item+"'", Beneficiarios.class).getResultList(); return
		 * manager.createQuery("select b from Beneficiarios b where b."
		 * +listaColuna+" = "+item, Beneficiarios.class).getResultList(); } else { item
		 * = "'"+item+"'"; System.out.println(listaColuna); System.out.println(item);
		 * System.out.println("a porra"); return
		 * manager.createQuery("select b from Beneficiarios b where b."
		 * +listaColuna+" = "+item, Beneficiarios.class).getResultList();
		 * 
		 * }
		 */
		
		return manager.createQuery("select b from Beneficiarios b where b.Ano_Proposta = "+escolha+" and b.Codigo_UOR_Cadastradora = "+elemento+" and b.Unidade_Executada = "+executada+" and b."+listaColuna+" = "+item, Beneficiarios.class).getResultList();
		
		//return null;
		//DOMINGAS DE SOUSA RODRIGUES
		//return manager.createQuery("select b from Beneficiarios b where b.Nome_Beneficiario = DOMINGAS DE SOUSA RODRIGUES", Beneficiarios.class).getResultList();

	}
    		
}
