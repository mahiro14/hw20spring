public class Character {
	int atk,hp,mp,spd;
	String name;
	
	public Character() {
		hp = 100;//7.1 基本型変数の代入
		atk = 10;
		mp = 20;
	}
	
	public final void attack(Character c, Character tgt) {//9.7 修飾子：finalによる制御
		tgt.hp -= c.atk;
		System.out.println(c.name + "のこうげき!");
		System.out.println(tgt.name + "に、" + c.atk + "ダメージを与えた。");
	}
	
	public final void sleep(Character c) {
		System.out.println("は眠った。");
		if ( c.hp <= 95) {
			System.out.println(c.name + "は、5ポイント回復した!");
			c.hp += 5;
		} else {
			System.out.println(c.name + "は、" + (100-c.hp) + "ポイント回復した!");
			c.hp = 100;
		}
	}
	
	public void tokugi(Character c, Character tgt) {}
	
	public final void run() {
		System.out.println("戦士たちは逃げ出した！");
		System.out.println("GameOver");
	}
}