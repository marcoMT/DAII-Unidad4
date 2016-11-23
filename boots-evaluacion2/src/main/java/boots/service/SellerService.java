package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.SellerRepository;
import boots.model.Seller;


@Service @Transactional
public class SellerService {

	private final SellerRepository sellerRepository;
	
	public SellerService(SellerRepository sellerRepository){
		super();
		this.sellerRepository = sellerRepository;
	}
	
	public List<Seller> findAll(){
		List<Seller> sellers = new ArrayList<Seller>();
		for(Seller seller : sellerRepository.findAll()){
			sellers.add(seller);
		}
		return sellers;
	}
	
	public void save(Seller seller){
		sellerRepository.save(seller);
	}
	
	public void delete(int id){
		sellerRepository.delete(id);
	}
	
	public Seller findOne(int id){
		return sellerRepository.findOne(id);
	}
}
