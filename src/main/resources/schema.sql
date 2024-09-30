CREATE SEQUENCE if not exists sneakers_seq START WITH 1 INCREMENT BY 1;

-- Create the sneakers table
CREATE TABLE IF NOT EXISTS sneakers (
                                        id BIGINT PRIMARY KEY DEFAULT nextval('sneakers_seq'),
                                        model VARCHAR(255),  -- Removed NOT NULL
                                        size INT,            -- Removed NOT NULL
                                        quantity INT         -- Removed NOT NULL
);

-- Create the sequence for generating user IDs
CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

-- Create the users table
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
                                     firstname VARCHAR(255),  -- Removed NOT NULL
                                     lastname VARCHAR(255),   -- Removed NOT NULL
                                     email VARCHAR(100) UNIQUE,  -- Removed NOT NULL
                                     phone_number VARCHAR(20),  -- Removed NOT NULL
                                     password TEXT,      -- Removed NOT NULL
                                     is_email_verified BOOLEAN,  -- Removed NOT NULL
                                     is_phone_verified BOOLEAN,   -- Removed NOT NULL
                                     is_enabled BOOLEAN,          -- Removed NOT NULL
                                     is_account_non_expired BOOLEAN,  -- Removed NOT NULL
                                     is_account_non_locked BOOLEAN,     -- Removed NOT NULL
                                     is_credentials_non_expired BOOLEAN,  -- Removed NOT NULL
                                     role VARCHAR(50)            -- Removed NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS jwt_seq START WITH 1 INCREMENT BY 1 CACHE 3;
ALTER SEQUENCE jwt_seq INCREMENT BY 3;


-- Create the jwt table
CREATE TABLE IF NOT EXISTS jwt (
                                   id BIGINT PRIMARY KEY DEFAULT nextval('jwt_seq'),
                                   token VARCHAR(255) UNIQUE,  -- Removed NOT NULL
                                   token_type VARCHAR(50) DEFAULT 'BEARER',  -- Removed NOT NULL
                                   revoked BOOLEAN,            -- Removed NOT NULL
                                   expired BOOLEAN,            -- Removed NOT NULL
                                   user_id BIGINT,
                                   FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
