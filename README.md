# Aman Ahmed - Task Management System

## Overview

It is a Task Management System developed using Spring Boot, Spring Security, JWT Authentication, MySQL, Maven, and Cloudinary.

The project is divided into modules that handle authentication, authorization, issue management, sprint management, attachment management, and user profile management.

---

# Module 1: Authentication & Authorization

## Features

### User Authentication
- User Registration
- User Login
- User Logout
- JWT Token Generation
- JWT Token Validation

### Role-Based Authorization
- ADMIN
- MANAGER
- USER

### Password Management
- Forgot Password
- Reset Password
- Password Encryption using BCrypt

### Email Service
- Reset Password Email
- Email Logging

---

# Module 2: Project Management

## Issue Management
- Create Issue
- Update Issue
- Delete Issue
- View Issue Details
- Track Issue Status
- Assign Priority Levels

### Issue Status
- OPEN
- IN_PROGRESS
- RESOLVED
- CLOSED

### Issue Priority
- LOW
- MEDIUM
- HIGH
- CRITICAL

### Issue Type
- BUG
- TASK
- STORY
- IMPROVEMENT

---

## Sprint Management

### Features
- Create Sprint
- Update Sprint
- Delete Sprint
- View Sprint Details

### Sprint States
- PLANNED
- ACTIVE
- COMPLETED

---

## Attachment Management

### Features
- Upload Attachments
- Download Attachments
- Delete Attachments
- Associate Files with Issues

### Supported File Types
- PNG
- JPG
- JPEG
- PDF
- TXT
- DOC

### Maximum Upload Size
- 5 MB

---

## Cloudinary Integration

Cloudinary is used for storing attachments securely in the cloud.

### Benefits
- Secure Storage
- Public URLs
- Easy Retrieval
- Cloud-Based File Management

---

## User Profile Management

### Features
- Update User Profile
- View User Profile
- Manage User Information

---

# Technology Stack

## Backend
- Java 21
- Spring Boot
- Spring Security
- JWT Authentication

## Database
- MySQL
- Hibernate
- JPA

## File Storage
- Cloudinary

## Build Tool
- Maven

---

# Project Structure

src/main/java/com/Ayushi

├── Cloud

├── Config

├── Controller

├── DTO

├── Entity

├── Enum

├── Repository

├── Security

├── Services

---

# API Endpoints

## Authentication APIs

POST /api/user_auth/register

POST /api/user_auth/login

POST /api/user_auth/forgot_password

POST /api/user_auth/reset_password

POST /api/user_auth/logout

---

## Issue APIs

POST /api/issues

GET /api/issues

GET /api/issues/{id}

PUT /api/issues/{id}

DELETE /api/issues/{id}

---

## Sprint APIs

POST /api/sprints

GET /api/sprints

GET /api/sprints/{id}

PUT /api/sprints/{id}

DELETE /api/sprints/{id}

---

## Attachment APIs

POST /api/attachments/upload

GET /api/attachments/{id}

DELETE /api/attachments/{id}

---

# Database Tables

## Authentication Module
- user_auth
- email_logs

## Project Management Module
- issue
- issue_comment
- sprint
- attachment
- user_profile_update

---

# Screenshots

## Authentication
- User Registration API
- User Login API
- User Table in MySQL

## Issue Management
- Create Issue API
- Update Issue API
- Issue Table

## Sprint Management
- Create Sprint API
- Sprint Table

## Attachment Management
- Upload Attachment API
- Cloudinary Dashboard

## Database
- MySQL Workbench Tables

## Project Structure
- Eclipse Package Explorer

---

Task Management System using Spring Boot, JWT, MySQL, Maven, and Cloudinary.
