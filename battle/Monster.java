public class Monster extends Character {
	public Monster(String nm) {
		name = nm;
		atk = 5;
		AdvRe.monNum++;
		System.out.println(this.name + "�̍U���́F" + atk + "�A�̗́F" + hp + "�A���́F" + mp + "���B\n");
	}
	
	public void tokugi(Character m, Character tgt) {
		if ( m.mp >=5 ) {
			m.mp -= 5;
			tgt.hp -= m.atk*2;
			System.out.println(m.name + "�̃|�C�Y���A�^�b�N!");
			System.out.println(tgt.name + "�ɁA" + (m.atk*2) + "�_���[�W�^�����B");
		} else 
			System.out.println("MP������Ȃ��c\n�|�C�Y���A�^�b�N�Ɏ��s�����B");
	}
}