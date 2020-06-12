import java.util.ArrayList;
import java.util.Arrays;
public class LeftRecElim {
	public static ArrayList<Character> getVars(String s) {
		ArrayList<String> rules = new ArrayList<>(Arrays.asList(s.split(";")));
		ArrayList<Character> vars = new ArrayList<Character>();
		for (int i = 0; i < rules.size(); i++) {
			String tmp1 = rules.get(i);
			vars.add(tmp1.charAt(0));
		}
		return vars;
	}
	public static String LRE(String s) {
		ArrayList<Character> vars = getVars(s);
		ArrayList<String> rules = new ArrayList<>(Arrays.asList(s.split(";")));
		for (int i = 0; i < vars.size(); i++) {
			for (int j = 0; j < i; j++) {
				ArrayList<String> rule = new ArrayList<String>();
				String current = "";
				int mohem = -1;
				for (int x = 0; x < rules.size(); x++) {
					String tmp1 = rules.get(x);
					if (tmp1.charAt(0) == vars.get(i)) {
						ArrayList<String> tmp2 = new ArrayList<>(
								Arrays.asList(tmp1.split(",")));
						rule = tmp2;
						current = tmp1;
						mohem = x;
					}

				}
				Character v = '5';
				for (int x = 1; x < rule.size(); x++) {
					if (vars.contains(rule.get(x).charAt(0))) {
						if (vars.indexOf(rule.get(x).charAt(0)) < vars
								.indexOf(rule.get(0).charAt(0))) {
							v = rule.get(x).charAt(0);
							ArrayList<String> ruleSub = new ArrayList<String>();
							for (int y = 0; y < rules.size(); y++) {
								String tmp1 = rules.get(y);
								if (rule.get(x).charAt(0) == rules.get(y)
										.charAt(0)) {
									ArrayList<String> tmp2 = new ArrayList<>(
											Arrays.asList(tmp1.split(",")));
									ruleSub = tmp2;
									break;
								}
							}
							ruleSub.remove(0);
							String copy = current;
							ArrayList<String> test = new ArrayList<String>();
							for (int m = 0; m < ruleSub.size(); m++) {
								copy = current.replace("," + v,
										"," + ruleSub.get(m));
								if (m == 0) {
									ArrayList<String> u = new ArrayList<>(
											Arrays.asList(copy.split(",")));
									test.addAll(u);
								} else {
									ArrayList<String> u = new ArrayList<>(
											Arrays.asList(copy.substring(2,
													copy.length()).split(",")));
									test.addAll(u);
								}
							}
							ArrayList<String> finall = new ArrayList<String>();
							for (int t = 0; t < test.size(); t++) {
								if (!finall.contains(test.get(t))) {

									finall.add(test.get(t).replaceFirst("^ *",
											""));
								}
							}
							copy = finall.toString().substring(1,
									finall.toString().length() - 1);
							rules.set(mohem, copy.replaceAll("\\s", ""));
						}
					}
				}
			}
			ArrayList<String> rule = new ArrayList<String>();
			int mohem = -1;
			for (int x = 0; x < rules.size(); x++) {
				String tmp1 = rules.get(x);
				if (tmp1.charAt(0) == vars.get(i)) {
					ArrayList<String> tmp2 = new ArrayList<>(Arrays.asList(tmp1
							.split(",")));
					rule = tmp2;
					mohem = x;
				}
			}
			boolean rec = false;
			for (int w = 1; w < rule.size(); w++) {
				if (rule.get(w).charAt(0) == rule.get(0).charAt(0)) {
					rec = true;
				}
			}
			if (rec) {
				ArrayList<String> alpha = new ArrayList<String>();
				ArrayList<String> beta = new ArrayList<String>();
				for (int a = 1; a < rule.size(); a++) {
					if (rule.get(a).charAt(0) == rule.get(0).charAt(0)) {
						alpha.add(rule.get(a)
								.substring(1, rule.get(a).length()));
					} else {
						beta.add(rule.get(a));
					}
				}
				String inshalla = rule.get(0).charAt(0) + "";
				for (int k = 0; k < beta.size(); k++) {
					inshalla += "," + beta.get(k) + rule.get(0).charAt(0) + "'";
				}
				rules.set(mohem, inshalla);
				String yarab = rule.get(0).charAt(0) + "'";
				for (int k = 0; k < alpha.size(); k++) {
					yarab += "," + alpha.get(k) + rule.get(0).charAt(0) + "'";
				}
				yarab += ",epsilon";
				rules.add(yarab);
			}
			for (int e = 0; e < rules.size(); e++) {
				String temp = rules.get(e).replace("epsilon", " ");
				rules.set(e, temp);
			}
		}
		String out = "";
		for (int e = 0; e < rules.size(); e++) {
			out += rules.get(e) + ";";
		}
		return out;
	}

	public static void main(String[] args) {
		String input = "S,ScT,T;T,aSb,iaLb,i;L,SdL,S";
		String output = LRE(input);
		System.out.print(output);
	}
}
