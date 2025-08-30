CREATE TABLE favorites (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NULL,
    CONSTRAINT fk_fav_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_fav_course FOREIGN KEY (course_id) REFERENCES courses(id),
    CONSTRAINT uq_favorite UNIQUE (user_id, course_id)
);