public class Character {
	int atk,hp,mp,spd;
	String name;
	
	public Character() {
		hp = 100;//7.1 ��{�^�ϐ��̑��
		atk = 10;
		mp = 20;
	}
	
	public final void attack(Character c, Character tgt) {//9.7 �C���q�Ffinal�ɂ�鐧��
		tgt.hp -= c.atk;
		System.out.println(c.name + "�̂�������!");
		System.out.println(tgt.name + "�ɁA" + c.atk + "�_���[�W��^�����B");
	}
	
	public final void sleep(Character c) {
		System.out.println("�͖������B");
		if ( c.hp <= 95) {
			System.out.println(c.name + "�́A5�|�C���g�񕜂���!");
			c.hp += 5;
		} else {
			System.out.println(c.name + "�́A" + (100-c.hp) + "�|�C���g�񕜂���!");
			c.hp = 100;
		}
	}
	
	public void tokugi(Character c, Character tgt) {}
	
	public final void run() {
		System.out.println("��m�����͓����o�����I");
		System.out.println("GameOver");
	}
}