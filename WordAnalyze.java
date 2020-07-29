import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;

public class WordAnalyze {
	public static void main(String[] args) {
		JFrame inf = new JFrame();
		JFrame outf = new JFrame();
        String w;
        String[] ans = new String[2];
		w = JOptionPane.showInputDialog(inf, "奇数番目の文字と偶数番目の文字に分別します\nまた、乱数で出た数までの文字列を表示します\n文字を入力してください.");
		ans = getw(w);
		Random r = new Random();
		int rdm = r.nextInt(w.length());
		String c = Integer.toString(w.length());
		JOptionPane.showMessageDialog(outf, "あなたが入力したのは, \n" + w + "\n文字数は," + c);
		JOptionPane.showMessageDialog(outf, "奇数番目の文字は, \n" + ans[0] + "\n偶数番目の文字は,\n" + ans[1]);
		JOptionPane.showMessageDialog(outf, "乱数で," + rdm + "が出たので" + rdm + "番目までの文字列は,\n" + w.substring(0,rdm));
	}
	
	public static String[] getw(String str) {
		String[] w = new String[2];
		w[0] = "" + str.charAt(0);
		w[1] = "" + str.charAt(1);
		for ( int i=2 ; i<str.length() ; i+=2 ) {
			w[0] += "," + str.charAt(i);
		}
		for ( int i=3 ; i<str.length() ; i+=2 ) {
			w[1] += "," + str.charAt(i);
		}
		return w;
	}
}
