/*package com.gll.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gll.model.AnnotationModel;
import com.gll.model.Comment;

@Repository("annotationDao")
public class AnnotationDaoImpl implements AnnotationDao {

	private static final Logger logger = Logger.getLogger(AnnotationDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(AnnotationModel annotationModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(annotationModel);

	}

	@Override
	public List<AnnotationModel> displayAll() {
		return (List<AnnotationModel>) sessionFactory.getCurrentSession().createCriteria(AnnotationModel.class).list();
		// return
		// (List<UserModel>)sessionFactory.getCurrentSession().createCriteria(UserModel.class).add(Restrictions.idEq(1)).list();
	}

	@Override
	public AnnotationModel display(int pinId) {
		return (AnnotationModel) sessionFactory.getCurrentSession().get(AnnotationModel.class, pinId);
	}

	@Override
	public void update(AnnotationModel annotationModel) {
		sessionFactory.getCurrentSession().saveOrUpdate(annotationModel);

	}

	@Override
	public void patch(AnnotationModel annotationModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int annotationId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM AnnotationModel WHERE pinId = " + annotationId)
				.executeUpdate();
	}

	@Override
	public List<AnnotationModel> getAnnotationsByUserName(String userName) {
		String hql = "FROM AnnotationModel A, User U FETCH ALL PROPERTIES WHERE A.userId = U.userId AND U.userName = :userName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("userName", userName);
		return (List<AnnotationModel>) query.list();
	}

	@Override
	public List<AnnotationModel> getAnnotationsByDomainName(String domainName) {
		logger.debug("********************** :DaoImpl->getAnnotationsByDomainName()->domainName = " + domainName);
		String hql = "FROM AnnotationModel A WHERE A.domainName = :domainName";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("domainName", domainName);
		return (List<AnnotationModel>) query.list();
	}

	@Override
	public List<AnnotationModel> getAnnotationsByRootDomain(String rootDomain) {
		String hql = "FROM AnnotationModel A WHERE A.rootDomain = :rootDomain";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("rootDomain", rootDomain);
		return (List<AnnotationModel>) query.list();
	}

	@Override
	public List<AnnotationModel> getAllComments(int pinId) {
		String hql = "SELECT C FROM Comment C INNER JOIN C.annotationModel A WHERE C.commentId=:pinId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("pinId", pinId);
		return (List<AnnotationModel>) query.list();
	}

	@Override
	public List<AnnotationModel> getAnnotationsbyPinId(int pinId) {
		String hql = "FROM AnnotationModel A WHERE A.pinId = :pinId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("pinId", pinId);
		return (List<AnnotationModel>) query.list();
	}

	@Override
	public void saveComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

}
*/