package com.ats.rusasoft.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ats.rusasoft.model.LoginLog;

public interface LoginLogRepo  extends JpaRepository<LoginLog, Integer> {

}
