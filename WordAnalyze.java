import javax.swing.JFrame;//5.1 クラスライブラリとは
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
		Random r = new Random();//6.1 計算や乱数作成に関するクラス
		int rdm = r.nextInt(w.length());//7.3 値渡しと参照渡し
		String c = Integer.toString(w.length());//6.2 ラッパークラス
		JOptionPane.showMessageDialog(outf, "あなたが入力したのは, \n" + w + "\n文字数は," + c);
		JOptionPane.showMessageDialog(outf, "奇数番目の文字は, \n" + ans[0] + "\n偶数番目の文字は,\n" + ans[1]);
		JOptionPane.showMessageDialog(outf, "乱数で," + rdm + "が出たので" + rdm + "番目までの文字列は,\n" + w.substring(0,rdm));
	}
	
	public static String[] getw(String str) {
		String[] w = new String[2];//8.1 基本型の配列
		w[0] = "" + str.charAt(0);//5.2 文字列を取り扱う：Stringクラス
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
