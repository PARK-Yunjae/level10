package play_game;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle implements Stage {
	private UnitManager um = new UnitManager();
	private BattleManager bm = new BattleManager();
	private ArrayList<Unit> pList;
	private ArrayList<Unit> mList;
	private Random rd = new Random();
	private int member;
	private int mLife;
	private int pLife;

	public StageBattle() {
		pList = new ArrayList<Unit>();
		mList = new ArrayList<Unit>();
	}

	@Override
	public boolean update() {
		boolean turn = true;

		while (true) {
			if (turn) {
				check_Dead();
				if (pLife == 0)
					break;
				print_character();
				for (Unit p : pList) {
					check_Dead();
					if (mLife == 0 || pLife == 0)
						break;
					if (p.getName().equals("궁수") && p.getCurhp() > 0 && !p.isCc()) {
						int max = p.getMax();
						p.setMax(max/2);
						int critical = rd.nextInt(4);
						if (critical == 0) {
							System.out.println("[궁수]적 전체에게 공격력의 절반 데미지");
							for (int i = 0; i < mList.size(); i += 1) {
								check_Dead();
								if (mLife == 0 || pLife == 0)
									break;
								if (mList.get(i).getCurhp() > 0)
									p.attack(mList.get(i), 0);
							}
						} else {
							int idx = rd.nextInt(mList.size());
							p.attack(mList.get(idx), 1);
						}
						p.setMax(max);
					} else {
						if (p.getCurhp() > 0 && !p.isCc()) {
							int targetIdx = bm.attackIdx(mList);
							int critical = rd.nextInt(4);
							p.attack(mList.get(targetIdx), critical);
						}
						if (p.isCc()) {
							System.out.println("[%s] CC기(기절 침묵) 상태".formatted(p.getName()));
							p.setCc(false);
						}
					}
				}
				turn = !turn;
			} else {
				check_Dead();
				if (mLife == 0)
					break;
				for (Unit m : mList) {
					check_Dead();
					if (mLife == 0 || pLife == 0)
						break;
					if (m.getName().equals("늑대") && m.getCurhp() > 0 && !m.isCc()) {
						int max = m.getMax();
						m.setMax(max/2);
						int critical = rd.nextInt(4);
						if (critical == 0) {
							System.out.println("[늑대]적 전체에게 공격력의 절반 데미지");
							for (int i = 0; i < pList.size(); i += 1) {
								check_Dead();
								if (mLife == 0 || pLife == 0)
									break;
								if (pList.get(i).getCurhp() > 0)
									m.attack(pList.get(i), 0);
							}
						} else {
							int idx = rd.nextInt(pList.size());
							m.attack(pList.get(idx), 1);
						}
						m.setMax(max);
					} else {
						if (m.getCurhp() > 0 && !m.isCc()) {
							int targetIdx = bm.attackIdx(pList);
							int critical = rd.nextInt(4);
							m.attack(pList.get(targetIdx), critical);
						}
						if (m.isCc()) {
							System.out.println("[%s] CC기(기절 침묵) 상태".formatted(m.getName()));
							m.setCc(false);
						}
					}
				}
				turn = !turn;
			}
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
		member = rd.nextInt(4) + 2;
		pList.clear();
		mList.clear();
		for (int i = 0; i < member; i += 1) {
			pList.add(um.Unit_Rand_Set(300, 50));
		}
		member = rd.nextInt(4) + 2;
		for (int i = 0; i < member; i += 1) {
			mList.add(um.Unit_Rand_Set(150, 30));
		}
		pLife = pList.size();
		mLife = mList.size();
	}

	private void print_character() {
		System.out.println("======[PLAYER]======");
		for (int i = 0; i < pList.size(); i += 1) {
			pList.get(i).printData();
		}
		System.out.println("======[MONSTER]======");
		for (int i = 0; i < mList.size(); i += 1) {
			mList.get(i).printData();
		}
	}

	private void check_Dead() {
		int pNum = pList.size();
		int mNum = mList.size();
		for (int i = 0; i < pList.size(); i += 1) {
			if (pList.get(i).getCurhp() <= 0) {
				pNum -= 1;
			}
		}
		for (int i = 0; i < mList.size(); i += 1) {
			if (mList.get(i).getCurhp() <= 0) {
				mNum -= 1;
			}
		}
		pLife = pNum;
		mLife = mNum;
	}
}