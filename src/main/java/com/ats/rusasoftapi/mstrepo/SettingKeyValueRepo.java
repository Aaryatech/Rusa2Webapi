package com.ats.rusasoftapi.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.SettingKeyValue;
 
public interface SettingKeyValueRepo extends JpaRepository<SettingKeyValue, Integer>  {

	SettingKeyValue findBySettingKeyAndDelStatus(String string, int i);
	
	
	

}
