public class Adv extends Character{
	static int heroNum,monNum;

	public static void main(String[] args) {
		Fighter f1 = new Fighter("Tarou");
		Mage mg1 = new Mage("Jirou");
		Monster m1 = new Monster("Mash");
		
		System.out.println("�o�g���X�^�[�g�I");
		System.out.println("�q�[���[��" + f1.name + "��" + mg1.name + "�̑O�Ƀ����X�^�[��" + m1.name + "�����ꂽ�B");
		while ( monNum >= 1 && heroNum >= 1 ) {
			cdf(f1, m1, mg1);
			cdma(mg1, m1, f1);
			cdmon(m1, f1, mg1);
			cdmon(m1, mg1, f1);
			if ( f1.hp <= 0 || mg1.hp <= 0 ) {
				heroNum--;
			} else if ( m1.hp <= 0 ) {
				monNum--;
			}
		}
		if ( heroNum == 0 ) {
			System.out.println("�q�[���[�����́A�͐s�����c");
			System.out.println("GameOver");
		} else if ( monNum == 0 ) {
			System.out.println("�����X�^�[" + m1.name + "��|����!");
			System.out.println("�q�[���[�����̏���!");
			System.out.println("Game Clear!!");
		}
	}
		
	public static void cdf(Fighter f, Monster enemy, Character c) {
		System.out.println(f.name + "�́A�̗́F" + f.hp + "�A���́F" + f.mp);
		System.out.println(c.name + "�́A�̗́F" + c.hp + "�A���́F" + c.mp);
		System.out.println(enemy.name + "�́A�̗́F" + enemy.hp + "�A���́F" + enemy.mp +"\n");
		if ( f.hp == 0 ) {
			System.out.println(f.name + "�͎���ł���B");
			return;
		}
		System.out.println(f.name + "�̃^�[��\n");
		int cd = cmdslc();
		if ( cd == 1 ) { f.attack(f, enemy); }
		else if ( cd == 2 ) { f.tokugi(f, enemy); }
		else if ( cd == 3 ) { f.sleep(f); }
		else if ( cd == 4 ) { f.run(); }
		if ( enemy.hp <= 0 ) {
			enemy.hp = 0;
			System.out.println(enemy.name +"�͗͐s�����B");
		}
		if ( f.mp <= 0 ) { f.mp = 0; }
	}
	
	public static void cdma(Mage m, Monster enemy, Character c) {
		if ( enemy.hp == 0 ) {
			return;
		} else {
			System.out.println(c.name + "�́A�̗́F" + c.hp + "�A���́F" + c.mp);
			System.out.println(m.name + "�́A�̗́F" + m.hp + "�A���́F" + m.mp);
			System.out.println(enemy.name + "�́A�̗́F" + enemy.hp + "�A���́F" + enemy.mp + "\n");
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
	
	public  static void cdmon(Monster enemy, Character c, Character c2) {
		System.out.println(c2.name + "�́A�̗́F" + c2.hp + "�A���́F" + c2.mp);
		System.out.println(c.name + "�́A�̗́F" + c.hp + "�A���́F" + c.mp);
		System.out.println(enemy.name + "�́A�̗́F" + enemy.hp + "�A���́F" + enemy.mp + "\n");
		if ( enemy.hp == 0 ) {
			System.out.println(enemy.name + "�͎���ł���B");
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
}