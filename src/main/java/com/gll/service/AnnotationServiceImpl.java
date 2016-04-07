package com.gll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gll.dao.AnnotationDao;
import com.gll.model.AnnotationModel;

@Service("annotationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AnnotationServiceImpl implements AnnotationService {

	@Autowired
	private AnnotationDao annotationDao;
	
	@Override
	public void save(AnnotationModel annotationModel) {
		annotationDao.save(annotationModel);
	}

	@Override
	public List<AnnotationModel> displayAll() {
		return annotationDao.displayAll();
	}

	@Override
	public AnnotationModel display(int annotationId) {
		return annotationDao.display(annotationId);
	}

	@Override
	public void update(AnnotationModel annotationModel) {
		annotationDao.update(annotationModel);
	}

	@Override
	public void patch(AnnotationModel annotationModel) {
	}

	@Override
	public void delete(int annotationId) {
		annotationDao.delete(annotationId);
	}

	@Override
	public List<AnnotationModel> getAnnotationsByUserName(String userName) {
		return annotationDao.getAnnotationsByUserName(userName);
	}

}
