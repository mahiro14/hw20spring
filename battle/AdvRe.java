public class AdvRe extends Character{//9.1 クラスの拡張
	static int heroNum,monNum,count;

	public static void main(String[] args) {
		Object[] obj = new Object[3];//9.8 Objectクラス
		Character[] c = new Character[3];//8.2 オブジェクト型の配列 & 9.2 スーパークラスとサブクラスの使用　& 9.6 オーバーライドによる多様性
		obj = c;
		c[0] = new Fighter("Tarou");//7.2 オブジェクト型変数の代入 
		c[1] = new Mage("Jirou");
		c[2] = new Monster("Mash");
		
		System.out.println("バトルスタート！");
		System.out.println("ヒーローの" + c[0].name + "と" + c[1].name + "の前にモンスターの" + c[2].name + "が現れた。");
		while ( monNum >= 1 && heroNum >= 1 ) {
			status(c[0],c[0], c[1], c[2] );
			cdf(c[0], c[2], c[1]);
			status(c[1], c[0], c[1], c[2] );
			cdma(c[1], c[2], c[0]);
			status(c[2],c[0], c[1], c[2] );
			cdmon(c[2], c[0], c[1]);
			status(c[2],c[0], c[1], c[2] );
			cdmon(c[2], c[1], c[0]);
			if ( ( c[0].hp <= 0 || c[1].hp <= 0 ) && count == 0 ) {
				heroNum--;
				count++;
			} else if ( c[2].hp <= 0 ) {
				monNum--;
			}
		}
		if ( heroNum == 0 ) {
			System.out.println("ヒーローたちは、力尽きた…");
			System.out.println("GameOver");
		} else if ( monNum == 0 ) {
			System.out.println("モンスター" + c[2].name + "を倒した!");
			System.out.println("ヒーローたちの勝利!");
			System.out.println("Game Clear!!");
		}
	}
		
	public static void cdf(Character f, Character enemy, Character c) {
		if ( f.hp == 0 ) {
			System.out.println(f.name + "は死んでいる。");
			return;
		} else {
			System.out.println(f.name + "のターン\n");
			int cd = cmdslc();
			if ( cd == 1 ) { f.attack(f, enemy); }//7.3 値渡しと参照渡し　& 9.3 スーパークラスとサブクラスの関係
			else if ( cd == 2 ) { f.tokugi(f, enemy); }
			else if ( cd == 3 ) { f.sleep(f); }
			else if ( cd == 4 ) { f.run(); }
			if ( enemy.hp <= 0 ) {
				enemy.hp = 0;
				System.out.println(enemy.name +"は力尽きた。");
			}
			if ( f.mp <= 0 ) { f.mp = 0; }
		}
	}
	
	public static void cdma(Character m, Character enemy, Character c) {
		if ( enemy.hp == 0 ) {
			return;
		} else {
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
	
	public  static void cdmon(Character enemy, Character c, Character c2) {
		if ( c.hp == 0 ) {
			System.out.println(c.name + "は死んでいる。");
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
	
	public static void status(Character h, Character a, Character b, Character c) {
		if ( h.hp > 0 ) {
			System.out.println(a.name + "は、体力：" + a.hp + "、魔力：" + a.mp);
			System.out.println(b.name + "は、体力：" + b.hp + "、魔力：" + b.mp);
			System.out.println(c.name + "は、体力：" + c.hp + "、魔力：" + c.mp + "\n");
		}
	}
}