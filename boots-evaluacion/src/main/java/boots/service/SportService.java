package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.SportRepository;
import boots.model.Sport;



@Service @Transactional
public class SportService {

private final SportRepository sportRepository;
	
	public SportService(SportRepository sportRepository){
		super();
		this.sportRepository = sportRepository;
	}
	
	public List<Sport> findAll(){
		List<Sport> sports = new ArrayList<Sport>();
		for(Sport sport : sportRepository.findAll()){
			sports.add(sport);
		}
		return sports;
	}
	
	public void save(Sport sport){
		sportRepository.save(sport);
	}
	
	public void delete(int id){
		sportRepository.delete(id);
	}
	
	public Sport findOne(int id){
		return sportRepository.findOne(id);
	}
	
}
