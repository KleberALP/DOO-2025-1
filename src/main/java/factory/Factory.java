package factory;

import model.Operacao;

public class Factory {

	protected static String pacoteBase = "model.";

	public static Operacao factory(String tipo) {

		Object classeInstanciada = null;

		try {
			classeInstanciada = Class.forName(pacoteBase + tipo).newInstance();

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return (Operacao) classeInstanciada;

	}
}
