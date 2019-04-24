package com.ats.rusasoftapi.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.rusasoftapi.model.LoginLog;

public interface LoginLogRepo  extends JpaRepository<LoginLog, Integer> {

}
