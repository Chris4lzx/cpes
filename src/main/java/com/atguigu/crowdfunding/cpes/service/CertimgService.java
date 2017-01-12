package com.atguigu.crowdfunding.cpes.service;

import java.util.List;
import java.util.Map;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.AccCertimg;
import com.atguigu.crowdfunding.cpes.bean.CertImg;

public interface CertimgService {

	Page<CertImg> queryCertimgDatas(Map<String, Object> paramMap);

	CertImg queryById(Integer id);

	void insertCertimg(CertImg ci);

	void updateCertimg(CertImg ci);

	void deleteCertimgs(Datas ds);

	List<CertImg> queryAll();

	void insertAccCertimg(Map<String, Object> paramMap);

	void deleteAccCertimg(Map<String, Object> paramMap);

	List<AccCertimg> queryAccCertimgs();

}
