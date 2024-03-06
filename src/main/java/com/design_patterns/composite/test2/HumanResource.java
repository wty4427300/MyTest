package com.design_patterns.composite.test2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class HumanResource {
    @Getter
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public abstract double calculateSalary();
}

/**
 * 员工
 */
class Employee extends HumanResource {
    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    public List<Long> getDepartmentEmployeeIds(Long id) {
        return null;
    }

    public double getEmployeeSalary(Long id) {
        return this.salary;
    }
}

/**
 * 部门
 */
class Department extends HumanResource {
    /**
     * 部门下有部门,也有员工
     */
    private final List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource hr : subNodes) {
            totalSalary += hr.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }

    public List<Long> getSubDepartmentIds(Long id) {
        return null;
    }
}

// 构建组织架构的代码
class Demo {
    private static final long ORGANIZATION_ROOT_ID = 1001;
    private Department departmentRepo; // 依赖注入
    private Employee employeeRepo; // 依赖注入

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    private void buildOrganization(Department department) {
        //构建部门
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        //构建员工
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }
}
