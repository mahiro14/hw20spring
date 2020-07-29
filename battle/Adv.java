public class Adv extends Character{
	static int heroNum,monNum;

	public static void main(String[] args) {
		Fighter f1 = new Fighter("Tarou");
		Mage mg1 = new Mage("Jirou");
		Monster m1 = new Monster("Mash");
		
		System.out.println("バトルスタート！");
		System.out.println("ヒーローの" + f1.name + "と" + mg1.name + "の前にモンスターの" + m1.name + "が現れた。");
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
			System.out.println("ヒーローたちは、力尽きた…");
			System.out.println("GameOver");
		} else if ( monNum == 0 ) {
			System.out.println("モンスター" + m1.name + "を倒した!");
			System.out.println("ヒーローたちの勝利!");
			System.out.println("Game Clear!!");
		}
	}
		
	public static void cdf(Fighter f, Monster enemy, Character c) {
		System.out.println(f.name + "は、体力：" + f.hp + "、魔力：" + f.mp);
		System.out.println(c.name + "は、体力：" + c.hp + "、魔力：" + c.mp);
		System.out.println(enemy.name + "は、体力：" + enemy.hp + "、魔力：" + enemy.mp +"\n");
		if ( f.hp == 0 ) {
			System.out.println(f.name + "は死んでいる。");
			return;
		}
		System.out.println(f.name + "のターン\n");
		int cd = cmdslc();
		if ( cd == 1 ) { f.attack(f, enemy); }
		else if ( cd == 2 ) { f.tokugi(f, enemy); }
		else if ( cd == 3 ) { f.sleep(f); }
		else if ( cd == 4 ) { f.run(); }
		if ( enemy.hp <= 0 ) {
			enemy.hp = 0;
			System.out.println(enemy.name +"は力尽きた。");
		}
		if ( f.mp <= 0 ) { f.mp = 0; }
	}
	
	public static void cdma(Mage m, Monster enemy, Character c) {
		if ( enemy.hp == 0 ) {
			return;
		} else {
			System.out.println(c.name + "は、体力：" + c.hp + "、魔力：" + c.mp);
			System.out.println(m.name + "は、体力：" + m.hp + "、魔力：" + m.mp);
			System.out.println(enemy.name + "は、体力：" + enemy.hp + "、魔力：" + enemy.mp + "\n");
			if ( m.hp == 0 ) {
				System.out.println(m.name + "は死んでいる。");
				return;
			}
			System.out.println(m.name + "のターン\n");
			int cd = cmdslc();
			if ( cd == 1 ) { m.attack(m, enemy); }
			else if ( cd == 2 ) { m.tokugi(m, enemy);}
			else if ( cd == 3 ) { m.sleep(m); }
			else if ( cd == 4 ) { m.run(); }
			if ( enemy.hp <= 0 ) {
				enemy.hp = 0;
				System.out.println(enemy.name +"は力尽きた。");
			}
			if ( m.mp <= 0 ) { m.mp = 0; }
		}
	}
	
	public  static void cdmon(Monster enemy, Character c, Character c2) {
		System.out.println(c2.name + "は、体力：" + c2.hp + "、魔力：" + c2.mp);
		System.out.println(c.name + "は、体力：" + c.hp + "、魔力：" + c.mp);
		System.out.println(enemy.name + "は、体力：" + enemy.hp + "、魔力：" + enemy.mp + "\n");
		if ( enemy.hp == 0 ) {
			System.out.println(enemy.name + "は死んでいる。");
		} else {
			System.out.println(enemy.name + "の" + c.name + "へのターン");
			int cd = cmdslc();
			if ( cd == 1 ) { enemy.attack(enemy, c); }
			else if ( cd == 2 ) { enemy.tokugi(enemy, c); }
			else if ( cd == 3 ) { enemy.sleep(enemy); }
			else if ( cd == 4 ) { enemy.run(); }
			if ( c.hp <= 0 ) {
				c.hp = 0;
				System.out.println(c.name +"は力尽きた。");
			}
			if ( enemy.mp <= 0 ) { enemy.mp = 0; }
		}
	}
	
	public static int cmdslc() {
		System.out.println("どうする？\n");
		System.out.println(" 1:こうげき\n 2:とくぎ\n 3:ねむる\n 4:にげる");
		int cd = new java.util.Scanner(System.in).nextInt();
		return cd;
	}
}