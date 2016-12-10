package pyrite.runtime.type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * pyrite.lang.MultipleValue を返すメソッドについて、型情報を保持するアノテーション
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleValueAnnotation
{
	public final static String	CLASS_NAME = "pyrite.compiler.type.MultipleValueAnnotation";

	Class<?>[] value();
}
