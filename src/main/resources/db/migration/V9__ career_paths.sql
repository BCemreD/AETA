CREATE TABLE career_paths (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255) NULL
);


CREATE TABLE career_path_courses (
    career_path_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    order_no INT NOT NULL,
    PRIMARY KEY (career_path_id, course_id),
    FOREIGN KEY (career_path_id) REFERENCES career_paths(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);