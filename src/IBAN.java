import java.math.BigInteger;

/**
 * classe che implementa la verifica della correttezza di un IBAN
 * @author Ida Chantal Vivacqua
 * @version 1
 */

public class IBAN {
    
    private String iban;

    /**
     * costruttore dell'oggetto iban vuoto
     */
    public IBAN(){

    }

    /**
     * construttore dell'oggeto iban con parametri
     * @param i stringa che rappresenta l'IBAN
     */

    public IBAN(String i){
        setIban(i);
    }

    /**
     * 
     * @param iban istanzia l'oggetto IBAN
     */

    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * metodo che fornisce l'IBAN
     * @return la stringa che rappresenta l'IBAN
     */
    public String getIban() {
        return iban;
    }

    /**
     * metodo che verifica l'applicazione dello standard dei codici IBAN
     * @return 1 sel'iban è conforme , 0 senon lo è
     * @throws NullPointerException se la stringa dell'IBAN è vuota
     */
    public boolean verificaIban(){

        // Verifica se l'iban è vuoto
        if (iban == null || iban.equals("")){
            throw new NullPointerException("L'IBAN è vuoto");
        }        
      
        // Verifica che la lunghezza sia corretta
        if (iban.length() != 27){
            return false;
        }

          
        // ------------ 1° STEP
        // Estrae i primi 4 caratteri
        String first4 = iban.substring(0, 4);
        // Estrae i rimanenti caratteri
        String extract = iban.substring(4, 27);
        // Aggiunge i primi 4 caratteri alla fine dell'iban
        iban = extract + first4;
        
        // ------------ 2° STEP
        // Converte le lettere in numeri
        StringBuilder sb = new StringBuilder();
        for (char c : iban.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.getNumericValue(c));
            } else {
                sb.append(c);
            }
        }
        String ibanNum = sb.toString();

        // ------------ 3° STEP
        // Converte da stringa in intero e verifica che modulo 97
        BigInteger ibanInt = new BigInteger(ibanNum);
        BigInteger risultato = ibanInt.mod(new BigInteger("97"));
        
        // Restituisce il risultato
        return risultato.intValue() == 1;
    }
}