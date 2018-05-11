import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Karen 10 de mai de 2018
 */
public class Validador {

	static Pattern simpleLang = Pattern.compile("\\s*-?([a-z]|\\d)+(\\s*[-+*%/]\\s*-?([a-z]|\\d)+)*\\s*");
	static Pattern innerParen = Pattern.compile("[(]([^()]*)[)]");

	public static boolean validateExpr(String expr) {
		while (expr.contains(")") || expr.contains("(")) {
			Matcher m = innerParen.matcher(expr);
			if (m.find()) {
				if (!simpleLang.matcher(m.group(1)).matches()) {
					return false;
				}
				expr = expr.substring(0, m.start()) + " a " + expr.substring(m.end());
			} else {
				// we have parens but not an innermost paren-free region
				// This implies mismatched parens
				return false;
			}
		}
		return simpleLang.matcher(expr).matches();
	}

}
