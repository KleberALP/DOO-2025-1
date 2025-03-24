package factory;

import model.Operacao;
import java.util.HashMap;
import java.util.Map;

public class Prototype {

    private static final Map<String, Operacao> prototipos = new HashMap<>();
    private static final String PACOTE_BASE = "model.";

    static {
    }

    public static Operacao getOperacao(String tipo) {

        if (!prototipos.containsKey(tipo)) {
            try {
                Class<?> clazz = Class.forName(PACOTE_BASE + tipo);
                Operacao operacao = (Operacao) clazz.getDeclaredConstructor().newInstance();
                prototipos.put(tipo, operacao);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        Operacao operacao = prototipos.get(tipo);
        return (operacao != null) ? operacao.clone() : null;
    }
}
