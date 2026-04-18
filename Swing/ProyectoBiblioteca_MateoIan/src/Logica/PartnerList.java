package Logica;

import java.util.ArrayList;

public class PartnerList {
	public static ArrayList<Partner>partnerList = new ArrayList<Partner>();

	public PartnerList() {
		partnerList = new ArrayList<>();
	}

	public void add(Partner partner) {
		partnerList.add(partner);
	}
	
	public void remove(int i) {
		partnerList.remove(i);
	}
	
	public int size() {
		return partnerList.size();
	}
	
	public Partner get(int i) {
		return partnerList.get(i);
	}
}
