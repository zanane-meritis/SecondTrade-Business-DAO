package fr.secondtrade.businessdao.business;
import java.util.List;

import fr.secondtrade.businessdao.entities.Agent;
import fr.secondtrade.businessdao.entities.Investor;

public interface IBusiness {
	public List<Agent> getAllAgents();
	public Agent getAgentById(long id);
	public List<Investor> getAllInverstors();
	public Investor getInvestorById(long id);
}
