/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.exception;

/**
 * Excepcao para tamanho de senha invalido
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class PasswordLengthException extends Exception
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = 4293168986812617405L;

   public PasswordLengthException()
   {
      super();
   }

   public PasswordLengthException(String message)
   {
      super(message);
   }

}
