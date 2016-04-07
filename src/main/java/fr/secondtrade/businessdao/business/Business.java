package fr.secondtrade.businessdao.business;

import java.util.List;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;

import fr.secondtrade.businessdao.entities.Agent;
import fr.secondtrade.businessdao.entities.Investor;
import fr.secondtrade.businessdao.entities.Issuer;
import fr.secondtrade.businessdao.repositories.AgentRepository;
import fr.secondtrade.businessdao.repositories.InvestorRepository;
import fr.secondtrade.businessdao.repositories.IssuerRepository;

@Service("Business")
public class Business implements IBusiness{
	// répositories
	@Autowired
	private AgentRepository agentRepository; 
	@Autowired
	private InvestorRepository investorRepository;
	@Autowired
	private IssuerRepository issuerRepository;
	
	@Override
	public List<Agent> getAllAgents() {
		return Lists.newArrayList(agentRepository.findAll());
	}
	@Override
	public Agent getAgentById(long id) {
		return agentRepository.findOne(id);
	}
	@Override
	public List<Investor> getAllInverstors() {
		return Lists.newArrayList(investorRepository.findAll());
	}
	@Override
	public Investor getInvestorById(long id) {
		return investorRepository.findOne(id);
	}
	@Override
	public List<Issuer> getAllIssuers() {
		return Lists.newArrayList(issuerRepository.findAll());
	}
	@Override
	public Issuer getIssuerById(long id) {
		return issuerRepository.findOne(id);
	}
}
