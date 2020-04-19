package com.raywenderlich.repository

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object Companies: Table("companies") {
    val id = long("id").autoIncrement()
    val name = varchar("name", 255)
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").default(LocalDateTime.now())
    val deletedAt = datetime("deleted_at").nullable()
    override val primaryKey = PrimaryKey(id, name = "pk_company_id")
}

object DepartmentsEmployees: Table("departments_employees") {
    val id = long("id").autoIncrement()
    val departmentId = long("department_id").references(Departments.id)
    val employeesId = long("employee_id").index().references(Employees.id)
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").default(LocalDateTime.now())
    val deletedAt = datetime("deleted_at").nullable()
    override val primaryKey = PrimaryKey(id, name = "pk_departments_employees_id")
}

object Departments: Table("departments") {
    val id = long("id").autoIncrement()
    val companyId = long("company_id").references(Companies.id)
    val name = varchar("name", 255)
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").default(LocalDateTime.now())
    val deletedAt = datetime("deleted_at").nullable()
    override val primaryKey = PrimaryKey(id, name = "pk_department_id")
}

object Employees: Table("emploees") {
    val id = long("id").autoIncrement()
    val familyName = varchar("family_name", 255)
    val givenName = varchar("given_name", 255)
    val createdAt = datetime("created_at").default(LocalDateTime.now())
    val updatedAt = datetime("updated_at").default(LocalDateTime.now())
    val deletedAt = datetime("deleted_at").nullable()
}
