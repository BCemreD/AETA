CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    image_src VARCHAR(500),
    image_alt VARCHAR(255),
    url VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NULL
);