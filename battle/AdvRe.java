public class AdvRe extends Character{//9.1 �N���X�̊g��
	static int heroNum,monNum,count;

	public static void main(String[] args) {
		Object[] obj = new Object[3];//9.8 Object�N���X
		Character[] c = new Character[3];//8.2 �I�u�W�F�N�g�^�̔z�� & 9.2 �X�[�p�[�N���X�ƃT�u�N���X�̎g�p�@& 9.6 �I�[�o�[���C�h�ɂ�鑽�l��
		obj = c;
		c[0] = new Fighter("Tarou");//7.2 �I�u�W�F�N�g�^�ϐ��̑�� 
		c[1] = new Mage("Jirou");
		c[2] = new Monster("Mash");
		
		System.out.println("�o�g���X�^�[�g�I");
		System.out.println("�q�[���[��" + c[0].name + "��" + c[1].name + "�̑O�Ƀ����X�^�[��" + c[2].name + "�����ꂽ�B");
		while ( monNum >= 1 && heroNum >= 1 ) {
			status(c[0],c[0], c[1], c[2] );
			cdf(c[0], c[2], c[1]);
			status(c[1], c[0], c[1], c[2] );
			cdma(c[1], c[2], c[0]);
			status(c[2],c[0], c[1], c[2] );
			cdmon(c[2], c[0], c[1]);
			status(c[2],c[0], c[1], c[2] );
			cdmon(c[2], c[1], c[0]);
			if ( ( c[0].hp <= 0 || c[1].hp <= 0 ) && count == 0 ) {
				heroNum--;
				count++;
			} else if ( c[2].hp <= 0 ) {
				monNum--;
			}
		}
		if ( heroNum == 0 ) {
			System.out.println("�q�[���[�����́A�͐s�����c");
			System.out.println("GameOver");
		} else if ( monNum == 0 ) {
			System.out.println("�����X�^�[" + c[2].name + "��|����!");
			System.out.println("�q�[���[�����̏���!");
			System.out.println("Game Clear!!");
		}
	}
		
	public static void cdf(Character f, Character enemy, Character c) {
		if ( f.hp == 0 ) {
			System.out.println(f.name + "�͎���ł���B");
			return;
		} else {
			System.out.println(f.name + "�̃^�[��\n");
			int cd = cmdslc();
			if ( cd == 1 ) { f.attack(f, enemy); }//7.3 �l�n���ƎQ�Ɠn���@& 9.3 �X�[�p�[�N���X�ƃT�u�N���X�̊֌W
			else if ( cd == 2 ) { f.tokugi(f, enemy); }
			else if ( cd == 3 ) { f.sleep(f); }
			else if ( cd == 4 ) { f.run(); }
			if ( enemy.hp <= 0 ) {
				enemy.hp = 0;
				System.out.println(enemy.name +"�͗͐s�����B");
			}
			if ( f.mp <= 0 ) { f.mp = 0; }
		}
	}
	
	public static void cdma(Character m, Character enemy, Character c) {
		if ( enemy.hp == 0 ) {
			return;
		} else {
			if ( m.hp == 0 ) {
				System.out.println(m.name + "�͎���ł���B");
				return;
			}
			System.out.println(m.name + "�̃^�[��\n");
			int cd = cmdslc();
			if ( cd == 1 ) { m.attack(m, enemy); }
			else if ( cd == 2 ) { m.tokugi(m, enemy);}
			else if ( cd == 3 ) { m.sleep(m); }
			else if ( cd == 4 ) { m.run(); }
			if ( enemy.hp <= 0 ) {
				enemy.hp = 0;
				System.out.println(enemy.name +"�͗͐s�����B");
			}
			if ( m.mp <= 0 ) { m.mp = 0; }
		}
	}
	
	public  static void cdmon(Character enemy, Character c, Character c2) {
		if ( c.hp == 0 ) {
			System.out.println(c.name + "�͎���ł���B");
		} else {
			System.out.println(enemy.name + "��" + c.name + "�ւ̃^�[��");
			int cd = cmdslc();
			if ( cd == 1 ) { enemy.attack(enemy, c); }
			else if ( cd == 2 ) { enemy.tokugi(enemy, c); }
			else if ( cd == 3 ) { enemy.sleep(enemy); }
			else if ( cd == 4 ) { enemy.run(); }
			if ( c.hp <= 0 ) {
				c.hp = 0;
				System.out.println(c.name +"�͗͐s�����B");
			}
			if ( enemy.mp <= 0 ) { enemy.mp = 0; }
		}
	}
	
	public static int cmdslc() {
		System.out.println("�ǂ�����H\n");
		System.out.println(" 1:��������\n 2:�Ƃ���\n 3:�˂ނ�\n 4:�ɂ���");
		int cd = new java.util.Scanner(System.in).nextInt();
		return cd;
	}
	
	public static void status(Character h, Character a, Character b, Character c) {
		if ( h.hp > 0 ) {
			System.out.println(a.name + "�́A�̗́F" + a.hp + "�A���́F" + a.mp);
			System.out.println(b.name + "�́A�̗́F" + b.hp + "�A���́F" + b.mp);
			System.out.println(c.name + "�́A�̗́F" + c.hp + "�A���́F" + c.mp + "\n");
		}
	}
}