package cn.tradewin.angular.persist.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import cn.tradewin.angular.persist.mapper.DepartmentMapper;
import cn.tradewin.angular.persist.model.Department;
import cn.tradewin.angular.persist.services.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private final SqlSessionFactory sqlSessionFactory;
	private final Logger log;
	
	public DepartmentServiceImpl(SqlSessionFactory sqlSessionFactory, Logger log) {
		this.sqlSessionFactory = sqlSessionFactory;
		this.log = log;
	}
	
	@Override
	public int addDepartment(Department Department) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			int iCount = mapper.insert(Department);
			session.commit();
			return  iCount;
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int delDepartment(Byte id) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			int iCount = mapper.deleteByPrimaryKey(id);
			session.commit();
			return  iCount;
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int updDepartment(Department Department) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			int iCount = mapper.updateByPrimaryKey(Department);
			session.commit();
			return  iCount;
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Department findDepartment(Byte id) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			return mapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Department> getAllDepartments() {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
			return mapper.selectByExample(null);
		} catch (Exception e) {
			if (session != null) {
				session.rollback();
			}
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
