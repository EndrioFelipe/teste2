<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>

</head>
	<body class="container">
		
		<table class="table">
			<form action="/teste2/grafico" method="post">
			    <td>    
			        <select id="hh" name="escolha">
						<option value="" >qualquer</option>
						<c:forEach items="${anos}" var="ano">
							<option value="${ano}" >${ano}</option>
						</c:forEach>	
					</select>
				</td>	
					
				<td>
					<select name="elemento">
						<option value="" >qualquer</option>
						<c:forEach items="${dados}" var="dado">
							<option value="${dado}" >${dado}</option>
						</c:forEach>	
					</select>
				</td>
					
				<td>	
					<select name="executada">
						<option value="" >qualquer</option>
						<c:forEach items="${execs}" var="exec">
							<option value="${exec}" >${exec}</option>
						</c:forEach>	
					</select> 
				</td>
					
				<td>
					<select  name="listaColuna" onClick="gato(this)"  >
						<option value="">	qualquer</option>
						<c:forEach items="${lista}" var="lista">
							<option value="${lista}">${lista}</option>
						</c:forEach>	
					</select>
				</td>
				<td>
					<select id="sel" name="item">
						<option value="">qualquer</option>
					</select>
				</td>	
								
				<td>	
					<button type="submit">Pesquisar</button>
				</td>
		        </form>
	        </tr>		
		</table>
		<p>
			<input class="ap" type="checkbox"  value="ano_Proposta">Ano Proposta<br>
			<input class="dp" type="checkbox"  value="data_pagamento">Data do Pagamento<br>
			<input class="cuor" type="checkbox"  value="codigo_UOR">Codigo UOR<br>
			<input class="ue" type="checkbox"  value="unidade_Executada">Unidade Executada<br>
			
			<button id="esconde" type="button" >Esconde</button>
		</p>
	
		<table class="table">
		<tr>		
		
		
	        <tr>
	            <td class="ano_proposta" >Ano Proposta</td>
	            <td class="data_pagamento" >Data do Pagamento</td>
	            <td class="uor" >Codigo UOR</td>
	            <td class="unidade_executada" >Unidade Executada</td>
	            <td>Nome do Beneficiário</td>
	            <td>Valor</td>
	        </tr>
	        
	        
	
	         <c:forEach items="${colunas}" var="coluna">
				<tr>
					<td class="ano_proposta" >${coluna.ano_Proposta}</td>
					
					<td class="data_pagamento" >
						<fmt:formatDate pattern="dd/MM/yyyy" value="${coluna.data_Pagamento}" />
					</td>
					
					<td class="uor" >${coluna.codigo_UOR_Cadastradora}</td>
					
					<td class="unidade_executada" >${coluna.unidade_Executada}</td>
					
					<td class="nome" >${coluna.nome_Beneficiario}</td>
				
					<td class="pps" >${coluna.valor_PSS_Retido}</td>
				</tr>
			</c:forEach> 	
	        
	      
	
	    </table>
	    
	    
	  
	    
	    
	    <script>
	
	    	let checa = document.querySelector("#check");
	    	
	    	var esconde = document.querySelector("#esconde");
	
	    	esconde.addEventListener("click", function(event){
	    		event.preventDefault();
	    		var ap = null;
	    		
	    		if(document.querySelector('.ap:checked')){
	    			$('.ano_proposta').hide();
	    		} else {
	    			`lksdbiudgbsaiufhas`;
	    		}
	    		
	    		var dp = document.querySelector('.dp:checked') ? $('.data_pagamento').hide() : ``;
	    		var cuor = document.querySelector('.cuor:checked') ? $('.uor').hide() : ``;
	    		var ue = document.querySelector('.ue:checked') ? $('.unidade_executada').hide() : ``;
				

					    		
	    		
	    	});
	    
	   		
	    	
	    	let seleciona = document.querySelector("#sel");
	   		
	   		//let pega = document.querySelectorAll(".aparecer");
	
					
			
	   
		    function gato(a) {
		   	var b = a.options[a.selectedIndex].text;
				$.post("grafico/teste",	{	
						name: b }   
					      ,	function(response) {
					
					seleciona.innerHTML = '';
					let e ="";
					let att="";
					
					let opcao = document.createElement("option");
					opcao.textContent = 'qualquer';
					
					for(var i=-1; i<response.length; i++){
						e = document.createElement("option");
						att = document.createAttribute("value");
						att.value = response[i];
						e.setAttributeNode(att);
						e.textContent = response[i];
						seleciona.appendChild(i == -1 ? opcao : e);
			
					}
					
					console.log("aqui");
					
			
			
					//response.map(item => seleciona.appendChild(e));
				});
			} 
	
	    
	    
		</script>
	</body>
</html>