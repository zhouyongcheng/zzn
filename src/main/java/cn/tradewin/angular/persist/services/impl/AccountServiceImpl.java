package cn.tradewin.angular.persist.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;

import cn.tradewin.angular.persist.mapper.AccountMapper;
import cn.tradewin.angular.persist.model.Account;
import cn.tradewin.angular.persist.services.AccountService;

public class AccountServiceImpl implements AccountService {

	private final SqlSessionFactory sqlSessionFactory;
	private final Logger log;
	
	public AccountServiceImpl(SqlSessionFactory sqlSessionFactory, Logger log) {
		this.sqlSessionFactory = sqlSessionFactory;
		this.log = log;
	}
	
	@Override
	public int addAccount(Account account) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			AccountMapper mapper = session.getMapper(AccountMapper.class);
			int iCount = mapper.insert(account);
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
	public int delAccount(String id) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			AccountMapper mapper = session.getMapper(AccountMapper.class);
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
	public int updAccount(Account account) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			AccountMapper mapper = session.getMapper(AccountMapper.class);
			int iCount = mapper.updateByPrimaryKey(account);
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
	public Account findAccount(String id) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			AccountMapper mapper = session.getMapper(AccountMapper.class);
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
	public List<Account> getAllAccounts() {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			AccountMapper mapper = session.getMapper(AccountMapper.class);
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