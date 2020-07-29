public class Fighter extends Character {
	public Fighter(String nm) {
		name = nm;
		atk = super.atk;
		AdvRe.heroNum++;
		System.out.println(this.name + "の攻撃力：" + atk + "、体力：" + hp + "、魔力：" + mp + "だ。");

	}
	
	public void tokugi(Character f,Character tgt) {
		if ( f.mp >=5 ) {
			f.mp -= 5;
			tgt.hp -= f.atk *2;
			System.out.println(f.name + "のパワーアタック!");
			System.out.println(tgt.name + "に、" + (f.atk *2) + "ダメージ与えた。");
		} else
			System.out.println("MPが足りない…\nパワーアタックに失敗した。");
	}
}
