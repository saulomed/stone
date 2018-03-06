/*
* Criação : 18 de fev de 2018
*/

package br.com.stone.autorizador.webservice.enums;

/**
 * Enumerador para codigos de resposta
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public enum ResponseCode
{
      /** Transacao aprovada */
      APROVADO,
      /** Transacao negada */
      TRANSACAO_NEGADA,
      /** Saldo insuficiente */
      SALDO_INSIFICIENTE,
      /** Valido invalido */
      VALOR_INVALIDO,
      /** Cartao bloqueado */
      CARTAO_BLOQUEADO,
      /** Senha deve ter entre 4 e 6 digitos */
      TAMANHO_SENHA,
      /** Senha invalida */
      SENHA_INVALIDA,
      /** Cartao invalido */
      CARTAO_INVALIDO;

   public static ResponseCode get(Integer value)
   {
      ResponseCode result = ResponseCode.values()[value];
      return result;
   }

}
