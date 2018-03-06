/*
* Criação : 18 de fev de 2018
*/

package br.com.stone.autorizador.exception;

/**
 * Excecao para valor invalido da transacao
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class TransactionInvalidAmountException extends Exception
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = -1233056951352121732L;

   public TransactionInvalidAmountException()
   {
      super();
   }

   public TransactionInvalidAmountException(String message)
   {
      super(message);
   }

}
