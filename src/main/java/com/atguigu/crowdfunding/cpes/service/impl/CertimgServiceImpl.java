package com.atguigu.crowdfunding.cpes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowdfunding.bean.Datas;
import com.atguigu.crowdfunding.bean.Page;
import com.atguigu.crowdfunding.cpes.bean.AccCertimg;
import com.atguigu.crowdfunding.cpes.bean.CertImg;
import com.atguigu.crowdfunding.cpes.dao.CertimgDao;
import com.atguigu.crowdfunding.cpes.service.CertimgService;

@Service
public class CertimgServiceImpl implements CertimgService {

	@Autowired
	private CertimgDao certimgDao;

	public Page<CertImg> queryCertimgDatas(Map<String, Object> paramMap) {
		// 分页对象
		Page<CertImg> cipage = new Page<CertImg>();
		
		// 查询数据
		List<CertImg> certimgs = certimgDao.queryCertImgDatas(paramMap);
		int index = 1;
		for ( CertImg ci : certimgs ) {
			ci.setIndex(index++);
		}
		
		// 查询数量
		int count = certimgDao.queryCertImgCount(paramMap);
		
		cipage.setData(certimgs);
		cipage.setRecordsTotal(count);
		cipage.setRecordsFiltered(count);
		
		return cipage;
	}

	public CertImg queryById(Integer id) {
		return certimgDao.queryById(id);
	}

	public void insertCertimg(CertImg ci) {
		certimgDao.insertCertimg(ci);
	}

	public void updateCertimg(CertImg ci) {
		certimgDao.updateCertimg(ci);
	}

	public void deleteCertimgs(Datas ds) {
		certimgDao.deleteCertimgs(ds);
	}

	public List<CertImg> queryAll() {
		return certimgDao.queryAll();
	}

	public void insertAccCertimg(Map<String, Object> paramMap) {
		certimgDao.insertAccCertimg(paramMap);
	}

	public void deleteAccCertimg(Map<String, Object> paramMap) {
		certimgDao.deleteAccCertimg(paramMap);
	}

	public List<AccCertimg> queryAccCertimgs() {
		return certimgDao.queryAccCertimgs();
	}
}
