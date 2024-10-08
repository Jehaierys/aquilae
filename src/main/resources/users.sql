-- Assuming you have a table named 'users' with the appropriate columns

INSERT INTO users (firstname, lastname, email, phone_number, password,
                   is_email_verified, is_phone_verified, is_enabled,
                   is_account_non_expired, is_account_non_locked,
                   is_credentials_non_expired, role)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '1234567890', 'password123',
     true, true, true, true, true, true, 'USER'),

    ('Jane', 'Smith', 'jane.smith@example.com', '0987654321', 'password456',
     true, true, true, true, true, true, 'ADMIN'),

    ('Alice', 'Johnson', 'alice.johnson@example.com', '1122334455', 'password789',
     false, true, true, true, true, true, 'USER'),

    ('Bob', 'Brown', 'bob.brown@example.com', '5566778899', 'password101',
     true, false, true, true, true, true, 'USER');
