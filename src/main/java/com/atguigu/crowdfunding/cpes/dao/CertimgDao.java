package com.atguigu.crowdfunding.cpes.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.AccCertimg;
import com.atguigu.crowdfunding.cpes.bean.CertImg;

public interface CertimgDao {

	List<CertImg> queryCertImgDatas(Map<String, Object> paramMap);

	int queryCertImgCount(Map<String, Object> paramMap);

	CertImg queryById(Integer id);

	void deleteCertimgs(Datas ds);

	void insertCertimg(CertImg ci);

	void updateCertimg(CertImg ci);

	List<CertImg> queryAll();

	void insertAccCertimg(Map<String, Object> paramMap);

	void deleteAccCertimg(Map<String, Object> paramMap);

	List<AccCertimg> queryAccCertimgs();

}
