package com.ultimateqa.orm.services;

import com.ultimateqa.orm.entities.TestResult;
import com.ultimateqa.orm.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestResultService {
    public void saveTestResult(TestResult testResult) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(testResult);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
