public class Fighter extends Character {
	public Fighter(String nm) {
		name = nm;
		atk = super.atk;//9.5 �X�[�p�[�N���X�̃����o�ւ̖����I�ȃA�N�Z�X
		AdvRe.heroNum++;
		System.out.println(this.name + "�̍U���́F" + atk + "�A�̗́F" + hp + "�A���́F" + mp + "���B");

	}
	
	public void tokugi(Character f,Character tgt) {//9.4 �I�[�o�[���C�h
		if ( f.mp >=5 ) {
			f.mp -= 5;
			tgt.hp -= f.atk *2;
			System.out.println(f.name + "�̃p���[�A�^�b�N!");
			System.out.println(tgt.name + "�ɁA" + (f.atk *2) + "�_���[�W�^�����B");
		} else
			System.out.println("MP������Ȃ��c\n�p���[�A�^�b�N�Ɏ��s�����B");
	}
}