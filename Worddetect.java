import javax.swing.JFrame;//5.1 �N���X���C�u�����Ƃ�
import javax.swing.JOptionPane;
import java.util.Random;

public class Worddetect {
	public static void main(String[] args) {
		JFrame inf = new JFrame();
		JFrame outf = new JFrame();
        String w;
        String[] ans = new String[2];
		w = JOptionPane.showInputDialog(inf, "��Ԗڂ̕����Ƌ����Ԗڂ̕����ɕ��ʂ��܂�\n�܂��A�����ŏo�����܂ł̕������\�����܂�\n��������͂��Ă�������.");
		ans = getw(w);
		Random r = new Random();//6.1 �v�Z�◐���쐬�Ɋւ���N���X
		int rdm = r.nextInt(w.length());//7.3 �l�n���ƎQ�Ɠn��
		String c = Integer.toString(w.length());//6.2 ���b�p�[�N���X
		JOptionPane.showMessageDialog(outf, "���Ȃ������͂����̂�, \n" + w + "\n��������," + c);
		JOptionPane.showMessageDialog(outf, "��Ԗڂ̕�����, \n" + ans[0] + "\n�����Ԗڂ̕�����,\n" + ans[1]);
		JOptionPane.showMessageDialog(outf, "������," + rdm + "���o���̂�" + rdm + "�Ԗڂ܂ł̕������,\n" + w.substring(0,rdm));
	}
	
	public static String[] getw(String str) {
		String[] w = new String[2];//8.1 ��{�^�̔z��
		w[0] = "" + str.charAt(0);//5.2 ���������舵���FString�N���X
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