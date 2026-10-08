-- Phase 1: Drop redundant Hibernate-generated FK on reviews pointing to legacy user table
ALTER TABLE reviews
DROP FOREIGN KEY FKsdlcf7wf8l1k0m00gik0m6b1m;

-- Phase 2: Re-align tickets foreign key from legacy user table to authoritative users table
ALTER TABLE tickets
DROP FOREIGN KEY FKibwnxyawjl0bdr2f76b0mycf8;

ALTER TABLE tickets
ADD CONSTRAINT fk_tickets_user_id
FOREIGN KEY (user_id) REFERENCES users(id);

-- Phase 3: Extend authoritative users table with security, roles, and audit columns
ALTER TABLE users
ADD COLUMN password VARCHAR(255) DEFAULT NULL,
ADD COLUMN role VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER',
ADD COLUMN created_date DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6),
ADD COLUMN updated_date DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6);

-- Phase 4: Enforce uniqueness on username and email for authoritative users
ALTER TABLE users
ADD CONSTRAINT uq_users_email UNIQUE (email),
ADD CONSTRAINT uq_users_username UNIQUE (username);
