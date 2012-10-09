package br.com.fiap.util;

import java.lang.reflect.Method;


public class EnumHelper {

	@SuppressWarnings("unchecked")
	public static <E extends Enum<?>> E porCodigo(Class<? extends Enum<?>> enumClass, String propriedade, Object valor) {
		if (valor == null || (valor instanceof String && ((String) valor).trim().isEmpty())) {
			return null;
		}

		try {
			Enum<?>[] values = (Enum[]) enumClass.getMethod("values", new Class[0]).invoke(null, new Object[0]);
			for (Enum<?> enumeration : values) {
				String nomeMetodo = "get" + Character.toUpperCase(propriedade.charAt(0)) + propriedade.substring(1);
				Method method = enumClass.getMethod(nomeMetodo, new Class[] {});
				Object resultado = method.invoke(enumeration, new Object[] {});
				if (resultado != null && resultado.equals(valor)) {
					return (E) enumeration;
				}
			}
			
			throw new IllegalArgumentException("Valor não encontrado para " + enumClass.getSimpleName() + ": " + valor);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
