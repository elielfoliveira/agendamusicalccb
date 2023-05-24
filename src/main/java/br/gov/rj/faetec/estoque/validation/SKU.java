package br.gov.rj.faetec.estoque.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE }) // onde deverá ser aplicada
@Retention(RetentionPolicy.RUNTIME) // Será aplicada em tempo de execução
@Constraint(validatedBy = {}) // Notação referente a validação
@Pattern(regexp = "([a-zA-Z]{2}\\d{4})?") // O ? faz com que a expressão regular somente funcione se for informado algum valor
public @interface SKU {

	@OverridesAttribute(constraint = Pattern.class, name = "message") // É indicado para sobrescreve a mensagem padrão
	String message() default "SKU deve seguir o padrão XX9999";
	
	Class<?>[] groups() default {}; // Permite agrupar validações 
	Class<? extends Payload>[] payload() default {}; // Permite carregar mais informações desta anotação
	
}
