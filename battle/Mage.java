public class Mage extends Character {
	public Mage(String nm) {
		name = nm;
		atk = 3;
		mp = 50;
		AdvRe.heroNum++;
		System.out.println(this.name + "�̍U���́F" + atk + "�A�̗́F" + hp + "�A���́F" + mp + "���B");
	}
	
	public void tokugi(Character mg, Character tgt) {
		if ( mg.mp >=5 ) {
			mg.mp -= 5;
			tgt.hp -= mg.atk *5;
			System.out.println(mg.name + "�̖��@�U��!");
			System.out.println(tgt.name + "�ɁA" + (mg.atk *5) + "�_���[�W�^�����B");
		}else
			System.out.println("MP������Ȃ��c\n���@�U���Ɏ��s�����B");
	}
}