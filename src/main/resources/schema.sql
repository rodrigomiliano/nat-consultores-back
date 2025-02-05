-- Crear base de datos
CREATE DATABASE NatConsultores;

USE NatConsultores;

-- Crear tabla de tareas
CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT PRIMARY KEY IDENTITY(1,1),
    title NVARCHAR(100) NOT NULL,
    description NVARCHAR(MAX),
    created_at DATETIME DEFAULT GETDATE(),
    due_date DATE NULL,
    status NVARCHAR(20) CHECK (status IN ('PENDING', 'IN_PROGRESS', 'COMPLETED')) NOT NULL,
    priority NVARCHAR(10) CHECK (priority IN ('HIGH', 'MEDIUM', 'LOW')) NOT NULL,
    category NVARCHAR(50) NULL
);
