package com.ats.rusasoftapi.mstrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.rusasoftapi.model.GetUserDetail;

public interface GetUserDataRepo extends JpaRepository<GetUserDetail, Integer>
{
    @Query(value=" SELECT p.principal_id as user_detail_id,p.principal_name as sub_user_name,p.phone_no as user_con_number,"
    		+ "p.email as user_email,0 as user_desn_id,0 as user_qual_id,p.institute_id as user_institute_id, p.is_enroll as "
    		+ "is_enroll,0 as dept_id from m_principal p where p.principal_id=:regKey  ", nativeQuery=true)
    GetUserDetail getPrinciDetails(@Param("regKey") int regKey);
	
    
    @Query(value=" SELECT i.iqac_id as user_detail_id,i.iqac_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,i.desgntn_id as user_desn_id,0 as user_qual_id,i.institute_id as user_institute_id,i.is_enroll_system as "
    		+ "is_enroll,0 as dept_id from m_iqac i  where i.iqac_id=:regKey ", nativeQuery=true)
    GetUserDetail getIqacDetails(@Param("regKey") int regKey);
    
    
    
    @Query(value=" SELECT i.hod_id as user_detail_id,i.hod_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,0 as user_desn_id,i.highest_qualification_id as user_qual_id,i.institute_id as user_institute_id,i.is_enroll_system as "
    		+ "is_enroll,dept_id as dept_id from m_hod i  where i.hod_id=:regKey ", nativeQuery=true)
    GetUserDetail getHodDetails(@Param("regKey") int regKey);
    
     
    
    @Query(value=" SELECT i.faculty_id as user_detail_id,i.faculty_first_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,i.current_designation_id as user_desn_id,	i.highest_qualification as user_qual_id,i.institute_id as user_institute_id,0 as "
    		+ "is_enroll,i.dept_id as dept_id from m_faculty i  where i.faculty_id=:regKey ", nativeQuery=true)
    GetUserDetail getFacultyDetails(@Param("regKey") int regKey);
	
    
    @Query(value=" SELECT i.officer_id as user_detail_id,i.	acc_officer_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,0 as user_desn_id,i.qualification_id as user_qual_id,i.institute_id as user_institute_id,0 as "
    		+ "is_enroll,0 as dept_id from m_acc_officer_reg i  where i.officer_id=:regKey ", nativeQuery=true)
    GetUserDetail getOfficerDetails(@Param("regKey") int regKey);
	
    
    @Query(value=" SELECT i.dean_id as user_detail_id,i.dean_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,0 as user_desn_id,i.qualification_id as user_qual_id,i.institute_id as user_institute_id,0 as "
    		+ "is_enroll,0 as dept_id from m_dean_reg i  where i.dean_id=:regKey ", nativeQuery=true)
    GetUserDetail getDeanDetails(@Param("regKey") int regKey);
    
    @Query(value=" SELECT i.librarian_id as user_detail_id,i.librarian_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,0 as user_desn_id,i.qualification_id as user_qual_id,i.institute_id as user_institute_id,0 as "
    		+ "is_enroll,0 as dept_id from m_librarian_reg i where i.librarian_id=:regKey ", nativeQuery=true)
    GetUserDetail getLibrarianDetails(@Param("regKey") int regKey);
    
	
    @Query(value=" SELECT i.student_id as user_detail_id,i.student_name as sub_user_name,i.contact_no as user_con_number,"
    		+ "i.email as user_email,0 as user_desn_id,0 as user_qual_id,i.institute_id as user_institute_id,0 as "
    		+ "is_enroll,i.dept_id as dept_id from m_student_reg i  where i.student_id=:regKey ", nativeQuery=true)
    GetUserDetail getStudentDetails(@Param("regKey") int regKey);
	
	
	

}
