package play_game;

public interface UnitCommand {
	public void Skill(Unit target);
	public void attack(Unit target, int critical);
}
