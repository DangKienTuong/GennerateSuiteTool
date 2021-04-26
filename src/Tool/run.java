package Tool;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class run {

	public static void main(String[] args) {
		ArrayList<Integer> ls = new ArrayList<>();
		ArrayList<String> lsClass = new ArrayList<>();
		String res = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Has 0? (0:N, 1:Y): ");
		int preCond = Integer.parseInt(sc.next());
		if (preCond == 1) {
			System.out.print("Package: ");
			String pack = sc.next();
			System.out.print("First Test Case: ");
			String rule = sc.next();
			for (int i = 0; i < rule.length(); i++) {
				if (rule.charAt(i) == '0') {
					ls.add(i);
				}
			}
			int first = Integer.parseInt(rule.substring(ls.get(ls.size() - 1) + 1));
			System.out.print("How many test case: ");
			int last = Integer.parseInt(sc.next()) + 1;
			for (int i = first; i < last; i++) {
				if (i < 9) {
					rule = rule.substring(0, ls.get(ls.size() - 1) + 1);
					res = "\t\t\t<class name='" + pack + "." + rule + i + "'/>\n";
				}
				if (i > 9 && i < 100) {
					rule = rule.substring(0, ls.get(ls.size() - 1));
					res = "\t\t\t<class name='" + pack + "." + rule + i + "'/>\n";
				}
				if (i > 99) {
					rule = rule.substring(0, ls.get(ls.size() - 1) - 1);
					res = "\t\t\t<class name='" + pack + "." + rule + i + "'/>\n";
				}
				lsClass.add(res);
			}
			String content = "\n";
			for (String print : lsClass) {
				content += print;
			};
			String copy = "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\" >\r\n"
					+ "<suite name=\"Suite-Collection\" parallel=\"classes\" thread-count=\"2\">\r\n" + "	<test name=\"Suite-1\">\r\n"
					+ "		<classes>"
					+content
					+"		</classes>\r\n" + "	</test>\r\n" + "</suite>";
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(new StringSelection(copy), null);
			System.out.println("Copied to clipboard");
		}

		if (preCond == 0) {
			System.out.print("Package: ");
			String pack = sc.next();
			System.out.print("First Test Case: ");
			String rule = sc.next();
			int first = Integer.parseInt(rule.substring(rule.length() - 1));
			rule = rule.substring(0, rule.length() - 1);
			System.out.print("How many test case: ");
			int last = Integer.parseInt(sc.next()) + 1;
			for (int i = first; i < last; i++) {
				res = "\t\t\t<class name='" + pack + "." + rule + i + "'/>\n";
				lsClass.add(res);
			}
			String content = "\n";
			for (String print : lsClass) {
				content += print;
			};
			String copy = "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\" >\r\n"
					+ "<suite name=\"Suite-Collection\" parallel=\"classes\" thread-count=\"2\">\r\n" + "	<test name=\"Suite-1\">\r\n"
					+ "		<classes>"
					+content
					+"		</classes>\r\n" + "	</test>\r\n" + "</suite>";
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(new StringSelection(copy), null);
			System.out.println("Copied to clipboard");
		}

	}
}
