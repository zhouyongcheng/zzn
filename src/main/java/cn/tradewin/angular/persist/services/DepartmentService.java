package cn.tradewin.angular.persist.services;

import java.util.List;

import cn.tradewin.angular.persist.model.Department;

public interface DepartmentService {
	int addDepartment(Department Department);
    int delDepartment(Byte id);
	int updDepartment(Department Department);
	Department findDepartment(Byte id);
	List<Department> getAllDepartments();
}
