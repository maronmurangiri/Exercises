CREATE TABLE roles (
    role_id INT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL
);

CREATE TABLE positions (
    position_id INT PRIMARY KEY,
    position_name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    user_id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    position_id INT,
    role_id INT,
    created_at TIMESTAMP,
    FOREIGN KEY (position_id) REFERENCES positions(position_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

CREATE TABLE agents (
    agent_id INT PRIMARY KEY,
    user_id INT UNIQUE,
    number_of_tickets INT,
    resolved_ticket_count INT,
    assigned_ticket_id INT,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE tickets (
    ticket_id INT PRIMARY KEY,
    description TEXT,
    priority_level VARCHAR(20),
    agent_id INT,
    deadline_date TIMESTAMP,
    FOREIGN KEY (agent_id) REFERENCES agents(agent_id)
);
