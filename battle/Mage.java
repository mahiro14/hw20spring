public class Mage extends Character {
	public Mage(String nm) {
		name = nm;
		atk = 3;
		mp = 50;
		AdvRe.heroNum++;
		System.out.println(this.name + "の攻撃力：" + atk + "、体力：" + hp + "、魔力：" + mp + "だ。");
	}
	
	public void tokugi(Character mg, Character tgt) {
		if ( mg.mp >=5 ) {
			mg.mp -= 5;
			tgt.hp -= mg.atk *5;
			System.out.println(mg.name + "の魔法攻撃!");
			System.out.println(tgt.name + "に、" + (mg.atk *5) + "ダメージ与えた。");
		}else
			System.out.println("MPが足りない…\n魔法攻撃に失敗した。");
	}
}