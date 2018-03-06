/*
* Criação : 14 de fev de 2018
*/
package br.com.stone.autorizador.webservice.ejb;

import javax.ejb.Local;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesResposta;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesSolicitacao;

/**
 * Interface local para servico e consulta de transacoes
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface ConsultaTransacoesServiceLocal
{

   ConsultaTransacoesResposta execute(ConsultaTransacoesSolicitacao consulta);

}
