public class Monster extends Character {
	public Monster(String nm) {
		name = nm;
		atk = 5;
		AdvRe.monNum++;
		System.out.println(this.name + "の攻撃力：" + atk + "、体力：" + hp + "、魔力：" + mp + "だ。\n");
	}
	
	public void tokugi(Character m, Character tgt) {
		if ( m.mp >=5 ) {
			m.mp -= 5;
			tgt.hp -= m.atk*2;
			System.out.println(m.name + "のポイズンアタック!");
			System.out.println(tgt.name + "に、" + (m.atk*2) + "ダメージ与えた。");
		} else 
			System.out.println("MPが足りない…\nポイズンアタックに失敗した。");
	}
}